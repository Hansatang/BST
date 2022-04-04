import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        BinarySearchTree binaryTree2 = new BinarySearchTree();
        BTP binaryTreePrint = new BTP();


        binaryTree2.insert(13);
        binaryTree2.insert(10);
        binaryTree2.insert(16);
        binaryTree2.insert(7);
        binaryTree2.insert(9);
        binaryTree2.insert(1);
        binaryTree2.insert(22);
        binaryTree2.insert(14);
        binaryTree2.insert(15);
        binaryTree2.insert(17);
        binaryTree2.insert(11);
        binaryTreePrint.printTree(binaryTree2.root);
        binaryTree2.delete(10);
        binaryTreePrint.printTree(binaryTree2.root);
        binaryTree2.delete(13);
        binaryTreePrint.printTree(binaryTree2.root);
        binaryTree2.findMin(binaryTree2.root);

        System.out.println();
        ArrayList<BinarySearchTreeNode> list = binaryTree2.inOrder();
        for (BinarySearchTreeNode BSTN : list) {
            System.out.print(BSTN.value + " ");
        }
        System.out.println();
        System.out.println("Min "+binaryTree2.findMin(binaryTree2.root));
        System.out.println("Max "+binaryTree2.findMax(binaryTree2.root));

        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(1);
        System.out.println();
        binaryTreePrint.printTree(binaryTree.root);
        System.out.println();
        ArrayList<BinarySearchTreeNode> list2 = binaryTree.preOrder();
        for (BinarySearchTreeNode BSTN : list2) {
            System.out.print(BSTN.value + " ");
        }
        ArrayList<BinarySearchTreeNode> list3 = binaryTree.inOrder();
        for (BinarySearchTreeNode BSTN : list3) {
            System.out.print(BSTN.value + " ");
        }
        ArrayList<BinarySearchTreeNode> list4 = binaryTree.postOrder();
        for (BinarySearchTreeNode BSTN : list4) {
            System.out.print(BSTN.value + " ");
        }
    }
}
