import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution1 {
    Node root;

    // Function to perform spiral level order traversal
    public List<Integer> spiralOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                if (leftToRight) {
                    result.add(currentNode.data);
                } else {
                    stack.push(currentNode.data);
                }

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }

            leftToRight = !leftToRight;
        }

        return result;
    }

    // Function to create a binary tree from dynamic input
    public void buildTree(Scanner scanner) {
        System.out.println("Enter the root node value:");
        int rootData = scanner.nextInt();
        root = new Node(rootData);

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
    }

    public static void main(String[] args) {
        Solution1 tree = new Solution1();
        Scanner scanner = new Scanner(System.in);

        tree.buildTree(scanner);

        List<Integer> result = tree.spiralOrderTraversal(tree.root);
        System.out.println("Spiral order traversal of Binary Tree is " + result);
    }
}
