package me.maxlapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode<T> {

    private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
    private T value;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public List<TreeNode<T>> getChildNodes() {
        return Collections.unmodifiableList(children);
    }

    public TreeNode<T> addChildNodes(TreeNode<T>... childNodes) {
        for (TreeNode<T> childNode: childNodes) {
            children.add(childNode);
        }
        return this;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

}
