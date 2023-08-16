/*
  This example comes from a short article series in the Linux 
  Gazette by Richard A. Sevenich and Christopher Lopes, titled
  "Compiler Construction Tools". The article series starts at

  http://www.linuxgazette.com/issue39/sevenich.html

  Small changes and updates to newest JFlex+Cup versions 
  by Gerwin Klein
*/

/*
  Commented By: Christopher Lopes
  File Name: lcalc.flex
  To Create: > jflex lcalc.flex

  and then after the parser is created
  > javac Lexer.java
*/
   
/* --------------------------Usercode Section------------------------ */
   
import java_cup.runtime.*;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
/* 
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java. 
*/
%class Lexer

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column
    
/* 
   Will switch to a CUP compatibility mode to interface with a CUP
   generated parser.
*/
%cup

%standalone
   
/*
  Declarations
   
  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.  
*/
%{   

    public static final int NUMBER = 1;
    public static final int ID = 2;
    public static final int SEMI = 3;
    public static final int PLUS = 4;
    public static final int MINUS = 5;
    public static final int TIMES = 6;
    public static final int DIVIDE = 7;
    public static final int LPAREN = 8;
    public static final int RPAREN = 9;

    boolean b=false;

    int lineString = 0;
	int colString = 0;

    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private void prinToken1(String token)
	{
		int l=yyline+1;
		int c=yycolumn+1;
		System.out.println(l+"\t"+c+"\t"+token);
	}

    private void prinToken2(String token)
	{
		int l=yyline+1;
		int c=yycolumn+1;
		System.out.println(l+"\t"+c+"\t"+token+"\t"+yytext());
	}


%}
   

/*
  Macro Declarations
  
  These declarations are regular expressions that will be used latter
  in the Lexical Rules Section.  
*/
   
/* A line terminator is a \r (carriage return), \n (line feed), or
   \r\n. */
LineTerminator = \r|\n|\r\n
   
/* White space is a line terminator, space, tab, or line feed. */
WhiteSpace     = {LineTerminator} | [ \t\f]
   
/* A literal integer is is a number beginning with a number between
   one and nine followed by zero or more numbers between zero and nine
   or just a zero.  */
dec_int_lit = 0 | [1-9][0-9]*
   
/* A identifier integer is a word beginning a letter between A and
   Z, a and z, or an underscore followed by zero or more letters
   between A and Z, a and z, zero and nine, or an underscore. */
dec_int_id = [A-Za-z_][A-Za-z_0-9]*


%eofval{
	if(b==true)
		System.out.println("Unterminated string literal at line "+lineString+" column "+colString+" \n");
	System.exit(0);
%eofval}

%%
/* ------------------------Lexical Rules Section---------------------- */
   
/*
   This section contains regular expressions and actions, i.e. Java
   code, that will be executed when the scanner matches the associated
   regular expression. */
   
   /* YYINITIAL is the state at which the lexer begins scanning.  So
   these regular expressions will only be matched if the scanner is in
   the start state YYINITIAL. */
   
<YYINITIAL> {
   
    /* Return the token SEMI declared in the class sym that was found. */
    ";"                { return symbol(SEMI); }
   
    /* Print the token found that was declared in the class sym and then
       return it. */
    "+"                { prinToken1(" + "); return symbol(PLUS); }
    "-"                { prinToken1(" - "); return symbol(MINUS); }
    "*"                { prinToken1(" * "); return symbol(TIMES); }
    "/"                { prinToken1(" / "); return symbol(DIVIDE); }
    "("                { prinToken1(" ( "); return symbol(LPAREN); }
    ")"                { prinToken1(" ) "); return symbol(RPAREN); }
   
    /* If an integer is found print it out, return the token NUMBER
       that represents an integer and the value of the integer that is
       held in the string yytext which will get turned into an integer
       before returning */
    {dec_int_lit}      { prinToken2("NUMBER");
                         return symbol(NUMBER, new Integer(yytext())); }
   
    /* If an identifier is found print it out, return the token ID
       that represents an identifier and the default value one that is
       given to all identifiers. */
    {dec_int_id}       { prinToken2("ID");
                         return symbol(ID, new Integer(1));}
   
    /* Don't do anything if whitespace is found */
    {WhiteSpace}       { /* just skip what was found, do nothing */ }   
}


/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
[^]                    { System.out.print("Illegal character '"+yytext()+"' at line "+(yyline+1)+" column "+(yycolumn+1)+" \n"); }
