package com.muhammed.sabry;

import java.util.LinkedList;
import java.util.List;

public class SyntaxTreeNode {

    private String data;
    private SyntaxTreeNode parent;
    private List<SyntaxTreeNode> children;

    SyntaxTreeNode(String data) {
        this.data = data;
        children = new LinkedList<>();
    }

    private void setParent(SyntaxTreeNode parent) {
        this.parent = parent;
        parent.children.add(this);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    void addChild(SyntaxTreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    List<SyntaxTreeNode> getChildren() {
        return this.children;
    }
}
