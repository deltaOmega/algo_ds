package tree.examples;


import java.util.*;

public class TreeSolutions {

    public static TreeNode buildBST(int[] arr) {
        TreeNode head = insertBSTNode(null, arr[0]);
        for(int i = 1; i < arr.length; i++) {
            insertBSTNode(head, arr[i]);
        }
        return head;
    }

    public static TreeNode insertBSTNode(TreeNode node, int val) {
        TreeNode newNode = new TreeNode(val);
        if(node == null) return newNode;
        if(node.val > val) {
            if(node.left != null) {
                insertBSTNode(node.left, val);
            } else {
                node.left = newNode;
            }
        } else {
            if(node.right != null) {
                insertBSTNode(node.right, val);
            } else {
                node.right = newNode;
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 10, 9, 12};

        TreeNode node = buildBST(arr);
        List<Integer> nodes = inOrder(node);

        System.out.println("ndoes are " + nodes);

        System.out.println("count of leaf nodes are " + countLeafNodes(node));
        System.out.println("count of leaf nodes are " + countLeafNodes(new TreeNode(1)));
        System.out.println("count of leaf nodes are " + countLeafNodes(new TreeNode(1, new TreeNode(2), null)));
        System.out.println("count of leaf nodes are " + countLeafNodes(new TreeNode(1, new TreeNode(2), new TreeNode(3))));

    /*    List<Integer> prenodes = preOrder(node);

        System.out.println("prenodes are " + prenodes);

        List<Integer> postOrderNodes = postOrder(node);

        System.out.println("postOrderNodes are " + postOrderNodes);

        postOrderNodes = postOrderWithOnstack(node);

        System.out.println("postOrderNodes with one stack are " + postOrderNodes);*/
    }

    private static List<Integer> inOrder(TreeNode node) {
        if(node == null) return Collections.emptyList();
        TreeNode curr = node;
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(node);

        while(!s.isEmpty()) {
            while(curr.left != null) {
                curr = curr.left;
                s.push(curr);
            }
            curr = s.pop();
            nodes.add(curr.val);
            if(curr.right != null) {
                curr = curr.right;
                s.push(curr);
            }
        }
        return nodes;
    }

    private static List<Integer> preOrder(TreeNode node) {
        if(node == null) return Collections.emptyList();
        TreeNode curr = node;
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(curr);

        while(!s.isEmpty()) {

            curr = s.pop();
            nodes.add(curr.val);
            if(curr.right != null) {
                s.push(curr.right);
            }
            if(curr.left != null) {
                s.push(curr.left);
            }
        }
        return nodes;
    }

    private static List<Integer> postOrder(TreeNode node) {
        if(node == null) return Collections.emptyList();

        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);

        while(!s1.isEmpty()) {

            TreeNode curr = s1.pop();
            s2.push(curr);

            if(curr.left != null) {
               s1.push(curr.left);
            }
            if(curr.right != null) {
                s1.push(curr.right);
            }
        }

        while(!s2.isEmpty()) {
            nodes.add(s2.pop().val);
        }
        return nodes;
    }

    private static List<Integer> postOrderWithOnstack(TreeNode node) {
        if(node == null) return Collections.emptyList();

        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = node;

        while(curr != null || !s.isEmpty()) {

            if(curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                TreeNode tmp =  s.peek().right;
                if(tmp == null) {
                    tmp = s.pop();
                    nodes.add(tmp.val);
                    while(!s.isEmpty() && tmp == s.peek().right) {
                        tmp = s.pop();
                        nodes.add(tmp.val);
                    }
                } else {
                    curr = tmp;
                }
            }

        }

        return nodes;
    }

    public static int countLeafNodes(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }



}
