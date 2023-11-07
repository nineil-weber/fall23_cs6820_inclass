/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nineil
 */
public interface Visitor {
    public Object visit(ErrorNode n);
    public Object visit(AddNode n);
    public Object visit(MinusNode n);
    public Object visit(TimesNode n);
    public Object visit(DivNode n);
    public Object visit(IntNode n);
    public Object visit(DoubleNode n);
}
