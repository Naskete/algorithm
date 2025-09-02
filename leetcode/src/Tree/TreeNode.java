package Tree;

import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void preOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    // 先序遍历
    // 1. 根入栈中
    // 2. 打印（处理）弹出节点
    // 3. 压入右孩子，再压入左孩子
    // 4. 循环
    public static void preOrderTravelUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }
}
