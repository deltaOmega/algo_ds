public interface Stack {

    void push(int element);
    int pop() throws StackEmptyException;
    boolean isEmpty();
    int peek() throws StackEmptyException;
}
