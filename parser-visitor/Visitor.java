/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nineil
 */
public interface Visitor {
    public int visit(AddNode n);
    public int visit(MinusNode n);
    public int visit(TimesNode n);
    public int visit(DivNode n);
    public int visit(IntNode n);
}
