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
  File Name: Main.java
  To Create: 
  After the scanner, lcalc.flex, and the parser, ycalc.cup, have been created.
  > javac Main.java
  
  To Run: 
  > java Main test.txt
  where test.txt is an test input file for the calculator.
*/
   
//import java.io.*;
   
public class Main{
  static public void main(String[] args) {    
    /* Start the parser */
    try {
        System.out.println("Line\tColumn\tToken\tValue");
        System.out.println("====================================================");

        Lexer.main(args);
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}


