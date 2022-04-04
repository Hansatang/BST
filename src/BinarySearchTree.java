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

    private BinarySearchTreeNode<T> delete(BinarySearchTreeNode<T> checkedNode, T data) {
        System.out.println("CheckedNode "+checkedNode.getElement());
        if (checkedNode == null) {
            return checkedNode;
        } else if (checkedNode.getElement().compareTo(data) > 0) {
            checkedNode.left = delete((BinarySearchTreeNode<T>) checkedNode.getLeftChild(), data);
        } else if (checkedNode.getElement().compareTo(data) < 0) {
            checkedNode.right = delete((BinarySearchTreeNode<T>) checkedNode.getRightChild(), data);
        } else {
            if (checkedNode.left == null) {
                return (BinarySearchTreeNode<T>) checkedNode.getRightChild();
            } else if (checkedNode.right == null) {
                return (BinarySearchTreeNode<T>) checkedNode.getLeftChild();
            }
            checkedNode.value = findMin((BinarySearchTreeNode<T>) checkedNode.right);
            checkedNode.right = delete((BinarySearchTreeNode<T>) checkedNode.right, (T) checkedNode.getElement());
        }
        return checkedNode;
    }


    public T findMin(BinarySearchTreeNode<T> node) {
        T min =  node.getElement();


        while (node.getLeftChild() != null) {
            min =  node.getLeftChild().getElement();
            node = (BinarySearchTreeNode<T>) node.getLeftChild();
        }
        return min;
    }

    public T findMax(BinarySearchTreeNode<T> node) {
        T max =  node.getElement();

        while (node.getRightChild() != null) {
            max =  node.getRightChild().getElement();
            node = (BinarySearchTreeNode<T>) node.getRightChild();
        }
        return max;
    }


}
