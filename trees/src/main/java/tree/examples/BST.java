package tree.examples;

public class BST {
    TreeNode root = null;

    public static BST buildTree(int[] arr) {
        BST bst = new BST();
        for (int i = 0; i < arr.length; i++) {
            bst.insertNode(arr[i]);
        }
        return bst;
    }

    public void printBST() {
        System.out.println(root.val);
        printBST(root, 1);
    }

    public void printBST(TreeNode root, int level) {
        System.out.println();
        int tmp = level;
        while (tmp >= 1) {
            System.out.print("\t");
            tmp--;
        }
        if (root.left != null) {
            System.out.print(root.left.val + "\t");

        } else System.out.print("\t \t");
        if (root.right != null) {
            System.out.print(root.right.val + "\t");

        } else System.out.print("\t \t");
        if (root.left != null)
            printBST(root.left, level + 1);
        if (root.right != null)
            printBST(root.right, level + 1);

    }

    public void printBSTInPreorder(TreeNode element) {
        if (element == null) {
            return;
        }
        // System.out.println();
        System.out.print(element.val + "\t");
        printBSTInPreorder(element.left);
        printBSTInPreorder(element.right);
    }

    public void insertNode(int newNodeData) {
        if (root == null) {
            root = new TreeNode(newNodeData);
        } else {
            TreeNode tmp = root;

            while (tmp != null) {
                if (tmp.val > newNodeData) {
                    if (tmp.left == null) {
                        tmp.left = new TreeNode(newNodeData);
                        tmp = null;
                    } else {
                        tmp = tmp.left;
                    }
                } else {
                    if (tmp.right == null) {
                        tmp.right = new TreeNode(newNodeData);
                        tmp = null;
                    } else {
                        tmp = tmp.right;
                    }
                }
            }

        }
    }



    public void deleteNode(TreeNode n, int val) {
        deleteNode(n, val, null);
    }

    public void deleteNode(TreeNode n, int val, TreeNode parent) {
        if(n == null ) return;
        if(n.val == val) {
            if(n.left == null && n.right == null) {
                if(parent.left == n) parent.left = null;
                else if(parent.right == n) parent.right = null;
                return;
            } else {
                TreeNode nodeToReplaceWith = null;
                if(n.left == null && n.right != null) {
                    nodeToReplaceWith = n.right;
                } else if(n.right == null && n.left != null) {
                    nodeToReplaceWith = n.left;
                }
                    if(parent.left == n) {
                        parent.left = nodeToReplaceWith;
                        return;
                    } else if(parent.right == n) {
                        parent.right = nodeToReplaceWith;
                    }

            }
        } else if(n.val > val) {
            deleteNode(n.left, val, n);
            return;
        } else if(n.val <  val) {
            deleteNode(n.right, val, n);
            return;
        }
        return;
    }



    public TreeNode searchNode(TreeNode n, int searchVal) {
        if(n == null) return null;

        if(n.val == searchVal) return n;

        if(searchVal > n.val) {
            return searchNode(n.right, searchVal);
        }
        if(searchVal < n.val) {
            return searchNode(n.left, searchVal);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 7, 22, 4, 2};
        BST bst = BST.buildTree(arr);
        //bst.printBST();
        TreeNode found = bst.searchNode(bst.root, 10);
        System.out.println("node found " + found);
        bst.printBSTInPreorder(bst.root);

        found = bst.searchNode(bst.root, 22);
        System.out.println("node found " + found);


        found = bst.searchNode(bst.root, 21);
        System.out.println("node found " + found);

        bst.deleteNode(bst.root, 22);
        found = bst.searchNode(bst.root, 22);
        System.out.println("node found " + found);


        bst.deleteNode(bst.root, 10);
        found = bst.searchNode(bst.root, 10);
        System.out.println("node found " + found);

    }

}
