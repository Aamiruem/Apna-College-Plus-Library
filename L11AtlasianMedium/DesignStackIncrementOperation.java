// package L11AtlasianMedium;



import java.util.*;

class CustomStack {

    Stack<Integer> s1;
    Stack<Integer> s2;
    int currSize;
    int maxSize;

    public CustomStack(int maxSize) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        currSize = 0;
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (currSize < maxSize) {
            s1.push(x);
            currSize++;
        }
    }

    public int pop() {
        if (currSize == 0) {
            return -1;
        }
        int top = s1.pop();
        currSize--;
        return top;
    }

    public void increment(int k, int val) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        while (!s2.isEmpty() && k-- > 0) {
            s1.push(s2.pop() + val);
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}

public class DesignStackIncrementOperation {

    public static void main(String[] args) {
        CustomStack cstack = new CustomStack(3);
        cstack.push(1);
        cstack.push(2);
        cstack.push(3);

        cstack.increment(2, 100);
        System.out.println(cstack.pop() + " " + cstack.pop());
    }
}
