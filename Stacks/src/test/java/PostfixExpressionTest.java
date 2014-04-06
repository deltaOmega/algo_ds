import junit.framework.TestCase;

/**
 * Created by mssw on 4/6/14.
 */
public class PostfixExpressionTest extends TestCase {

    public void testSimpleExpression()
    {
        String infixExp = "2+3+4-1";
        assertEquals("2 3 + 4 + 1 -", PostfixExpression.convertToPostfix(infixExp));
    }

    public void testSingleBracketExpression()
    {
        String infixExp = "(2+3)*(4-1)/(8+9)";
        assertEquals("2 3 + 4 1 - * 8 9 + /", PostfixExpression.convertToPostfix(infixExp));
    }

    public void testDoubleBracketExpression()
    {
        String infixExp = "(4+8)*(6-5)/((3-2)*(2+2))";
        String toPostfix = PostfixExpression.convertToPostfix(infixExp);
        String expected = "4 8 + 6 5 - * 3 2 - 2 2 + * /";
        assertEquals(expected, toPostfix);
    }
}
