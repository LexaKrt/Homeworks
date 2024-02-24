import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /*public static void main(String[] args) throws EmptyElementException {
        List304<String> list = new List304ImplAsLinkedList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        System.out.println(list.get(0) + list.get(1));
    }*/
    public static void main(String[] args) throws EmptyElementException {
        Scanner scanner = new Scanner(System.in);

        List304ImplAsLinkedList<Integer> list = new List304ImplAsLinkedList<>();
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter the num you want to add: ");
            int num = scanner.nextInt();
            System.out.println();

            list.add(num);
            list.printList();
        }

        System.out.println("pop: " + list.pop(2));
        list.printList();
        list.delete(3);
        list.printList();
    }
    /*public static void main(String[] args) throws EmptyElementException {
        Scanner scanner = new Scanner(System.in);

        List304ImplAsArrayList<String> list = new List304ImplAsArrayList<>(3);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the num you want to add: ");
            String num = scanner.next();
            System.out.println();

            list.add(num);
            System.out.println(Arrays.toString(list.getArray()));
        }

        System.out.println("pop: " + list.pop(2));
        System.out.println(Arrays.toString(list.getArray()));

        list.delete(3);
        System.out.println(Arrays.toString(list.getArray()));
    }*/
}
