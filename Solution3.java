import java.util.Scanner;

// A recursive Java program to print reverse level order traversal

// A binary tree node
class TreeNode
{
    int data;
    TreeNode left, right;

    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    TreeNode root;

    /* Function to print REVERSE level order traversal of a tree */
    void reverseLevelOrder(TreeNode node)
    {
        int h = height(node);
        for (int i = h; i >= 1; i--)
        {
            printGivenLevel(node, i);
        }
    }

    /* Print nodes at a given level */
    void printGivenLevel(TreeNode node, int level)
    {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.data + " ");
        else if (level > 1)
        {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node. */
    int height(TreeNode node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);

            /* use the larger one */
            return Math.max(lheight, rheight) + 1;
        }
    }

    // Method to insert nodes in level order
    public TreeNode insertLevelOrder(int[] arr, TreeNode root, int i)
    {
        // Base case for recursion
        if (i < arr.length)
        {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        // Dynamic input for the tree nodes
        System.out.println("Enter the number of nodes in the tree:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the values of the nodes:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Building the tree from the input array
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);

        // Displaying the reverse level order traversal
        System.out.println("Reverse Level Order traversal of binary tree is:");
        tree.reverseLevelOrder(tree.root);
    }
}
