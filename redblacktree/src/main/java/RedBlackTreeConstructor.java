import java.util.List;

/**
 * Created by mssw on 4/5/14.
 */
public class RedBlackTreeConstructor {

    public <T extends Number> RedBlackTreeNode<T> constructTree(List<T> elements)
    {

       RedBlackTreeNode<T> root = new RedBlackTreeNode<T>();

       T key = elements.get(0);
       root.setColor(Color.BLACK);
       root.setKey(key);

        for(int i = 1; i < elements.size(); i++)
        {
           insertNode(root, elements.get(i));
        }

       return root;

    }

    private <T extends Number> void insertNode(RedBlackTreeNode<T> tree, T key) {
        RedBlackTreeNode<T> temp = null;
        while(tree != null) {
            if (key.intValue() > tree.getKey().intValue()) {
               insertNode(tree.rightTree, key);


            } else if (key.intValue() < tree.getKey().intValue()) {
                insertNode(tree.leftTree, key);
            }
        }



    }
}
