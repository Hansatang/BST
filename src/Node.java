public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public int getElement() {
        return value;
    }

    public Node getLeftChild() {
        return left;
    }

    public Node getRightChild() {
        return right;
    }

    public void addLeftChild(Node node) {
       this.left=node;
    }

    public void addRightChild(Node node) {
        this.right=node;
    }
}
