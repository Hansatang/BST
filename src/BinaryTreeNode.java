public class BinaryTreeNode<T> {
    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T value) {
        this.value = value;
        right = null;
        left = null;
    }

    public T getElement() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return left;
    }

    public BinaryTreeNode<T> getRightChild() {
        return right;
    }

    public void addLeftChild(BinaryTreeNode<T> binaryTreeNode) {
        this.left = binaryTreeNode;
    }

    public void addRightChild(BinaryTreeNode<T> binaryTreeNode) {
        this.right = binaryTreeNode;
    }
}
