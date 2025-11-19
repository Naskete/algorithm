package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTravel {
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        // recursive
         if (root == null) {
             return new ArrayList<>();
         }
         List<Integer> list = new ArrayList<>();
         inorder(root, list);
         return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public List<Integer> inorderTraversalNonRecursive(TreeNode root) {
        // non-recursive
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
