import java.util.ArrayList;

public class BinaryTree<T> {
    BinaryTreeNode root;



    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode node) {
        this.root = node;
    }

    public boolean isEmpty() {
        return root == null ? true : false;
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

    public void toPreOrder(BinaryTreeNode root, ArrayList<T> nodes) {
        if (root == null)
            return;
        nodes.add((T) root.value);
        toPreOrder((BinaryTreeNode) root.getLeftChild(), nodes);
        toPreOrder((BinaryTreeNode) root.getRightChild(), nodes);
    }

    public ArrayList<T> postOrder() {
        ArrayList<T> inOrderList = new ArrayList();
        toPostOrder(root, inOrderList);
        return inOrderList;
    }

    public void toPostOrder(BinaryTreeNode root, ArrayList<T> nodes) {
        if (root == null)
            return;
        toPostOrder((BinaryTreeNode) root.getLeftChild(), nodes);
        toPostOrder((BinaryTreeNode) root.getRightChild(), nodes);
        nodes.add((T) root.value);
    }



    public int size() {
        return inOrder().size();
    }

//    public boolean contains(int value){
//        if (root.getElement() == value) {
//            root = new BinaryTreeNode(value);
//            return true;
//        }
//    }


    public boolean contains(T value){
        return search((BinarySearchTreeNode) root, value);
    }

    private boolean search(BinarySearchTreeNode currentRoot, T searchedValue){
        if (root == null)
            return false;

        switch (currentRoot.getElement().compareTo(searchedValue)){
            case -1:
                return search((BinarySearchTreeNode) root.getLeftChild(), searchedValue);
            case 0:
                    return true;
            case 1:
                return search((BinarySearchTreeNode) root.getRightChild(), searchedValue);
        }
        return false;
    }



}
