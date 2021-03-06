public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> implements Comparable<T> {

    BinarySearchTreeNode(T value) {
        super(value);
    }

    public T getElement() {
        return value;
    }

    public void setElement(T value) {
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

    @Override
    public int compareTo(T something) {
        return getElement().compareTo(something);
    }
}
