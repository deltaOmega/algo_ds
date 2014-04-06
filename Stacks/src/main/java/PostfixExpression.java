import java.util.*;

/**
 * Created by mssw on 4/5/14.
 */
public class PostfixExpression {

    public static final Map<Character, Integer> precedence = new LinkedHashMap<Character, Integer>();
    static {
        precedence.put('*', 1);
        precedence.put('/', 1);
        precedence.put('+', 2);
        precedence.put('-', 2);
    }
    static final Set<Character> values = new HashSet<Character>();
    static {
        values.add('*'); values.add('/'); values.add('+'); values.add('-');
        values.add('('); values.add('[');
    }

    public static void main(String[] args) {
        convertToPostfix(args[0]);
    }

    public static void convertToPostfix(String infixExp)
    {
        System.out.println("infix : " + infixExp);
        System.out.print("postfix : ");
        //Collection<Character[]> c = precedence.values();
        Stack<Character> expressionStack = new Stack<Character>();
        for(int i = 0; i < infixExp.length(); i++)
        {
            char val = infixExp.charAt(i);

            if(values.contains(val))
            {
                if(precedence.containsKey(val)) {
                    if (!expressionStack.isEmpty() && precedence.get(expressionStack.peek().charValue())
                            == precedence.get(val)) {
                        System.out.print(expressionStack.pop() + " ");
                        expressionStack.push(val);
                    } else {
                        expressionStack.push(val);
                    }
                }
                else
                {
                    expressionStack.push(val);
                }
            }
            else if( val == ')' || val == ']' )
            {
                char tmp = (char) -1;
                while(!expressionStack.isEmpty() &&
                (tmp = expressionStack.pop()) != -1 )
                {
                    if(tmp == '(' || tmp == '[')
                    {
                        break;
                    }
                    else
                    {
                        System.out.print(tmp + " ");
                    }
                }
            }
            else
            {
                System.out.print(val + " ");
            }
        }
        while(!expressionStack.isEmpty())
        {
            System.out.print(expressionStack.pop() + " ");
        }
    }
}
