import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }

    @Test
    void getElement() {
        assertNull(binaryTree.getRoot());
        assertThrows(NullPointerException.class, ()-> {
            assertEquals(binaryTree.getRoot().getElement(),null);
        });
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertEquals(binaryTree.getRoot().getElement(), 7);
    }

    @Test
    void setElement() {
        assertNull(binaryTree.getRoot());
        assertThrows(NullPointerException.class, () -> {
           binaryTree.getRoot().setElement(null);
        });
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertEquals(binaryTree.getRoot().getElement(), 7);
        binaryTree.getRoot().setElement(2);
        assertEquals(binaryTree.getRoot().getElement(),2);
    }

    @Test
    void getLeftChild() {
        assertNull(binaryTree.getRoot());
        binaryTree.root = new BinaryTreeNode(7);
        assertNull(binaryTree.getRoot().getLeftChild());
        binaryTree.getRoot().left = new BinaryTreeNode(2);
        assertNotNull(binaryTree.getRoot().getLeftChild());
    }

    @Test
    void getRightChild() {
        assertNull(binaryTree.getRoot());
        binaryTree.root = new BinaryTreeNode(7);
        assertNull(binaryTree.getRoot().getRightChild());
        binaryTree.getRoot().right = new BinaryTreeNode(14);
        assertNotNull(binaryTree.getRoot().getRightChild());
    }

    @Test
    void addLeftChild() {
        assertNull(binaryTree.getRoot());
        binaryTree.root = new BinaryTreeNode(7);
        assertNull(binaryTree.getRoot().getLeftChild());
        binaryTree.getRoot().addLeftChild(new BinaryTreeNode(2));
        assertNotNull(binaryTree.getRoot().getLeftChild());
    }

    @Test
    void addRightChild() {
        assertNull(binaryTree.getRoot());
        binaryTree.root = new BinaryTreeNode(2);
        assertNull(binaryTree.getRoot().getRightChild());
        binaryTree.getRoot().addRightChild(new BinaryTreeNode(7));
        assertNotNull(binaryTree.getRoot().getRightChild());
    }
}