import java_cup.runtime.Symbol;
import java.util.*;
import java.io.*;



public class calc 
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
			ExprParser parser = new ExprParser(new ExprLex(new BufferedReader(new FileReader(args[0]))));
			parse_tree = parser.parse();
                        System.out.println("end");
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
