package Tree;

import java.util.LinkedList;
import java.util.Queue;
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

    // 先序遍历 DFS
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

    // BFS
    public static void levelTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    // 搜索二叉树
    // 对节点root，左子节点比它小，右子节点比它大

    public static int preVal = Integer.MIN_VALUE;

    public static boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftBST = checkBST(root.left);
        if (!isLeftBST) {
            return false;
        }
        if (root.val <= preVal) {
            return false;
        } else {
            preVal = root.val;
        }
        return checkBST(root.right);
    }

    public static boolean checkBSTUnRecur(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                // 中序处理部分
                if (root.val <= pre) {
                    return false;
                } else {
                    pre = root.val;
                }
                //
                root = root.right;
            }
        }
        return true;
    }

    // 判断完全二叉树
    // 1. 任意节点不存在 有右子树 且 没有左子树
    // 2. 满足1的前提下，遇到第一个子数不全的情况，后面遇到的应该都是叶节点
    public static boolean checkCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right != null)  {
                return false;
            }
            if (flag && (left != null || right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left != null && right == null) {
                flag = true;
            }
        }
        return true;
    }

    static class Info {
        public int height;
        public int nodes;
        public boolean isBalance;

        public Info(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    // 判断满二叉树
    // 最大深度l 节点数 n => n = 2^l - 1
    public static boolean isFullTree(TreeNode root) {
        Info info = processFull(root);
        return ((2 ^ info.height - 1) == info.nodes);
    }

    private static Info processFull(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = processFull(root.left);
        Info rightInfo = processFull(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }


    // 平衡二叉树
    // 任何一棵树，左树右树高度差不超过1
    // 1. 左树是
    // 2. 右树是
    // 3. |左高 - 右高| <= 1

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalance = leftInfo.isBalance && rightInfo.isBalance
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(height, isBalance);
    }

    public static boolean isBalance(TreeNode root) {
        return process(root).isBalance;
    }

    // 折纸问题
    public void printAll(int n) {
        if (n == 0) {
            return;
        }
        printAllFold(1, n, true);
    }

    // down == true 表示正向，false表示反向
    private void printAllFold(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printAllFold(i + 1, n, true);
        System.out.println(down);
        printAllFold(i + 1, n, false);
    }


}
