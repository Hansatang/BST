import java.util.ArrayList;

public class BinaryTree<T> {
    BinaryTreeNode root;


    BinaryTreeNode getRoot() {
        return root;
    }

    void setRoot(BinaryTreeNode node) {
        this.root = node;
    }

    boolean isEmpty(){
        return root == null ? true : false;
    }

    ArrayList<T> inOrder(){
        ArrayList<T> inOrderList = new ArrayList();
        toInOrder(root, inOrderList);
        return inOrderList;
    }

    void toInOrder(BinaryTreeNode root, ArrayList<T> nodes) {
        if (root == null)
            return;
        toInOrder((BinaryTreeNode) root.getLeftChild(), nodes);
        nodes.add((T) root.value);
        toInOrder((BinaryTreeNode) root.getRightChild(), nodes);
    }

    int size(){
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
