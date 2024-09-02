import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {

    // A binary tree node has data, a pointer to left child, and a pointer to right child
    static class Node {
        int data;
        Node left, right;

        // Constructor
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Function to check if the given binary tree is complete
    static boolean isCompleteBT(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;

        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp_node = queue.remove();

            // Check for left child
            if (temp_node.left != null) {
                if (flag) return false;
                queue.add(temp_node.left);
            } else {
                flag = true;
            }

            // Check for right child
            if (temp_node.right != null) {
                if (flag) return false;
                queue.add(temp_node.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    // Function to build the tree dynamically
    static Node buildTree(Scanner scanner) {
        System.out.println("Enter the root node value:");
        int rootData = scanner.nextInt();
        Node root = new Node(rootData);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            System.out.println("Enter left child of " + currentNode.data + " (enter -1 for no left child):");
            int leftData = scanner.nextInt();
            if (leftData != -1) {
                currentNode.left = new Node(leftData);
                queue.add(currentNode.left);
            }

            System.out.println("Enter right child of " + currentNode.data + " (enter -1 for no right child):");
            int rightData = scanner.nextInt();
            if (rightData != -1) {
                currentNode.right = new Node(rightData);
                queue.add(currentNode.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = buildTree(scanner);

        if (isCompleteBT(root)) {
            System.out.println("Complete Binary Tree");
        } else {
            System.out.println("NOT Complete Binary Tree");
        }

        scanner.close();
    }
}
