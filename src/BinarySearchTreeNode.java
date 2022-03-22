public class BinarySearchTreeNode extends BinaryTreeNode{

    BinarySearchTreeNode(int value) {
        super(value);
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
