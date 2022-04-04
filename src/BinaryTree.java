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


}
