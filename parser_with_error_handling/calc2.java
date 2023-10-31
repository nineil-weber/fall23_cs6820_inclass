import java_cup.runtime.Symbol;
import java.util.*;
import java.io.*;

public class calc2
{
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.err.println("Usage: java Calc file.asm");
			System.exit(1);
		}

                Symbol parse_tree = null;
		try
		{			
                    //ExprParser parser_obj = new ExprParser(new ExprLex(new FileInputStream(args[0])));
                    ExprParser parser_obj = new ExprParser(new ExprLex(new BufferedReader(new FileReader(args[0]))));
                    parse_tree = parser_obj.parse();
                    ArrayList a = ((ArrayList)parse_tree.value);
                    Visitor v = new Interpreter();
                    Visitor v2= new PrettyPrinter();

                    System.out.println("");
                    System.out.println("--------");
                    System.out.println("ANALYSIS");
                    System.out.println("--------");
                    System.out.println("");

                    for(Iterator iter=a.iterator(); iter.hasNext(); )
                    {
                        Node root = (Node)iter.next();
                        /*int result = root.visit();
                        System.out.println(" = " + result);*/
                        System.out.println("Visitor:");
                        int result = root.accept(v);
                        System.out.println(" = " + result);
                        System.out.println("Visitor-2:");
                        root.accept(v2);
                        System.out.println();
                    }
		}
		catch (java.io.IOException e)
		{
			System.err.println("Unable to open file: " + args[0]);
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
		}
	}
}
