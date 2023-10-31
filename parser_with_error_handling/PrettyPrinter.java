/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nineil
 */
public class PrettyPrinter implements Visitor{
    public int visit(DivNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        int l; int r;
        l = lhs.accept(this);
        System.out.print(" / ");
        r = rhs.accept(this);
        return 0;
    }

    public int visit(TimesNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);
        int l; int r;

        l = lhs.accept(this);
        System.out.print(" * ");
        r = rhs.accept(this);
        return 0;
    }

    public int visit(MinusNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        int l; int r;
        l = lhs.accept(this);
        System.out.print(" - ");
        r = rhs.accept(this);
        return 0;
    }

    public int visit(AddNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        int l; int r;
        l = lhs.accept(this);
        System.out.print(" + ");
        r = rhs.accept(this);
        return 0;
    }

    public int visit(ErrorNode n)
    {
        Node lhs = n.children.get(0);
        Node rhs = n.children.get(1);

        int l; int r;
        l = lhs.accept(this);
        System.out.print(" error ");
        r = rhs.accept(this);
        return 0;
    }



    public int visit(IntNode n)
    {
        System.out.print(n.myInt.intValue());
        return 0;
    }
}
