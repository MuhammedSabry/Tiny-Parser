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
        if (parseTree == null)
            return;
        if (parseTree.getChildCount() == 0)
            return;
        for (int i = 0; i < parseTree.getChildCount(); i++) {
            ParseTree child = parseTree.getChild(i);
            SyntaxTreeNode syntaxChild = null;
            boolean isOperation = false;
            if (parseTree instanceof TLParser.NumberExpressionContext)
                syntaxChild = new SyntaxTreeNode(parseTree.getText());

                //Read statement handling 2 children (value, what to read)
            else if (child instanceof TLParser.Read_stmtContext)
                syntaxChild = new SyntaxTreeNode("read " + child.getChild(1).toString());

            else if (child instanceof TLParser.EqExpressionContext) {
                syntaxChild = parseOperation(child, "op\n=");
                isOperation = true;
            } else if (child instanceof TLParser.CompExpressionContext) {
                syntaxChild = parseOperation(child, "op\n=");
                isOperation = true;
            } else if (child instanceof TLParser.AndExpressionContext) {
                syntaxChild = parseOperation(child, "op\n&&");
                isOperation = true;
            } else if (child instanceof TLParser.OrExpressionContext) {
                syntaxChild = parseOperation(child, "op\n||");
                isOperation = true;
            } else if (child instanceof TLParser.AddExpressionContext) {
                syntaxChild = parseOperation(child, "op\n+");
                isOperation = true;
            } else if (child instanceof TLParser.MultExpressionContext) {
                syntaxChild = parseOperation(child, "op\n*");
                isOperation = true;
            }

            //Identifier
            else if (child instanceof TLParser.IdentifierExpressionContext) {
                syntaxChild = new SyntaxTreeNode(child.getChild(0).toString());//1 Child which is it's value
                preOrderTraverse(child.getChild(0), syntaxChild);
            }
            //Numbers handling
            else if (child instanceof TLParser.NumberExpressionContext) {
                syntaxChild = new SyntaxTreeNode(child.getChild(0).toString());// 1 child which is it's value
            }
            //Write statement handling
            else if (child instanceof TLParser.Write_stmtContext) {
                syntaxChild = new SyntaxTreeNode("write ");//2 children (value,stmt)
                preOrderTraverse(child.getChild(1), syntaxChild);
            }
            //If statement handling
            else if (child instanceof TLParser.IfStatementContext) {
                syntaxChild = new SyntaxTreeNode("if");//4 children containing the if statement body
                preOrderTraverse(child, syntaxChild);
            }
            //Else statement handling (value, body)
            else if (child instanceof TLParser.ElseStatContext) {
                syntaxChild = new SyntaxTreeNode("else");
                preOrderTraverse(child.getChild(1), syntaxChild);
            }

            //If body (condition, value, body, end)
            else if (child instanceof TLParser.IfStatContext) {
                preOrderTraverse(child, rootNode);
                syntaxChild = new SyntaxTreeNode("then");
                preOrderTraverse(child.getChild(3), syntaxChild);
            }

            //Repeat Statement handling
            else if (child instanceof TLParser.Repeat_stmtContext) {
                syntaxChild = new SyntaxTreeNode("repeat");//4 children (repeat,stmts,until,condition)
                preOrderTraverse(child.getChild(1), syntaxChild);
                preOrderTraverse(child.getChild(3), syntaxChild);
            }

            //Assignment statement handling
            else if (child instanceof TLParser.AssignmentContext) {
                syntaxChild = new SyntaxTreeNode("assign\n" + child.getChild(0).toString());//3 children (var, value,stmt)
                preOrderTraverse(child.getChild(2), syntaxChild);
            }

            //Else we will just traverse the children
            else
                preOrderTraverse(child, rootNode);

            if (syntaxChild != null) {
                rootNode.addChild(syntaxChild);
                if (isOperation && rootNode.getData().equals("if"))
                    break;
            }
        }
    }

    private SyntaxTreeNode parseOperation(ParseTree child, String s) {
        SyntaxTreeNode syntaxChild = new SyntaxTreeNode(s);
        preOrderTraverse(child.getChild(0), syntaxChild);
        preOrderTraverse(child.getChild(2), syntaxChild);
        return syntaxChild;
    }

}
