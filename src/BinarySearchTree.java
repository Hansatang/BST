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
                if (current.getLeftChild() == null) {
                    current.addLeftChild(new BinarySearchTreeNode<T>(value));
                    return true;
                } else {
                    current = (BinarySearchTreeNode<T>) current.getLeftChild();
                }
            } else if (current.compareTo(value) == -1) {
                if (current.getRightChild() == null) {
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

    @Override
    public ArrayList<T> inOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        toInOrder(root, inOrderList);
        return inOrderList;
    }


    public void toInOrder(BinarySearchTreeNode<T> root, ArrayList<T> nodes) {
        if (root == null)
            return;
        toInOrder((BinarySearchTreeNode<T>) root.getLeftChild(), nodes);
        nodes.add(root.getElement());
        toInOrder((BinarySearchTreeNode<T>) root.getRightChild(), nodes);
    }

    @Override
    public ArrayList<T> preOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        toPreOrder(root, inOrderList);
        return inOrderList;
    }

    public void toPreOrder(BinarySearchTreeNode<T> root, ArrayList<T> nodes) {
        if (root == null)
            return;
        nodes.add(root.getElement());
        toPreOrder(root.getLeftChild(), nodes);
        toPreOrder(root.getRightChild(), nodes);
    }

    @Override
    public ArrayList<T> postOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        toPostOrder(root, inOrderList);
        return inOrderList;
    }

    public void toPostOrder(BinarySearchTreeNode<T> root, ArrayList<T> nodes) {
        if (root == null)
            return;
        toPostOrder(root.getLeftChild(), nodes);
        toPostOrder(root.getRightChild(), nodes);
        nodes.add(root.getElement());
    }

    @Override
    public ArrayList<T> levelOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        ArrayList<BinaryTreeNode<T>> nodeList = new ArrayList<>();
        nodeList.add(root);
        toLevelOrder(nodeList, inOrderList);
        return inOrderList;
    }

    private void toLevelOrder(ArrayList<BinaryTreeNode<T>> nodeList, ArrayList<T> inOrderList) {
        if (root == null)
            return;
        ArrayList<BinaryTreeNode<T>> newNodeList = new ArrayList<>();
        if (!nodeList.isEmpty()) {
            for (BinaryTreeNode node : nodeList) {
                if (node != null) {
                    System.out.println("Adding element");
                    inOrderList.add((T) node.getElement());
                    if (node.getLeftChild() != null) {
                        System.out.println("Adding left child for iteration");
                        newNodeList.add(node.getLeftChild());
                    }
                    if (node.getRightChild() != null) {
                        System.out.println("Adding right child for iteration");
                        newNodeList.add(node.getRightChild());
                    }
                }
            }
            System.out.println(inOrderList.size());
            toLevelOrder(newNodeList, inOrderList);
        }
    }


    public boolean delete(T data) {
        return delete(root, data) != null;
    }

    private BinarySearchTreeNode<T> delete(BinarySearchTreeNode<T> checkedNode, T data) {
        if (checkedNode == null) {
            return checkedNode;
        } else if (checkedNode.getElement().compareTo(data) > 0) {
            checkedNode.addLeftChild(delete((BinarySearchTreeNode<T>) checkedNode.getLeftChild(), data));
//            checkedNode.left = delete((BinarySearchTreeNode<T>) checkedNode.getLeftChild(), data);
        } else if (checkedNode.getElement().compareTo(data) < 0) {
            checkedNode.addRightChild(delete((BinarySearchTreeNode<T>) checkedNode.getRightChild(), data));
            // checkedNode.right = delete((BinarySearchTreeNode<T>) checkedNode.getRightChild(), data);
        } else {
            if (checkedNode.getLeftChild() == null) {
                return (BinarySearchTreeNode<T>) checkedNode.getRightChild();
            } else if (checkedNode.getRightChild() == null) {
                return (BinarySearchTreeNode<T>) checkedNode.getLeftChild();
            }
            checkedNode.setValue(findMin((BinarySearchTreeNode<T>) checkedNode.getRightChild()));
            checkedNode.addRightChild(delete((BinarySearchTreeNode<T>) checkedNode.getRightChild(), (T) checkedNode.getElement()));
        }
        return checkedNode;
    }


    public T findMin(BinarySearchTreeNode<T> node) {
        T min = node.getElement();


        while (node.getLeftChild() != null) {
            min = node.getLeftChild().getElement();
            node = (BinarySearchTreeNode<T>) node.getLeftChild();
        }
        return min;
    }

    public T findMax(BinarySearchTreeNode<T> node) {
        T max = node.getElement();

        while (node.getRightChild() != null) {
            max = node.getRightChild().getElement();
            node = (BinarySearchTreeNode<T>) node.getRightChild();
        }
        return max;
    }

    @Override
    public boolean contains(T value) {
        return search(root, value);
    }

    private boolean search(BinarySearchTreeNode<T> currentRoot, T searchedValue) {
        if (currentRoot == null)
            return false;
        switch (currentRoot.getElement().compareTo(searchedValue)) {
            case 1:
                return search((BinarySearchTreeNode<T>) currentRoot.getLeftChild(), searchedValue);
            case 0:
                return true;
            case -1:
                return search((BinarySearchTreeNode<T>) currentRoot.getRightChild(), searchedValue);
        }
        return false;
    }

    @Override
    public int height() {
        return getHeight(root);
    }


    public int getHeight(BinaryTreeNode<T> root) {
        if (root == null)
            return 0;
        else {
            int lheight = getHeight(root.getLeftChild());
            int rheight = getHeight(root.getRightChild());

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    int getBalance(BinarySearchTreeNode<T> node) {
        return (node == null) ? 0 : getHeight(node.getRightChild()) - getHeight(node.getLeftChild());
    }



}
