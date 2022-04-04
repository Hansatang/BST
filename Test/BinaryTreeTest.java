import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
    }


    @org.junit.jupiter.api.Test
    void getRoot() {
        assertNull(binaryTree.getRoot());
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertNotNull(binaryTree.getRoot());
    }

    @org.junit.jupiter.api.Test
    void setRoot() {
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertEquals(binaryTree.getRoot().getElement(), 7);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void inOrder() {
    }

    @org.junit.jupiter.api.Test
    void toInOrder() {
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(binaryTree.size(), 0);
        binaryTree.setRoot(new BinaryTreeNode(7));
        assertEquals(binaryTree.size(), 1);
    }
}