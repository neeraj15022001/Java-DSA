package CodeStudioPractice;

import java.util.*;

public class PrefixSumArray {
    private static final int mod = (int) (Math.pow(10, 9) + 7);

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
        List<Integer> ans = new ArrayList<>();

        int[] prefixSumArray = new int[n + 1];
        prefixSumArray[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSumArray[i] = (prefixSumArray[i - 1] + arr[i - 1]) % mod;
        }
        for (List<Long> range : queries) {
            long leftIndex = range.get(0);
            long rightIndex = range.get(1);
            long prevSum = giveContiguousSum(prefixSumArray, leftIndex - 1, n);
            long wholeSum = giveContiguousSum(prefixSumArray, rightIndex, n);
            ans.add((int) (wholeSum - prevSum + mod) % mod);
        }
        return ans;
    }

    private static long giveContiguousSum(int[] prefixArr, long index, int numberOfElements) {
        long sum = 0;
        long wholePairs = (index / numberOfElements) % mod;
        long leftElements = (index % numberOfElements);
        sum = ((prefixArr[prefixArr.length - 1] * wholePairs) % mod + prefixArr[(int) leftElements]) % mod;
        return sum;
    }
}

class PrefixSumArrayRunner {
    public static void main(String[] args) {
        int[] arr = {5,2,6,9};
        int n = 4;
        int q = 3;
        List<Long> query1 = new ArrayList<>();
        query1.add(1L);
        query1.add(5L);
        List<Long> query2 = new ArrayList<>();
        query2.add(10L);
        query2.add(13L);
        List<Long> query3 = new ArrayList<>();
        query3.add(7L);
        query3.add(11L);

        ArrayList<List<Long>> queriesToBeAdded= new ArrayList<>();
        queriesToBeAdded.add(query1);
        queriesToBeAdded.add(query2);
        queriesToBeAdded.add(query3);
        List<List<Long>> queries = new ArrayList<>(queriesToBeAdded);

        List<Integer> ans = PrefixSumArray.sumInRanges(arr, n, queries, q);
        for (Integer answers : ans) {
            System.out.println(answers);
        }
    }
}
