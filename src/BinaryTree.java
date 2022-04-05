import java.util.ArrayList;

public class BinaryTree<T> {
    BinaryTreeNode<T> root;


    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> node) {
        this.root = node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public ArrayList<T> inOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        toInOrder(root, inOrderList);
        return inOrderList;
    }

    public void toInOrder(BinaryTreeNode<T> root, ArrayList<T> nodes) {
        if (root == null)
            return;
        toInOrder(root.getLeftChild(), nodes);
        nodes.add((T) root.value);
        toInOrder(root.getRightChild(), nodes);
    }

    public ArrayList<T> preOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        toPreOrder(root, inOrderList);
        return inOrderList;
    }

    public void toPreOrder(BinaryTreeNode<T> root, ArrayList<T> nodes) {
        if (root == null)
            return;
        nodes.add(root.getElement());
        toPreOrder(root.getLeftChild(), nodes);
        toPreOrder(root.getRightChild(), nodes);
    }

    public ArrayList<T> postOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        toPostOrder(root, inOrderList);
        return inOrderList;
    }

    public void toPostOrder(BinaryTreeNode<T> root, ArrayList<T> nodes) {
        if (root == null)
            return;
        toPostOrder(root.getLeftChild(), nodes);
        toPostOrder(root.getRightChild(), nodes);
        nodes.add(root.getElement());
    }

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

    public int size() {
        return inOrder().size();
    }



    public boolean contains(T value) {
        return search((BinarySearchTreeNode) root, value);
    }

    private boolean search(BinarySearchTreeNode currentRoot, T searchedValue) {
        if (root == null)
            return false;

        switch (currentRoot.getElement().compareTo(searchedValue)) {
            case 1:
                return search((BinarySearchTreeNode) root.getLeftChild(), searchedValue);
            case 0:
                return true;
            case -1:
                return search((BinarySearchTreeNode) root.getRightChild(), searchedValue);
        }
        return false;
    }

    public int height() {
        return getHeight(root);
    }

    public int getHeight(BinaryTreeNode<T> root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = getHeight(root.left);
            int rheight = getHeight(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }


}
