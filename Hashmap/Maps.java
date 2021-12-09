package Hashmap;

import java.util.*;

public class Maps<K, V> {
    ArrayList<MapsNode<K, V>> buckets;
    int size;
    int numBuckets;

    public Maps() {
        numBuckets = 5;
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    public int getPairsWithDifferenceK(int[] arr, int k) {
        //Write your code here
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int j : arr) {
            map.put(j, true);
        }
        Set<Integer> keys = map.keySet();
        int count = 0;
        for (Integer key : keys) {
            if (map.get(key)) {
                int upperValue = key + k;
                int lowerValue = key - k;
                if (map.containsKey(upperValue)) {
                    count += 1;
                    map.put(upperValue, false);
                }
                if (map.containsKey(lowerValue)) {
                    count += 1;
                    map.put(lowerValue, false);
                }
                map.put(key, false);
            }
        }
        return count;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    public double loadFactor() {
        return (1.0 * size) / numBuckets;
    }

    private void rehash() {
        System.out.println("Rehashing buckets " + numBuckets + " " + size);
        ArrayList<MapsNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2 * numBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
        numBuckets *= 2;
        for (int i = 0; i < temp.size(); i++) {
            MapsNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapsNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapsNode<K, V> newNode = new MapsNode<>(key, value);
        size++;
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        double loadFactor = (1.0 * size) / numBuckets;
        if (loadFactor > 0.7) {
//            rehashing
            rehash();
        }
    }

    public int size() {
        return size;
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapsNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapsNode<K, V> head = buckets.get(bucketIndex);
        MapsNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                size--;
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(bucketIndex, head.next);
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }
}

