public class BinarySearchTree extends BinaryTree{
    BinarySearchTreeNode root;


    public boolean insert(int value) {
        BinaryTreeNode current = root;
        if (root == null) {
            root = new BinarySearchTreeNode(value);
            return true;
        }
        while (true) {
            if (value < current.getElement()) {
                if (current.left == null) {
                    current.addLeftChild(new BinaryTreeNode(value));
                    return true;
                } else {
                    current = current.left;
                }
            } else if (value > current.getElement()) {
                if (current.right == null) {
                    current.addRightChild(new BinaryTreeNode(value));
                    return true;
                } else {
                    current = current.right;
                }
            } else {
                return false;
            }

        }

    }

//    public boolean contains(int value) {
//
//    }



}
