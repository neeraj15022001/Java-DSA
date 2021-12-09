package CodeStudioPractice;

import java.util.*;

public class PaintTheFence {

    public static int paintTheFence(ArrayList<ArrayList<Integer>> ranges, int n, int q) {
        // Write your code here.
        HashMap<Integer, Integer> rangeBounds = new HashMap<>();
        int numberOfWallsPainted = 0;
        for (ArrayList<Integer> range : ranges) {
            int leftBound = range.get(0);
            int rightBound = range.get(1);
            if (rangeBounds.containsKey(leftBound)) {
                int newDiff = rightBound - leftBound;
                int prevDiff = range.get(leftBound) - leftBound;
                if (newDiff > prevDiff) {
                    rangeBounds.put(leftBound, rightBound);
                }
            } else {
                rangeBounds.put(leftBound, rightBound);
            }
        }
        return numberOfWallsPainted;
    }
}