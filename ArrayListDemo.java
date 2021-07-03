import java.util.ArrayList;
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        list1.remove(3);
        printLine();
        printArrayList(list1);
        list1.set(2,100);
        printLine();
        printArrayList(list1);
    }

    public static void printLine() {
        System.out.println("----------------------------------------");
    }

    public static void printArrayList(ArrayList<Integer> arrayList) {
        for (int element : arrayList) {
            System.out.println(element);
        }
    }

}
