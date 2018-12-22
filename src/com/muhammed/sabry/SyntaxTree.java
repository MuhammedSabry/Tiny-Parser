package com.muhammed.sabry;

import org.antlr.v4.runtime.tree.ParseTree;

class SyntaxTree {
    private SyntaxTreeNode root;

    SyntaxTree(String data) {
        this.root = new SyntaxTreeNode(data);
    }

    SyntaxTreeNode getRoot() {
        return root;
    }

    void preOrderTraverse(ParseTree parseTree, SyntaxTreeNode rootNode) {
        if (parseTree.getChildCount() == 0)
            return;
        for (int i = 0; i < parseTree.getChildCount(); i++) {
            ParseTree child = parseTree.getChild(i);
            SyntaxTreeNode syntaxChild = null;
            if (child instanceof TLParser.EqExpressionContext) {
                syntaxChild = new SyntaxTreeNode("op " + "=");//3 children (stmt,value,stmt)
                preOrderTraverse(child.getChild(0), syntaxChild);
                preOrderTraverse(child.getChild(2), syntaxChild);
            } else if (child instanceof TLParser.Read_stmtContext) {
                syntaxChild = new SyntaxTreeNode("read " + child.getChild(1).toString());//2 children (value, what to read)
            } else if (child instanceof TLParser.CompExpressionContext) {
                syntaxChild = new SyntaxTreeNode("op " + child.getChild(0).toString());//child 1 is < || >
                preOrderTraverse(child.getChild(0), syntaxChild);
            } else if (child instanceof TLParser.IdentifierExpressionContext) {
                syntaxChild = new SyntaxTreeNode(child.getChild(0).toString());//1 Child which is it's value
                preOrderTraverse(child.getChild(0), syntaxChild);
            } else if (child instanceof TLParser.NumberExpressionContext) {
                syntaxChild = new SyntaxTreeNode(child.getChild(0).toString());// 1 child which is it's value
            } else if (child instanceof TLParser.Write_stmtContext) {
                syntaxChild = new SyntaxTreeNode("write ");//2 children (value,stmt)
                preOrderTraverse(child.getChild(1), syntaxChild);
            } else if (child instanceof TLParser.AddExpressionContext) {
                syntaxChild = new SyntaxTreeNode("op " + "+");//3 children (stmt,value,stmt)
                preOrderTraverse(child.getChild(0), syntaxChild);
                preOrderTraverse(child.getChild(2), syntaxChild);
            } else if (child instanceof TLParser.MultExpressionContext) {
                syntaxChild = new SyntaxTreeNode("op " + "*");
                preOrderTraverse(child.getChild(2), syntaxChild);
            } else if (child instanceof TLParser.IfStatementContext) {
                syntaxChild = new SyntaxTreeNode("if ");//4 children containing the if statement body
                preOrderTraverse(child, syntaxChild);
            } else if (child instanceof TLParser.Repeat_stmtContext) {
                syntaxChild = new SyntaxTreeNode("repeat ");//4 children (repeat,stmts,until,condition)
                preOrderTraverse(child.getChild(1), syntaxChild);
                preOrderTraverse(child.getChild(3), syntaxChild);
            } else if (child instanceof TLParser.AssignmentContext) {
                syntaxChild = new SyntaxTreeNode("assign " + child.getChild(0).toString());//3 children (var, value,stmt)
                preOrderTraverse(child.getChild(2), syntaxChild);
            } else {
                preOrderTraverse(child, rootNode);
            }

            if (syntaxChild != null) {
                rootNode.addChild(syntaxChild);
            }
        }
    }

}
