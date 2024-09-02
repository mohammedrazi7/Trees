import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Nod {
    int data;
    Nod left, right;

    Nod(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Solution5{

    static void mirror(Nod root) {
        if (root == null)
            return;

        mirror(root.left);
        mirror(root.right);

        Nod temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    static void inOrder(Nod root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Function to build the tree using level order input
    static Nod buildTree() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter root node value:");
        int rootData = scanner.nextInt();
        if (rootData == -1) return null;

        Nod root = new Nod(rootData);
        Queue<Nod> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Nod currentNode = queue.poll();

            System.out.println("Enter left child of " + currentNode.data + " (enter -1 for no left child):");
            int leftData = scanner.nextInt();
            if (leftData != -1) {
                currentNode.left = new Nod(leftData);
                queue.add(currentNode.left);
            }

            System.out.println("Enter right child of " + currentNode.data + " (enter -1 for no right child):");
            int rightData = scanner.nextInt();
            if (rightData != -1) {
                currentNode.right = new Nod(rightData);
                queue.add(currentNode.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Nod root = buildTree();

        mirror(root);

        System.out.println("Inorder traversal of the mirrored tree is:");
        inOrder(root);
    }
}
