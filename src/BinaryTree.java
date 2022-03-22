public class BinaryTree {
    Node root;

    public boolean insert(int value) {
        Node current = root;
        if (root == null) {
            root = new Node(value);
            return true;
        }
        while (true) {
            if (value < current.getElement()) {
                if (current.left == null) {
                    current.addLeftChild(new Node(value));
                    return true;
                } else {
                    current = current.left;
                }
            } else if (value > current.getElement()) {
                if (current.right == null) {
                    current.addRightChild(new Node(value));
                    return true;
                } else {
                    current = current.right;
                }
            } else {
                return false;
            }

        }

    }


    public Node addNode(Node node, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        } else {
            if (node == null) {
                node = new Node(value);
                return node;
            } else {
                if (value < node.value) {
                    node.addLeftChild(addNode(node.left, value));
                } else if (value > node.value) {
                    node.addRightChild(addNode(node.right, value));
                } else {
                    return node;
                }

            }
            return node;
        }
    }
}
