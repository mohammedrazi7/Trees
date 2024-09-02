import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Java program to print the left view of a binary tree

/* Class containing left and right child of current
node and key value */
class Nodes {
    int data;
    Nodes left, right;

    public Nodes(int item) {
        data = item;
        left = right = null;
    }
}

/* Class to print the left view */
class Solution4 {
    Nodes root;
    static int max_level = 0;
    Scanner scanner = new Scanner(System.in);

    // Function to build the tree using level order input
    void buildTree() {
        System.out.println("Enter root node:");
        int rootData = scanner.nextInt();
        if (rootData == -1) return;

        root = new Nodes(rootData);
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nodes currentNode = queue.poll();

            System.out.println("Enter left child of " + currentNode.data + " (enter -1 for no left child):");
            int leftData = scanner.nextInt();
            if (leftData != -1) {
                currentNode.left = new Nodes(leftData);
                queue.add(currentNode.left);
            }

            System.out.println("Enter right child of " + currentNode.data + " (enter -1 for no right child):");
            int rightData = scanner.nextInt();
            if (rightData != -1) {
                currentNode.right = new Nodes(rightData);
                queue.add(currentNode.right);
            }
        }
    }

    // Recursive function to print the left view
    void leftViewUtil(Nodes node, int level) {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(node.data + " ");
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView() {
        max_level = 0;
        leftViewUtil(root, 1);
    }

    public static void main(String args[]) {
        Solution4 tree = new Solution4();

        // Build the tree based on user input
        tree.buildTree();

        System.out.println("Left view of the binary tree is:");
        tree.leftView();
    }
}
