public class LinkedListMinStack implements MinStack {

    Node top = null;
    Node min = null;

    @Override
    public int min() throws StackEmptyException {
        if(min == null) throw new StackEmptyException();
        return min.data;
    }

    @Override
    public void push(int element) {
        Node tmp = new Node(element);
        if(top == null) {
            top = tmp;
            min = tmp;
        } else {
            tmp.next = top;
            top = tmp;
            if(min.data > element) {
                tmp.minNext = min;
                min = tmp;
            } else {
                Node nextMin = min.minNext;
                Node prevMin = min;
                while(nextMin != null) {
                    if( nextMin.data > element) {
                        tmp.minNext = nextMin;
                        prevMin.minNext = tmp;
                        break;
                    }
                    prevMin = nextMin;
                    nextMin = nextMin.minNext;
                }
            }
        }

    }

    @Override
    public int pop() throws StackEmptyException {
        if(isEmpty()) throw new StackEmptyException();
        int retVal = top.data;
        if( min == top ) {
            min = min.minNext;
        } else {
            Node currMin = min.minNext;
            Node prevMin = min;
            while(currMin != null) {
                if(currMin == top) {
                    prevMin.minNext = currMin.minNext;
                    break;
                }
                prevMin = currMin;
                currMin = currMin.minNext;
            }
        }
        top = top.next;
        return retVal;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int peek() throws StackEmptyException {
        if(isEmpty()) throw new StackEmptyException();
        return top.data;
    }

    static class Node {
        int data;
        Node next;
        Node minNext;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.minNext = null;

        }

        @Override
        public String toString() {
            String nextData = "";
            if(next != null) {
                nextData = next.data + "";
            }
            String minNextData = "";
            if(minNext != null) {
                minNextData = minNext.data + "";
            }
            return "Node{" +
                    "data=" + data +
                    ", next=" + nextData +
                    ", minNext=" + minNextData +
                    '}';
        }
    }





    public static void main(String[] args) throws StackEmptyException {

        MinStack minStack = new LinkedListMinStack();

        minStack.push(5);

        System.out.println("after inserting 5, min is: "+ minStack.min() + " and top is "+ minStack.peek()) ;
        minStack.push(3);
        System.out.println("after inserting 3, min is: "+ minStack.min() + " and top is "+ minStack.peek()) ;
        minStack.push(9);
        System.out.println("after inserting 9, min is: "+ minStack.min() + " and top is "+ minStack.peek()) ;
        minStack.push(0);
        System.out.println("after inserting 0, min is: "+ minStack.min() + " and top is "+ minStack.peek()) ;

        System.out.println("peeked value after inserting all elements without removing top: "+ minStack.peek());


        System.out.println("after calling pop, top: "+ minStack.pop() + " and min is: " + minStack.min());

        System.out.println("after calling pop, top: "+ minStack.pop() + " and min is: " + minStack.min());

        System.out.println("after calling pop, top: "+ minStack.pop() + " and min is: " + minStack.min());


        try {
            System.out.println("after calling pop, top: " + minStack.pop());
            minStack.min();
        } catch(StackEmptyException s) {
            System.out.println("min should have thrown error");
        }

        LinkedListMinStack minStack2 = new LinkedListMinStack();

        minStack2.push(6);

        System.out.println("after inserting 6, min is: "+ minStack2.min + " and top is "+ minStack2.top) ;
        minStack2.push(3);
        System.out.println("after inserting 3, min is: "+ minStack2.min + " and top is "+ minStack2.top) ;
        minStack2.push(5);
        System.out.println("after inserting 5, min is: "+ minStack2.min + " and top is "+ minStack2.top) ;
        minStack2.push(2);
        System.out.println("after inserting 2, min is: "+ minStack2.min + " and top is "+ minStack2.top) ;
        minStack2.push(8);
        System.out.println("after inserting 8, min is: "+ minStack2.min + " and top is "+ minStack2.top) ;

        System.out.println("peeked value after inserting all elements without removing top: "+ minStack2.peek() + " min is " + minStack2.min());


        System.out.println("after popping top: "+ minStack2.pop() + " and min is: " + minStack2.min());

        System.out.println("after popping top: "+ minStack2.pop() + " and min is: " + minStack2.min());

        System.out.println("after popping top: "+ minStack2.pop() + " and min is: " + minStack2.min());


        System.out.println("after popping top: "+ minStack2.pop() + " and min is: " + minStack2.min());

        try {
            System.out.println("after calling pop, top: " + minStack2.pop());
            minStack2.min();
        } catch(StackEmptyException s) {
            System.out.println("min should have thrown error");
        }

        LinkedListMinStack minStack3 = new LinkedListMinStack();

        minStack3.push(6);


        System.out.println("after inserting 6, min is: "+ minStack3.min + " and top is "+ minStack3.top) ;
        minStack3.push(3);
        System.out.println("after inserting 3, min is: "+ minStack3.min + " and top is "+ minStack3.top) ;
        minStack3.push(5);
        System.out.println("after inserting 5, min is: "+ minStack3.min + " and top is "+ minStack3.top) ;
        minStack3.push(2);
        System.out.println("after inserting 2, min is: "+ minStack3.min + " and top is "+ minStack3.top) ;
        minStack3.push(4);
        System.out.println("after inserting 4, min is: "+ minStack3.min + " and top is "+ minStack3.top) ;

        System.out.println("peeked value after inserting all elements without removing top: "+ minStack3.peek() + " min is " + minStack3.min());


        System.out.println("after popping top: "+ minStack3.pop() + " and min is: " + minStack3.min());

        System.out.println("after popping top: "+ minStack3.pop() + " and min is: " + minStack3.min());

        System.out.println("after popping top: "+ minStack3.pop() + " and min is: " + minStack3.min());


        System.out.println("after popping top: "+ minStack3.pop() + " and min is: " + minStack3.min());

        try {
            System.out.println("after calling pop, top: " + minStack3.pop());
            minStack3.min();
        } catch(StackEmptyException s) {
            System.out.println("min should have thrown error");
        }


    }
}
