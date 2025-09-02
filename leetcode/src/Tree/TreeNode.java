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

    // 后序遍历
    public static void posOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrderTravel(root.left);
        posOrderTravel(root.right);
        System.out.println(root.val);
    }

    // 后序遍历
    // 1. 压入节点
    // 2. 弹出当前节点cur
    // 3. cur放入辅助栈
    // 4. 先加入左孩子，再加右孩子
    // 5. 循环
    public static void posOrderTravelUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> orderStack = new Stack<>();
        Stack<TreeNode> collectStack = new Stack<>();
        orderStack.add(root);
        while (!orderStack.isEmpty()) {
            TreeNode node = orderStack.pop();
            collectStack.add(node);
            if (node.left != null) {
                orderStack.add(node.left);
            }
            if (node.right != null) {
                orderStack.add(node.right);
            }
        }
        while (!collectStack.isEmpty()) {
            TreeNode node = collectStack.pop();
            System.out.println(node.val);
        }
    }

    // 中序遍历
    public static void inOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTravel(root.left);
        System.out.println(root.val);
        inOrderTravel(root.right);
    }

    // 中序遍历
    // 1. 整个树左树进
    // 2. 弹出打印(处理)，同时对弹出节点的右数做同样的操作
    // 3. 循环
    public static void  inOrderTravelUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
}
