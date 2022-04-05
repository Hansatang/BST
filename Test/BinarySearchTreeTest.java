import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    void insert() {
        assertNull(binarySearchTree.getRoot());
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertFalse(binarySearchTree.contains(10));
        assertThrows(NullPointerException.class, () -> {
            binarySearchTree.insert(null);
        });
        binarySearchTree.insert(10);
        assertTrue(binarySearchTree.contains(10));
    }

    @Test
    void removeElement() {
        assertNull(binarySearchTree.getRoot());
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        binarySearchTree.insert(10);
        assertTrue(binarySearchTree.contains(10));
        binarySearchTree.removeElement(10);
        assertFalse(binarySearchTree.contains(10));
    }

    @Test
    void findMin() {
        assertNull(binarySearchTree.getRoot());
        assertThrows(NullPointerException.class, () -> {
           assertNull(binarySearchTree.findMin(binarySearchTree.getRoot()));
        });
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertEquals(2, binarySearchTree.findMin(binarySearchTree.getRoot()));
        binarySearchTree.insert(1);
        assertEquals(1, binarySearchTree.findMin(binarySearchTree.getRoot()));
    }

    @Test
    void findMax() {
        assertNull(binarySearchTree.getRoot());
        assertThrows(NullPointerException.class, () -> {
            assertNull(binarySearchTree.findMax(binarySearchTree.getRoot()));
        });
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertEquals(2, binarySearchTree.findMax(binarySearchTree.getRoot()));
        binarySearchTree.insert(3);
        assertEquals(3, binarySearchTree.findMax(binarySearchTree.getRoot()));
    }

    @Test
    void contains() {
        assertNull(binarySearchTree.getRoot());
        assertFalse(binarySearchTree.contains(2));
        binarySearchTree.setRoot(new BinaryTreeNode(2));
        assertTrue(binarySearchTree.contains(2));
        assertFalse(binarySearchTree.contains(10));
        binarySearchTree.insert(10);
        assertTrue(binarySearchTree.contains(10));
    }

    @Test
    void rebalance(){
        //TODO make test for rebalance
        binarySearchTree.setRoot(new BinaryTreeNode(10));
        binarySearchTree.insert(11);
        binarySearchTree.insert(21);
        binarySearchTree.insert(9);
        binarySearchTree.rebalance();
        assertEquals(binarySearchTree.inOrder(), new ArrayList<>(Arrays.asList(9,10,11,21)));
    }

}