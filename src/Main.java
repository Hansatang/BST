public class Main {


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree binaryTree2 = new BinaryTree();
        BTP binaryTreePrint = new BTP();

        binaryTree.addNode(binaryTree.root, 13);
        System.out.println(binaryTree.root.getElement());
        binaryTree.addNode(binaryTree.root, 10);
        binaryTree.addNode(binaryTree.root, 15);

        binaryTree2.insert(13);
        binaryTree2.insert(10);
        binaryTree2.insert(15);
        binaryTree2.insert(7);
        binaryTree2.insert(9);
        binaryTree2.insert(1);
        binaryTree2.insert(22);

        binaryTreePrint.printTree(binaryTree.root);

        binaryTreePrint.printTree(binaryTree2.root);
    }
}
