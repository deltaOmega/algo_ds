package tree.examples;


import java.util.*;
import java.util.stream.Collectors;

public class TreeSolutions {

    static TreeNode nullNode = new NullNode();

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

    public static boolean isPalindrome(List<TreeNode> nodes, int start, int end) {
        List<Integer> intNodes = nodes.subList(start, end + 1).stream().map(TreeNode :: getVal).collect(Collectors.toList());
        int l = 0;
        int h = intNodes.size() - 1;
        while(l <= h) {
            if(intNodes.get(l) != intNodes.get(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

    public static List<TreeNode> levelOrderTraversal(TreeNode node) {


        if(node == null) return Collections.emptyList();

        Queue<TreeNode> q = new ArrayDeque<>() ;

        List<TreeNode> nodes = new ArrayList<>();
        q.offer(node);
        q.offer(nullNode);
        boolean  isPalindrome =  true;
        int addedElements = 0;
        int start = 0;
        int end = 0;
        while(q.size() > 1 && isPalindrome)  {

            TreeNode temp = q.remove();
            if(temp == nullNode) {
                nodes.add(nullNode);
                q.offer(nullNode);
                isPalindrome = isPalindrome(nodes, start, end);
                start = end + 2;
                end = end + 1 + addedElements;
                addedElements = 0;

            } else {
                nodes.add(temp);
                if (temp.left != null) {
                    q.offer(temp.left);
                    addedElements++;
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                    addedElements++;
                }

            }


        }
        if(isPalindrome) {
            isPalindrome = isPalindrome(nodes, start, end);
        }
        System.out.println(" palindrome " + isPalindrome);
        return nodes;

    }
    public static int findTilt2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int tiltValue = 0;
        if(root.left != null && root.right != null) {
            tiltValue += Math.abs(root.left.val - root.right.val) + findTilt(root.left) + findTilt(root.right);
        } else if(root.left != null) {
            tiltValue = tiltValue + root.left.val + findTilt(root.left);
        } else {
            tiltValue = tiltValue + root.right.val + findTilt(root.right);
        }
        return tiltValue;
    }

    public static int findTilt(TreeNode root) {
        return findTilt(root, 0);
    }

    public static int findTilt(TreeNode root, int tilt) {
        if(root == null) return 0;
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        return Math.abs(left - right) + root.val;
    }

    public static List<List<Integer>> rootToLeafPath(TreeNode node) {
        List<List<TreeNode>> finalList = new ArrayList<>();
        rootToLeafPath(node, new ArrayList<TreeNode> (), finalList);
        return finalList.stream().map(it -> it.stream().map(it2 -> it2.val).collect(Collectors.toList())).collect(Collectors.toList());
    }


    public static List<String> binaryTreePaths2(TreeNode node) {
        List<List<TreeNode>> finalList = new ArrayList<>();
        rootToLeafPath(node, new ArrayList<TreeNode> (), finalList);
        return finalList.stream().map(it -> it.stream().map(it2 -> String.valueOf(it2.val)).collect(Collectors.joining("->"))).collect(Collectors.toList());
    }

    public static void rootToLeafPath(TreeNode node, List<TreeNode> nodes, List<List<TreeNode>> finalList) {

        if(node == null) {
            return;
        }

        nodes.add(node);
        if(node.left == null && node.right == null) {
            finalList.add(nodes);
        }
        if(node.left != null) {
            List<TreeNode> nodes1 = new ArrayList<>(nodes);
            rootToLeafPath(node.left, nodes1, finalList);

        }
        if(node.right != null) {
            List<TreeNode> nodes1 = new ArrayList<>(nodes);
            rootToLeafPath(node.right, nodes1, finalList);
        }
    }

    public static List<String> binaryTreePaths3(TreeNode node) {
        List<String> finalList = new ArrayList<>();
        rootToLeafPath1(node, new ArrayList<TreeNode> (), finalList);
        return finalList;
    }

    public static void rootToLeafPath1(TreeNode node, List<TreeNode> nodes, List<String> finalList) {

        if(node == null) {
            return;
        }

        nodes.add(node);
        if(node.left == null && node.right == null) {
            finalList.add(nodes.stream().map(it2 -> String.valueOf(it2.val)).collect(Collectors.joining("->")));
        }

        if(node.left != null) {
            List<TreeNode> nodes1 = new ArrayList<>(nodes);
            rootToLeafPath1(node.left, nodes1, finalList);

        }
        if(node.right != null) {
            List<TreeNode> nodes1 = new ArrayList<>(nodes);
            rootToLeafPath1(node.right, nodes1, finalList);
        }
    }

    public static int sumNumbers(TreeNode root) {
        List<String> finalList = new ArrayList<>();
        rootToLeafPath2(root, new ArrayList<>(), finalList, "");
        int sum = finalList.stream().map(Integer::parseInt).reduce(0, Integer::sum);
        return sum;
    }

    public static int sumRootToLeafBinaryNumbers(TreeNode root) {
        List<String> finalList = new ArrayList<>();
        rootToLeafPath2(root, new ArrayList<>(), finalList, "");
        int sum = finalList.stream().map(it -> Integer.parseInt(it, 2)).reduce(0, Integer::sum);
        return sum;
    }

    public static List<String> binaryTreePaths(TreeNode node) {
        List<String> finalList = new ArrayList<>();
        rootToLeafPath2(node, new ArrayList<>(), finalList, "->");
        return finalList;
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, null);

    }

    public static int maxDepth(TreeNode node) {
        if(node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return 1 + Math.max(left, right);
    }
    // 1 , 2, null
    public static int minDepth(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right != null)
            return 1 + minDepth(node.right);
        if(node.right == null && node.left != null)
            return 1 + minDepth(node.left);
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    public static void main(String[] args) {
        //int[] arr = {5, 3, 2, 4, 10, 9, 12};

        //TreeNode node = buildBST(arr);
        //List<Integer> nodes = inOrder(node);

        //System.out.println("ndoes are " + nodes);

        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2));

        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));

