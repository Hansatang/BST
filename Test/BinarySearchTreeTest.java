import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;
    private BTP binaryTreePrint;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree();
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
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        binarySearchTree.insert(10);
        assertTrue(binarySearchTree.contains(10));
        binarySearchTree.removeElement(10);
        assertFalse(binarySearchTree.contains(10));
    }

    @Test
    void findMin() {
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertEquals(2, binarySearchTree.findMin(binarySearchTree.getRoot()));
        binarySearchTree.insert(1);
        assertEquals(1, binarySearchTree.findMin(binarySearchTree.getRoot()));
    }

    @Test
    void findMax() {
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertEquals(2, binarySearchTree.findMax(binarySearchTree.getRoot()));
        binarySearchTree.insert(3);
        assertEquals(3, binarySearchTree.findMax(binarySearchTree.getRoot()));
    }

    @Test
    void contains() {
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertFalse(binarySearchTree.contains(10));
        binarySearchTree.insert(10);
        assertTrue(binarySearchTree.contains(10));
    }

    @Test
    void rebalance(){
        //TODO make test for rebalance
    }

}