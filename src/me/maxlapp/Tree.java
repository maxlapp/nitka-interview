package me.maxlapp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree<T> {
    private TreeNode<T> root;

    public Tree(TreeNode<T> rootNode) {
        this.root = rootNode;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public int height() {
        if (root.isLeaf()) {
            return 0;
        }

        int height = 0;

        Deque<List<TreeNode<T>>> stack = new ArrayDeque<List<TreeNode<T>>>();

        stack.push(new ArrayList<TreeNode<T>>(root.getChildNodes()));

        while (!stack.isEmpty()) {

            List<TreeNode<T>> levelNodes = stack.peek();

            if (levelNodes.isEmpty()) {
                stack.pop();
                continue;
            }

            TreeNode<T> dipPoint = null;
            do {
                dipPoint = levelNodes.remove(0);
            }
            while (dipPoint.isLeaf() && !levelNodes.isEmpty());

            if (dipPoint.isLeaf()) {
                stack.pop();
                continue;
            }

            stack.push(new ArrayList<TreeNode<T>>(dipPoint.getChildNodes()));

            if (height < stack.size()) {
                height = stack.size();
            }

        }

        return height;
    }

}
