/**
 * Created by mssw on 4/5/14.
 */
public class RedBlackTreeNode<T> {
    T key;
    Color color;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RedBlackTreeNode<T> getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(RedBlackTreeNode<T> leftTree) {
        this.leftTree = leftTree;
    }

    public RedBlackTreeNode<T> getRightTree() {
        return rightTree;
    }

    public void setRightTree(RedBlackTreeNode<T> rightTree) {
        this.rightTree = rightTree;
    }

    RedBlackTreeNode<T> leftTree;
    RedBlackTreeNode<T> rightTree;

    public RedBlackTreeNode(T key, Color color, RedBlackTreeNode<T> leftTree, RedBlackTreeNode<T> rightTree) {
        this.key = key;
        this.color = color;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public RedBlackTreeNode() {

    }

    @Override
    public String toString() {
        return "RedBlackTreeNode{" +
                "key=" + key +
                ", color=" + color +
                ", leftTree=" + leftTree +
                ", rightTree=" + rightTree +
                '}';
    }


}
