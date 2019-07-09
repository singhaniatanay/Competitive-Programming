import java.util.*;

public class D8_double_pair_array {
    public static boolean canReorder(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; i++) {
        }
        for (int key : keys) {
            if (key < 0 && map.get(key) != 0) {
                if (key % 2 != 0) {
                    return false;
                }
                if (map.containsKey(key / 2)) {
                    map.put(key / 2, map.get(key / 2) - 1);
                } else {
                    return false;
                }
                map.put(key, map.get(key) - 1);
            } else if (key == 0) {
                if (!(map.get(key) % 2 == 0)) {
                    return false;
                }
            } else if (key > 0 && map.get(key) > 0) {
                if (map.containsKey(2 * key) && map.get(2 * key) != 0) {
                    map.put(2 * key, map.get(2 * key) - 1);
                } else {
                    return false;
                }
                map.put(key, map.get(key) - 1);
            }
        }

        for (int key : keys) {
            if (key != 0 && map.get(key) != 0) {
                System.out.println(50);

                return false;
            }
        }
        return true;

    }


    // Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[sc.nextInt()];
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();
        System.out.println(canReorder(a));

    }

}