        TreeNode t3 = mergeTrees(t1, t2);

//        System.out.println("ndoes are " + t3);

        TreeNode t4 = new TreeNode(4, new TreeNode(7, new TreeNode(9), new TreeNode(6)), new TreeNode(2,
                new TreeNode(3), new TreeNode(1)));
        TreeNode t5 = invertTree(t4);
        System.out.println("ndoes are " + t5);



//        System.out.println("count of leaf nodes are " + countLeafNodes(node));
//        System.out.println("count of leaf nodes are " + countLeafNodes(new TreeNode(1)));
//        System.out.println("count of leaf nodes are " + countLeafNodes(new TreeNode(1, new TreeNode(2), null)));
//        System.out.println("count of leaf nodes are " + countLeafNodes(new TreeNode(1, new TreeNode(2), new TreeNode(3))));

    /*    List<Integer> prenodes = preOrder(node);

        System.out.println("prenodes are " + prenodes);

        List<Integer> postOrderNodes = postOrder(node);

        System.out.println("postOrderNodes are " + postOrderNodes);

        postOrderNodes = postOrderWithOnstack(node);

        System.out.println("postOrderNodes with one stack are " + postOrderNodes);*/

        TreeNode t8 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode t9 = new TreeNode(1, new TreeNode(3), null);
        System.out.println("t1 and t2 leaves are same  " + leafSimilar(t8, t9));
       /* TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        List<Integer> nodes = levelOrderTraversal(t1).stream().map(it -> it.val).collect(Collectors.toList());
        System.out.println(nodes);
        *//*TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));*//*
        TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(3), new TreeNode(4)));

        List<Integer> nodes2 = levelOrderTraversal(t2).stream().map(it -> it.val).collect(Collectors.toList());
        System.out.println(nodes2);*/

      /*  TreeNode t1 = new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(5)), new TreeNode(9));
        List<List<Integer>> paths = rootToLeafPath(t1);
        System.out.println("paths are " + paths);
        System.out.println("binary paths are " + binaryTreePaths(t1));

        TreeNode t2 = new TreeNode(2, new TreeNode(3, new TreeNode(7), new TreeNode(9)), new TreeNode(4, new TreeNode(8), new TreeNode(9, new TreeNode(11), new TreeNode(12, new TreeNode(14), null))));
        paths = rootToLeafPath(t2);
    System.out.println("paths are " + paths);
        System.out.println("binary paths are " + binaryTreePaths(t2));*/

