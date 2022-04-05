import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;
    private BTP binaryTreePrint;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree();
        binaryTreePrint = new BTP();
    }

    @Test
    void insert() {
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertFalse(binarySearchTree.contains(10));
        binarySearchTree.insert(10);
        assertTrue(binarySearchTree.contains(10));
    }

    @Test
    void removeElement() {
        binarySearchTree.insert(2);
        binarySearchTree.insert(10);
        assertTrue(binarySearchTree.contains(10));
        binarySearchTree.removeElement(10);
        assertFalse(binarySearchTree.contains(10));
        //binaryTreePrint.printTree(binarySearchTree.getRoot());
    }

    @Test
    void findMin() {
    }

    @Test
    void findMax() {
    }

    @Test
    void contains() {
    }
}