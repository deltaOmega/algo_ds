import java.util.ArrayList;
import java.util.List;

/**
 * Created by mssw on 4/5/14.
 */
public class RedBlackTree {

    public static void main(String[] args) {

        RedBlackTreeConstructor constructor = new RedBlackTreeConstructor();
        List<Integer> elements = new ArrayList<Integer>();
        for(String arg : args)
        {
            elements.add(Integer.parseInt(arg));
        }
        constructor.constructTree(elements);

    }
}
