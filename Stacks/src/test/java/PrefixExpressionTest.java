import junit.framework.TestCase;

/**
 * Created by mssw on 4/6/14.
 */
public class PrefixExpressionTest extends TestCase {

    public void testSimpleExpression()
    {
        String infixExp = "A+B-C";
       assertEquals("- + A B C", PrefixExpression.convertToPrefix(infixExp));
    }

    public void testSingleBracketExpression()
    {
        String infixExp = "(2+3)*(4-1)";
        assertEquals("* + 2 3 - 4 1", PrefixExpression.convertToPrefix(infixExp));
    }

    public void testSingleBracketExpressionAnother()
    {
        String infixExp = "A/B*C-D+E/F/(G+H)";
        String toPrefix = PrefixExpression.convertToPrefix(infixExp);
        String expected = "+ - * / A B C D / / E F + G H";
        assertEquals(expected, toPrefix);
    }

    public void testDoubleBracketExpression()
    {
        String infixExp = "((A+B)*C-(D-E))*(F+G)";
        String toPrefix = PrefixExpression.convertToPrefix(infixExp);
        String expected = "* - * + A B C - D E + F G";
        assertEquals(expected, toPrefix);
    }

    public void testAnotherBracketExpression()
    {
        String infixExp = "A-B/(C*D/E)";
        String toPrefix = PrefixExpression.convertToPrefix(infixExp);
        String expected = "- A / B / * C D E";
        assertEquals(expected, toPrefix);
    }





}
