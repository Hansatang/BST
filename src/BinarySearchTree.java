import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    BinarySearchTreeNode<T> root;


    public boolean insert(T value) {
        BinarySearchTreeNode<T> current = root;
        if (root == null) {
            root = new BinarySearchTreeNode<T>(value);
            return true;
        }
        while (true) {
            if (current.compareTo(value) == 1) {
                if (current.left == null) {
                    current.addLeftChild(new BinarySearchTreeNode<T>(value));
                    return true;
                } else {
                    current = (BinarySearchTreeNode<T>) current.getLeftChild();
                }
            } else if (current.compareTo(value) == -1) {
                if (current.right == null) {
                    current.addRightChild(new BinarySearchTreeNode<T>(value));
                    return true;
                } else {
                    current = (BinarySearchTreeNode<T>) current.getRightChild();
                }
            } else {
                return false;
            }
        }

    }

//    public boolean contains(int value) {
//
//    }

    ArrayList InOrder() {
        ArrayList inOrderList = new ArrayList();
        toArrayList(root, inOrderList);
        return inOrderList;
    }

    void toArrayList(BinarySearchTreeNode root, ArrayList<BinarySearchTreeNode> nodes) {
        if (root == null)
            return;
        toArrayList((BinarySearchTreeNode) root.getLeftChild(), nodes);
        nodes.add(root);
        toArrayList((BinarySearchTreeNode) root.getRightChild(), nodes);
    }


    public boolean delete(T data) {
        return delete(root, data) != null ? true : false;
    }

    private BinarySearchTreeNode delete(BinarySearchTreeNode checkedNode, T data) {
        System.out.println("CheckedNode "+checkedNode.getElement());
        if (checkedNode == null) {
            return checkedNode;
        } else if (checkedNode.getElement().compareTo(data) > 0) {
            checkedNode.left = delete((BinarySearchTreeNode) checkedNode.getLeftChild(), data);
        } else if (checkedNode.getElement().compareTo(data) < 0) {
            checkedNode.right = delete((BinarySearchTreeNode) checkedNode.getRightChild(), data);
        } else {
            if (checkedNode.left == null) {
                return (BinarySearchTreeNode) checkedNode.getRightChild();
            } else if (checkedNode.right == null) {
                return (BinarySearchTreeNode) checkedNode.getLeftChild();
            }
            checkedNode.value = findMin((BinarySearchTreeNode) checkedNode.right);
            checkedNode.right = delete((BinarySearchTreeNode) checkedNode.right, (T) checkedNode.getElement());
        }
        return checkedNode;
    }


    public int findMin(BinarySearchTreeNode node) {
        int min = (int) node.getElement();


        while (node.getLeftChild() != null) {
            min = (int) node.getLeftChild().getElement();
            node = (BinarySearchTreeNode) node.getLeftChild();
        }
        return min;
    }

    public int findMax(BinarySearchTreeNode node) {
        int max = (int) node.getElement();


        while (node.getRightChild() != null) {
            max = (int) node.getRightChild().getElement();
            node = (BinarySearchTreeNode) node.getRightChild();
        }
        return max;
    }


}
