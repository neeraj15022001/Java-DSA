package Hashmap;

public class MapsUse {
    public static void main(String[] args) {
//        Maps<String, Integer> map = new Maps<>();
//        for (int i = 0; i < 20; i++) {
//            map.insert("abc" + i, 1 + i);
//            System.out.println("i = " + i + " lf = " + map.loadFactor());
//        }
//        map.removeKey("abc3");
//        map.removeKey("abc7");
//        for (int i = 0; i < 20; i++) {
//            System.out.println("abc" + i + ":" + map.getValue("abc" + i));
//        }
        Maps<Integer, Boolean> map = new Maps<>();
        int[] arr = {5, 1, 2, 4};
        System.out.println(map.getPairsWithDifferenceK(arr, 3));
    }
}
