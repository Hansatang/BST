public class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public int getElement() {
        return value;
    }

    public BinaryTreeNode getLeftChild() {
        return left;
    }

    public BinaryTreeNode getRightChild() {
        return right;
    }

    public void addLeftChild(BinaryTreeNode binaryTreeNode) {
       this.left= binaryTreeNode;
    }

    public void addRightChild(BinaryTreeNode binaryTreeNode) {
        this.right= binaryTreeNode;
    }
}
