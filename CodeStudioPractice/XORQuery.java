package CodeStudioPractice;

public class XORQuery {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length;) {
            int[] query = queries[i];
            for (int k : query) {
                System.out.println("query :" + k);
            }
            int leftIndex = query[0];
            int rightIndex = query[1];
            int xor = arr[0];
            for (int j = leftIndex + 1; j <= rightIndex; j++) {
                xor ^= arr[j];
            }
            ans[i++] = xor;
        }
        return ans;
    }
}

class XORQueryRunner {
    public static void main(String[] args) {
        int[] arr = {4,8,2,10};
        int[][] queries = {{2,3}, {1,3}, {0,0}, {0,3}};
        XORQuery.xorQueries(arr,queries);
    }
}