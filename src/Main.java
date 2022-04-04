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
        ArrayList<BinarySearchTreeNode> list = binaryTree2.InOrder();
        for (BinarySearchTreeNode BSTN : list) {
            System.out.print(BSTN.value + " ");
        }
        System.out.println();
        System.out.println("Min "+binaryTree2.findMin(binaryTree2.root));
        System.out.println("Max "+binaryTree2.findMax(binaryTree2.root));

    }
}
