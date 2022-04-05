import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    BinarySearchTreeNode<T> root;

    @Override
    public BinarySearchTreeNode<T> getRoot() {
        return root;
    }

    @Override
    public void setRoot(BinaryTreeNode<T> node) {
        this.root = new BinarySearchTreeNode<>(node.getElement());
    }

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
        if (inOrderList.size() == 0)
        {
            return null;
        }
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
        ArrayList<T> preOrderList = new ArrayList();
        toPreOrder(root, preOrderList);
        if (preOrderList.size() == 0)
        {
            return null;
        }
        return preOrderList;
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
        ArrayList<T> postOrderList = new ArrayList();
        toPostOrder(root, postOrderList);
        if (postOrderList.size() == 0)
        {
            return null;
        }
        return postOrderList;
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
        ArrayList<T> levelOrderList = new ArrayList();
        ArrayList<BinaryTreeNode<T>> nodeList = new ArrayList<>();
        nodeList.add(root);
        toLevelOrder(nodeList, levelOrderList);
        if (levelOrderList.size() == 0)
        {
            return null;
        }
        return levelOrderList;
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


    public boolean removeElement(T data) {
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
            checkedNode.setElement(findMin((BinarySearchTreeNode<T>) checkedNode.getRightChild()));
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

    private boolean search(BinaryTreeNode<T> currentRoot, T searchedValue) {
        if (currentRoot == null)
            return false;
        switch (currentRoot.getElement().compareTo(searchedValue)) {
            case 1:
                return search(currentRoot.getLeftChild(), searchedValue);
            case 0:
                return true;
            case -1:
                return search(currentRoot.getRightChild(), searchedValue);
        }
        return false;
    }

    @Override
    public int height() {
        return getHeight(root);
    }


    public int getHeight(BinaryTreeNode<T> root) {
        if (root == null)
            return -1;
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

//    public void rebalancer() {
//        balancer(root);
//    }
//
//    BinarySearchTreeNode<T> balancer(BinarySearchTreeNode<T> node) {
//
//        int i = getBalance(node);
//        System.out.println("hej "+node.getElement()+ " "+i);
//        if (i > 1) {
//            if (getHeight(node.getRightChild().getRightChild()) > getHeight(node.getLeftChild().getLeftChild())) {
//                node = rotateLeft(node);
//            } else {
//                node.addRightChild(rotateRight((BinarySearchTreeNode<T>) node.getRightChild()));
//                node = rotateLeft(node);
//            }
//        } else if (i < -1) {
//            if (getHeight(node.getLeftChild().getLeftChild()) > getHeight(node.getRightChild().getRightChild())) {
//                node = rotateRight(node);
//            } else {
//                node.addLeftChild(rotateLeft((BinarySearchTreeNode<T>) node.getLeftChild()));
//                node = rotateRight(node);
//            }
//        }
//        if (node.left != null){
//            balancer((BinarySearchTreeNode<T>) node.left);
//        }
//        if (node.right != null){
//            balancer((BinarySearchTreeNode<T>) node.right);
//        }
//        return node;
//    }

    BinarySearchTreeNode<T> rotateRight(BinarySearchTreeNode<T> y) {
        BinarySearchTreeNode<T> x = (BinarySearchTreeNode<T>) y.left;
        BinarySearchTreeNode<T> z = (BinarySearchTreeNode<T>) x.right;
        x.right = y;
        y.left = z;

        return x;
    }

    BinarySearchTreeNode<T> rotateLeft(BinarySearchTreeNode<T> y) {
        BinarySearchTreeNode<T> x = (BinarySearchTreeNode<T>) y.right;
        BinarySearchTreeNode<T> z = (BinarySearchTreeNode<T>) x.left;
        x.left = y;
        y.right = z;
        return x;
    }

//    public void rebalance() {
//        BinarySearchTreeNode<T> temp, temp2;
//
//        if (getHeight(root.getLeftChild()) - getHeight(root.getRightChild()) >= 1 || getHeight(root.getLeftChild()) - getHeight(root.getRightChild()) <= -1) {
//
//            if (getHeight(root.getLeftChild()) > getHeight(root.getRightChild())) {
//                //left left
//                if (getHeight(root.getLeftChild().getLeftChild()) > getHeight(root.getRightChild().getRightChild())) {
//                    temp = (BinarySearchTreeNode<T>) root.left;
//                    root.left = temp.right;
//                    temp.right = root;
//
//                }
//
//                //left right
//                else if (getHeight(root.getLeftChild().getRightChild()) > getHeight(root.getRightChild().getLeftChild())) {
//                    temp = (BinarySearchTreeNode<T>) root.left;
//                    temp2 = (BinarySearchTreeNode<T>) root.left.right;
//                    root.left = temp2.right;
//                    temp.right = temp2.left;
//                    temp2.left = temp;
//                    temp2.right = root;
//                }
//            } else if (getHeight(root.getLeftChild()) < getHeight(root.getRightChild())) {
//                //right right
//                if (getHeight(root.getRightChild().getRightChild()) > getHeight(root.getRightChild().getLeftChild())) {
//                    temp = (BinarySearchTreeNode<T>) root.left;
//                    root.left = temp.right;
//                    temp.right = root;
//
//                }
//
//                //right left
//                else if (getHeight(root.getRightChild().getLeftChild()) > getHeight(root.getRightChild().getRightChild())) {
//                    temp = (BinarySearchTreeNode<T>) root.right;
//                    temp2 = (BinarySearchTreeNode<T>) root.right.left;
//                    root.right = temp2.left;
//                    temp.left = temp2.right;
//                    temp2.left = root;
//                    temp2.right = temp;
//                }
//            }
//
//        }
//    }

    private BinarySearchTreeNode<T> rebalanceRecursive(ArrayList<T> nodes, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        insert(nodes.get(mid));
        rebalanceRecursive(nodes, start, mid - 1);
        rebalanceRecursive(nodes, mid + 1, end);
        return root;
    }

    public  void rebalance() {
        ArrayList<T> nodes = inOrder();
        this.root = null;
        int n = nodes.size();
        rebalanceRecursive(nodes, 0, n - 1);
    }

}
