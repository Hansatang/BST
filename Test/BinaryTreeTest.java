import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }


    @Test
    void getRoot() {
        assertNull(binaryTree.getRoot());
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertNotNull(binaryTree.getRoot());
    }

    @Test
    void setRoot() {
        assertNull(binaryTree.getRoot());
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertEquals(binaryTree.getRoot().getElement(), 7);
    }

    @Test
    void isEmpty() {
        assertNull(binaryTree.getRoot());
        assertTrue(binaryTree.isEmpty());
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void inOrder() {
        assertNull(binaryTree.getRoot());
        binaryTree.setRoot(new BinaryTreeNode(7));
        binaryTree.getRoot().addRightChild(new BinaryTreeNode(10));
        binaryTree.getRoot().addLeftChild(new BinaryTreeNode(5));
        ArrayList list = new ArrayList();
        list.add(5);
        list.add(7);
        list.add(10);
        assertEquals(binaryTree.inOrder(), list);
    }


    @Test
    void size() {
        assertNull(binaryTree.getRoot());
        assertEquals(binaryTree.size(), 0);
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertEquals(binaryTree.size(), 1);
    }

    @Test
    void contains(){
        assertNull(binaryTree.getRoot());
        binaryTree = new BinarySearchTree();
        binaryTree.setRoot(new BinaryTreeNode(6));
        assertFalse(binaryTree.contains(3));
        binaryTree.getRoot().addLeftChild(new BinaryTreeNode(3));
        assertTrue(binaryTree.contains(3));
    }

    @Test
    void preOrder(){
        //assertNull(binaryTree.preOrder());
    }

    @Test
    void postOrder(){
        //assertNull(binaryTree.postOrder());
    }

    @Test
    void levelOrder(){
        //assertNull(binaryTree.levelOrder());
    }

    @Test
    void height(){
        //assertEquals(-1, binaryTree.height());
    }

}