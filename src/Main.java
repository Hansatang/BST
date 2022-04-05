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
        binaryTree2.removeElement(10);
        binaryTreePrint.printTree(binaryTree2.root);
        binaryTree2.removeElement(13);
        binaryTreePrint.printTree(binaryTree2.root);
        binaryTree2.findMin(binaryTree2.root);

        System.out.println();
        ArrayList<Integer> list = binaryTree2.inOrder();

        for (Integer BSTN : list) {
            System.out.print(BSTN + " ");
        }
        System.out.println();
        System.out.println("Min " + binaryTree2.findMin(binaryTree2.root));
        System.out.println("Max " + binaryTree2.findMax(binaryTree2.root));

        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(1);
        System.out.println();
        binaryTreePrint.printTree(binaryTree.root);
        System.out.println();
        System.out.println(binaryTree2.height());
        System.out.println("YOLO " + binaryTree2.contains(22));
        System.out.println();
        ArrayList<Integer> list2 = binaryTree.preOrder();
        for (Integer BSTN : list2) {
            System.out.print(BSTN + " ");
        }
        System.out.println();
        ArrayList<Integer> list3 = binaryTree.inOrder();
        for (Integer BSTN : list3) {
            System.out.print(BSTN + " ");
        }
        System.out.println();
        ArrayList<Integer> list4 = binaryTree.postOrder();
        for (Integer BSTN : list4) {
            System.out.print(BSTN + " ");
        }
        System.out.println();
        System.out.println("LevelOrder");
        ArrayList<Integer> list5 = binaryTree.levelOrder();
        for (Integer BSTN : list5) {
            System.out.print(BSTN + " ");
        }
        System.out.println();
        BinarySearchTree binaryTree3 = new BinarySearchTree();
        binaryTree3.insert(5);
        binaryTree3.insert(10);
        binaryTree3.insert(15);
        binaryTree3.insert(20);
        binaryTree3.insert(3);
        binaryTree3.insert(8);
        binaryTree3.insert(13);
        binaryTree3.insert(25);
        binaryTreePrint.printTree(binaryTree3.root);
        binaryTree3.rebalance();
        binaryTreePrint.printTree(binaryTree3.root);
    }
}
