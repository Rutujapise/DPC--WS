import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    public static TreeNode insertLevelOrder(Integer[] arr, int i) {
        if (i < arr.length && arr[i] != null) {
            TreeNode root = new TreeNode(arr[i]);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);
            return root;
        }
        return null;
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        Main lcaFinder = new Main();

        Integer[] arr1 = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root1 = insertLevelOrder(arr1, 0);
        TreeNode p1 = findNode(root1, 5);
        TreeNode q1 = findNode(root1, 1);
        System.out.println("LCA of 5 and 1: " + lcaFinder.lowestCommonAncestor(root1, p1, q1).val);

        TreeNode p2 = findNode(root1, 5);
        TreeNode q2 = findNode(root1, 4);
        System.out.println("LCA of 5 and 4: " + lcaFinder.lowestCommonAncestor(root1, p2, q2).val);

        Integer[] arr2 = {1,2};
        TreeNode root2 = insertLevelOrder(arr2, 0);
        TreeNode p3 = findNode(root2, 1);
        TreeNode q3 = findNode(root2, 2);
        System.out.println("LCA of 1 and 2: " + lcaFinder.lowestCommonAncestor(root2, p3, q3).val);

        TreeNode sameNode = findNode(root1, 7);
        System.out.println("LCA of 7 and 7: " + lcaFinder.lowestCommonAncestor(root1, sameNode, sameNode).val);

        TreeNode rootNode = findNode(root1, 3);
        TreeNode anotherNode = findNode(root1, 8);
        System.out.println("LCA of 3 and 8: " + lcaFinder.lowestCommonAncestor(root1, rootNode, anotherNode).val);

        Integer[] arr3 = {10,20};
        TreeNode root3 = insertLevelOrder(arr3, 0);
        TreeNode p4 = findNode(root3, 10);
        TreeNode q4 = findNode(root3, 20);
        System.out.println("LCA of 10 and 20: " + lcaFinder.lowestCommonAncestor(root3, p4, q4).val);
    }
}
