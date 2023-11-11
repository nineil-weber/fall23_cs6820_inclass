/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nineil
 */
public class PrettyPrinter implements Visitor{
    public Object visit(DivNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        Object l; Object r;
        l = lhs.accept(this);
        System.out.print(" / ");
        r = rhs.accept(this);
 
        return 0;
    }

    public Object visit(TimesNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        Object l; Object r;
        l = lhs.accept(this);
        System.out.print(" * ");
        r = rhs.accept(this);
 
        return 0;
    }

    public Object visit(MinusNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        
        Object l; Object r;
        l = lhs.accept(this);
        System.out.print(" - ");
        r = rhs.accept(this);
 
        return 0;
    }

    public Object visit(AddNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        Object l; Object r;
        l = lhs.accept(this);
        System.out.print(" + ");
        r = rhs.accept(this);
        return 0;
    }

    public Object visit(ErrorNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        Object l; Object r;
        l = lhs.accept(this);
        System.out.print(" error ");
        r = rhs.accept(this);

        return 0;
    }


    public Object visit(DoubleNode n)
    {
        System.out.print(n.myDouble.doubleValue());        
        return 0;
    }


    public Object visit(IntNode n)
    {
        System.out.print(n.myInt.intValue());
        return 0;
    }
}
