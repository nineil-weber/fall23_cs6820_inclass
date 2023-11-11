/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nineil
 */
public class Interpreter implements Visitor
{

    public Object visit(DivNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        
        Object l; Object r;
        l = lhs.accept(this);
        r = rhs.accept(this);

        if(l instanceof Integer && r instanceof Integer)            
            return ((Number)l).intValue()/((Number)r).intValue();
        else if(l instanceof Double && r instanceof Double)
            return ((Number)l).doubleValue()/((Number)r).doubleValue();
        else
        {   
            System.out.println("Warning: two different types -- casting to double");
            return ((Number)l).doubleValue()/((Number)r).doubleValue();
        }

    }
    
    public Object visit(TimesNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        Object l; Object r;

        l = lhs.accept(this);
        r = rhs.accept(this);

        if(l instanceof Integer && r instanceof Integer)            
            return ((Number)l).intValue()*((Number)r).intValue();
        else if(l instanceof Double && r instanceof Double)
            return ((Number)l).doubleValue()*((Number)r).doubleValue();
        else
        {   
            System.out.println("Warning: two different types -- casting to double");
            return ((Number)l).doubleValue()*((Number)r).doubleValue();
        }

    }
    
    public Object visit(MinusNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        Object l; Object r;
        l = lhs.accept(this);
        r = rhs.accept(this);

        if(l instanceof Integer && r instanceof Integer)            
            return ((Number)l).intValue()-((Number)r).intValue();
        else if(l instanceof Double && r instanceof Double)
            return ((Number)l).doubleValue()-((Number)r).doubleValue();
        else
        {   
            System.out.println("Warning: two different types -- casting to double");
            return ((Number)l).doubleValue()-((Number)r).doubleValue();
        }
    }

    public Object visit(AddNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        
        Object l; Object r;
        l = lhs.accept(this);
        r = rhs.accept(this);


        if(l instanceof Integer && r instanceof Integer)            
            return ((Number)l).intValue()+((Number)r).intValue();
        else if(l instanceof Double && r instanceof Double)
            return ((Number)l).doubleValue()+((Number)r).doubleValue();
        else
        {   
            System.out.println("Warning: two different types -- casting to double");
            return ((Number)l).doubleValue()+((Number)r).doubleValue();
        }
    }

    public Object visit(ErrorNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        
        Object l; Object r;
        l = lhs.accept(this);
        r = rhs.accept(this);
        return 0;
    }

    public Object visit(DoubleNode n)
    {
        return n.myDouble.doubleValue();
    }

    public Object visit(IntNode n)
    {
        return n.myInt.intValue();
    }
}
