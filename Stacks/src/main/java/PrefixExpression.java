import java.util.*;

/**
 * Created by mssw on 4/5/14.
 */
public class PrefixExpression {

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
        values.add(')'); values.add(']');

    }

    public static void main(String[] args) {
        String infixExp = args[0];
        System.out.println("infix : " + infixExp);
        System.out.print("prefix : ");
        System.out.print(convertToPrefix(infixExp));
    }

    public static String convertToPrefix(String infixExp)
    {
        //(2+3)*(4-1)
                       StringBuilder sb = new StringBuilder();
        //Collection<Character[]> c = precedence.values();
        Stack<Character> expressionStack = new Stack<Character>();
        for(int i = infixExp.length() -1; i >= 0; i--)
        {
            char val = infixExp.charAt(i);

            if(values.contains(val))
            {
                if(precedence.containsKey(val)) {
                    while (!expressionStack.isEmpty() && precedence.containsKey(expressionStack.peek())
                    && precedence.get(expressionStack.peek())
                            < precedence.get(val)) {
                        sb.append(expressionStack.pop()).append(" ");

                    }
                    expressionStack.push(val);
                }
                else
                {
                    expressionStack.push(val);
                }
            }
            else if( val == '(' || val == '[' )
            {
                char tmp = (char) -1;
                while(!expressionStack.isEmpty() &&
                (tmp = expressionStack.pop()) != -1 )
                {
                    if(tmp == ')' || tmp == ']')
                    {
                        break;
                    }
                    else
                    {
                        sb.append(tmp).append(" ");
                    }
                }
            }
            else
            {
                sb.append(val).append(" ");
            }
        }

        while(!expressionStack.isEmpty())
        {
            sb.append(expressionStack.pop()).append(" ");
        }
        if(sb.lastIndexOf(" ") != -1)
        {
           sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString().trim();
    }
}
