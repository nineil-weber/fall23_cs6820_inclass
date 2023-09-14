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
    public int visit(DivNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        
        int l; int r;
        l = lhs.accept(this);
        r = rhs.accept(this);
        return l/r;
    }
    
    public int visit(TimesNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        int l; int r;

        l = lhs.accept(this);
        r = rhs.accept(this);
        return l*r;
    }
    
    public int visit(MinusNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        int l; int r;
        l = lhs.accept(this);
        r = rhs.accept(this);
        return l-r;
    }

    public int visit(AddNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        
        int l; int r;
        l = lhs.accept(this);
        r = rhs.accept(this);
        return l+r;
    }

    public int visit(IntNode n)
    {
        return n.myInt.intValue();
    }
}
