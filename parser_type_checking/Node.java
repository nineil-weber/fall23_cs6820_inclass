/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author nineil
 */
abstract class Node {
        Node parent;
        int line=-1;
        int col=-1;
        ArrayList<Node> children;
        public void setPosition(int l, int c)
        {
            line=l;
            col=c;
        }
        Node() { children = new ArrayList<Node>(); }
        public abstract Object accept(Visitor v);
}

class IntNode extends Node {
        Integer myInt;
        String type ="integer";

        public IntNode(Integer i, int l, int c)
        {
            myInt = i;
            setPosition(l, c);
        }

        public Object accept(Visitor v)
        {
            return v.visit(this);
        }
}

class DoubleNode extends Node{
        Double myDouble;
        String type="double";

        public DoubleNode(Double d, int l, int c)
        {
            myDouble = d;
            setPosition(l,c);
        }

        public Object accept(Visitor v)
        {
            return v.visit(this);
        }

}

class AddNode extends Node {
        public AddNode(Node l, Node r, int pl, int pc) {
            children.add(l);
            children.add(r);
            setPosition(pl, pc);
        }

        public Object accept(Visitor v)
        {
            return v.visit(this);
        }
}

class MinusNode extends Node {
        public MinusNode(Node l, Node r, int pl, int pc) {
            children.add(l);
            children.add(r);
            setPosition(pl, pc);
        }

        public Object accept(Visitor v)
        {
            return v.visit(this);
        }
}

class TimesNode extends Node {

        public TimesNode(Node l, Node r, int pl, int pc) {
            children.add(l);
            children.add(r);
            setPosition(pl, pc);
        }

        public Object accept(Visitor v)
        {
            return v.visit(this);
        }
}

class DivNode extends Node {

        public DivNode(Node l, Node r, int pl, int pc) {
            children.add(l);
            children.add(r);
            setPosition(pl, pc);
        }

        public Object accept(Visitor v)
        {
            return v.visit(this);
        }
}

class ErrorNode extends Node {

        public ErrorNode(Node l, Node r, int pl, int pc) {
            children.add(l);
            children.add(r);
            setPosition(pl, pc);
        }

        public Object accept(Visitor v)
        {
            return v.visit(this);
        }
}

