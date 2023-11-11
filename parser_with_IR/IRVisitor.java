import java.util.ArrayList;

public class IRVisitor implements Visitor
{

    int temporaryNumber = 0;

    public ArrayList<Quadruple> IR = new ArrayList<Quadruple>();
    public ArrayList< ArrayList<Quadruple> > IR_f = new ArrayList< ArrayList<Quadruple> >();

    public void reset()
    {
        temporaryNumber = 0;
        IR = new ArrayList<Quadruple>();
    }

    public Object visit(AddNode n) 
    {
        Node lhs = n.children.get(0); Node rhs = n.children.get(1);
        Object l = lhs.accept(this); 
        Object r = rhs.accept(this);
        String arg1; String arg2;
        if(lhs instanceof IntNode || lhs instanceof DoubleNode)
            arg1 = "" + l;
        else
            arg1 = "t" + l;
        if(rhs instanceof IntNode || rhs instanceof DoubleNode)
            arg2 = "" + r;
        else
            arg2 = "t" + r;
        IR.add(new Quadruple("+", arg1, arg2, "t" + temporaryNumber));
        return temporaryNumber++;
    }

    public Object visit(DivNode n)
    {
        Node lhs = n.children.get(0); Node rhs = n.children.get(1);
        Object l = lhs.accept(this);
        Object r = rhs.accept(this);
        String arg1; String arg2;
        if(lhs instanceof IntNode || lhs instanceof DoubleNode)
            arg1 = "" + l;
        else
            arg1 = "t" + l;
        if(rhs instanceof IntNode || rhs instanceof DoubleNode)
            arg2 = "" + r;
        else
            arg2 = "t" + r;
        IR.add(new Quadruple("/", arg1, arg2, "t" + temporaryNumber));
        return temporaryNumber++;
    }


    public Object visit(MinusNode n) 
    {
        Node lhs = n.children.get(0); Node rhs = n.children.get(1);
        Object l = lhs.accept(this); 
        Object r = rhs.accept(this);
        String arg1; String arg2;
        if(lhs instanceof IntNode || lhs instanceof DoubleNode)
            arg1 = "" + l;
        else
            arg1 = "t" + l;
        if(rhs instanceof IntNode || rhs instanceof DoubleNode)
            arg2 = "" + r;
        else
            arg2 = "t" + r;
        IR.add(new Quadruple("-", arg1, arg2, "t" + temporaryNumber));
        return temporaryNumber++;
    }


    public Object visit(TimesNode n) 
    {
        Node lhs = n.children.get(0); Node rhs = n.children.get(1);
        Object l = lhs.accept(this); 
        Object r = rhs.accept(this);
        String arg1; String arg2;
        if(lhs instanceof IntNode || lhs instanceof DoubleNode)
            arg1 = "" + l;
        else
            arg1 = "t" + l;
        if(rhs instanceof IntNode || rhs instanceof DoubleNode)
            arg2 = "" + r;
        else
            arg2 = "t" + r;
        IR.add(new Quadruple("*", arg1, arg2, "t" + temporaryNumber));
        return temporaryNumber++;
    }

    public Object visit(ErrorNode n) 
    {
        Node lhs = n.children.get(0); Node rhs = n.children.get(1);
        Object l = lhs.accept(this); 
        Object r = rhs.accept(this);
        String arg1; String arg2;
        if(lhs instanceof IntNode || lhs instanceof DoubleNode)
            arg1 = "" + l;
        else
            arg1 = "t" + l;
        if(rhs instanceof IntNode || rhs instanceof DoubleNode)
            arg2 = "" + r;
        else
            arg2 = "t" + r;
        IR.add(new Quadruple("error", arg1, arg2, "t" + temporaryNumber));
        return temporaryNumber++;
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