    /*    TreeNode t1 = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        List<List<Integer>>  paths = rootToLeafPath(t1);
    System.out.println("paths are " + paths);
        System.out.println("sum of paths are " + sumNumbers(t1));
        System.out.println("sum of left leaves are " + sumOfLeftLeaves(t1));
        System.out.println("maxDepth are " + maxDepth(t1));

        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        paths = rootToLeafPath(t2);
        System.out.println("paths are " + paths);
        System.out.println("sum of paths are " + sumNumbers(t2));
        System.out.println("sum of left leaves are " + sumOfLeftLeaves(t2));
        System.out.println("maxDepth are " + maxDepth(t2));


        TreeNode t3 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        paths = rootToLeafPath(t3);
        System.out.println("paths are " + paths);
        System.out.println("sum of paths are " + sumNumbers(t3));
        System.out.println("sum of left leaves are " + sumOfLeftLeaves(t3));
        System.out.println("maxDepth are " + maxDepth(t3));


        TreeNode t4 = new TreeNode(3);
        paths = rootToLeafPath(t4);
        System.out.println("paths are " + paths);
        System.out.println("sum of paths are " + sumNumbers(t4));
        System.out.println("sum of left leaves are " + sumOfLeftLeaves(t4));
        System.out.println("maxDepth are " + maxDepth(t4));
*/
        //TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        //System.out.println(findTilt(t1));
        //[1,2,3,4,null,5]
        //TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3,
        //      new TreeNode(5), null));


        //System.out.println(findTilt(t2));
        /*TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println("same tree(t1, t2) is " + isSameTree(t1, t2));

        TreeNode t3 = new TreeNode(1, null, new TreeNode(3));
        TreeNode t4 = new TreeNode(1, new TreeNode(3), null);
        TreeNode t5 = new TreeNode(1, new TreeNode(3), null);
        System.out.println("same tree(t1, t3) is " + isSameTree(t1, t3));
        System.out.println("same tree(t2, t3) is " + isSameTree(t2, t3));
        System.out.println("same tree(t3, t4) is " + isSameTree(t3, t4));
        System.out.println("same tree(t4, t5) is " + isSameTree(t4, t5)); */
    }

    public static List<Integer> inOrder(TreeNode node) {
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

    //Leetcode
    public static List<Integer> postOrder(TreeNode node) {
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

    public static List<Integer> postOrderWithOnstack(TreeNode node) {
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

    public static List<Integer> getLeafNodes(TreeNode node, List<Integer> nodes) {

        if(node == null) return Collections.emptyList();

        if(node.left == null && node.right == null) {
            nodes.add(node.val);

        } else {

            if (node.left != null) {
                getLeafNodes(node.left, nodes);
            }
            if (node.right != null) {
                getLeafNodes(node.right, nodes);
            }
        }

        return nodes;

    }
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leafNodes1 = getLeafNodes(root1, new ArrayList<>());
        List<Integer> leafNodes2 = getLeafNodes(root2, new ArrayList<>());
        if(leafNodes1.size()  != leafNodes2.size()) return false;

        for(int i = 0; i < leafNodes1.size(); i++) {
            if(leafNodes1.get(i) != leafNodes2.get(i)) return false;
        }
        return true;
    }



    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return sum != 0;

        return false;
    }

    public static int sumOfLeftLeaves(TreeNode node, TreeNode prev) {
        if(node == null) return 0;

        if(node.left == null && node.right == null) {
            if((prev != null && node == prev.left) || (prev == null && node.left != null)) {
                return node.val;
            } else {
                return 0;
            }
        }

        return sumOfLeftLeaves(node.left, node) + sumOfLeftLeaves(node.right, node);

    }

    public static void rootToLeafPath2(TreeNode node, List<TreeNode> nodes, List<String> finalList, String separator) {

        if(node == null) {
            return;
        }

        nodes.add(node);
        if(node.left == null && node.right == null) {
            finalList.add(nodes.stream().map(it2 -> String.valueOf(it2.val)).collect(Collectors.joining(separator)));
        }

        if(node.left != null) {
            rootToLeafPath2(node.left, nodes, finalList, separator);
            nodes.remove(node.left);
        }
        if(node.right != null) {
            rootToLeafPath2(node.right, nodes, finalList, separator);
            nodes.remove(node.right);
        }
    }

    //Leetcode
    public static int countLeafNodes(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    //Leetcode
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

//leetcode
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 != null && t2 == null) return t1;
        if(t1 == null && t2 != null) return t2;
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        TreeNode newNode = new TreeNode(t1.val + t2.val, left, right);
        return newNode;
    }

    //leetcode
    public static TreeNode invertTree(TreeNode node) {
        if(node == null) return node;
        TreeNode invertedLeft = invertTree(node.left);
        TreeNode invertedRight= invertTree(node.right);
        node.left = invertedRight;
        node.right = invertedLeft;
        return node;
    }




}
