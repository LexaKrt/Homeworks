import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main1 {
    /*public static void main(String[] args) throws EmptyElementException{
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }*/
    public static void main(String[] args) throws EmptyElementException, ArrayOverflowException {
        Set<Integer> set = new Set<>(new Integer[10], 0);

        set.add(1);
        set.add(2);
        set.add(2);

        set.add(3);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(5);
        set.add(6);

        set.delete(3);

        System.out.println(set.contains(3));
        System.out.println(Arrays.toString(set.asList()));
    }
}