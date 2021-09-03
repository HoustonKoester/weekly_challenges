import java.util.Arrays;

//most of this is a solution to a leetcode problem i did ages ago that i remembered, but i added a small twist and printed the tree structure
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

}

class ArrtoBalancedTree {
    static Node root;

    public Node ArrtoBalancedTree(int Arr[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(Arr[mid]);

        node.left = ArrtoBalancedTree(Arr, start, mid - 1);
        node.right = ArrtoBalancedTree(Arr, mid + 1, end);

        return node;
    }
        static int count = 10;

    public void printAsTree(Node node, int LR) {
        if (node == null) {
            return;
        }
        LR += count;
        printAsTree(node.right, LR);
        System.out.println();
        for (int i= count; i < LR; i++){
            System.out.print(" ");

        }
        System.out.print(node.data+ "\n");
        printAsTree(node.left, LR);
    }

    public static void main(String[] args) {
        ArrtoBalancedTree binaryTree = new ArrtoBalancedTree();
        int[] arr1 = {3,4,5,6,7};
        int[] arr2 = {3,41,60,61,75};
        int[] arr3 = {-5,0,5,6,7};
        int[] arr4 = {-7,-6,-5,-4,-3};
        root = binaryTree.ArrtoBalancedTree(arr4, 0, 4);
        binaryTree.printAsTree(root,5);
        System.out.println("---------------------------------------------");
        root = binaryTree.ArrtoBalancedTree(arr3, 0, 4);
        binaryTree.printAsTree(root,5);
        System.out.println("---------------------------------------------");
        root = binaryTree.ArrtoBalancedTree(arr2, 0, 4);
        binaryTree.printAsTree(root,5);
        System.out.println("---------------------------------------------");
        root = binaryTree.ArrtoBalancedTree(arr1, 0, 4);
        binaryTree.printAsTree(root,5);
    }

}
