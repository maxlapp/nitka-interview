package me.maxlapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void createTree() {
        final Tree<String> tree = new Tree<String>(new TreeNode<String>("root"));
        assertEquals(0, tree.height());
    }

    @Test
    public void fillingTreeAndHeight() {
        final Tree<String> tree = new Tree<String>(new TreeNode<String>("root"));
        tree.getRoot().addChildNodes(
                new TreeNode<String>("1"),
                new TreeNode<String>("2").addChildNodes(
                        new TreeNode<String>("2.1"),
                        new TreeNode<String>("2.2")),
                new TreeNode<String>("3").addChildNodes(
                        new TreeNode<String>("3.1"),
                        new TreeNode<String>("3.2"),
                        new TreeNode<String>("3.3").addChildNodes(
                                new TreeNode<String>("3.3.1"))));
        assertEquals(3, tree.height());
    }

    @Test
    public void fillingTreeAndHeight2() {
        final Tree<String> tree = new Tree<String>(new TreeNode<String>("root"));
        tree.getRoot().addChildNodes(
                new TreeNode<String>("1"),
                new TreeNode<String>("2").addChildNodes(
                        new TreeNode<String>("2.1"),
                        new TreeNode<String>("2.2").addChildNodes(
                                new TreeNode<String>("2.2.1").addChildNodes(
                                        new TreeNode<String>("2.2.1.1")
                                )
                        )
                ),
                new TreeNode<String>("3").addChildNodes(
                        new TreeNode<String>("3.1"),
                        new TreeNode<String>("3.2"),
                        new TreeNode<String>("3.3").addChildNodes(
                                new TreeNode<String>("3.3.1")
                        )
                )
        );
        assertEquals(4, tree.height());
    }

}
