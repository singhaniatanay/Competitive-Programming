import java.util.*;

public class D13_Group_Shifted_Strings {

    // This is a functional problem. You have to complete this function.
    // It takes as input the a string array. It return a list of list of
    // strings of strings with same shifting sequence grouped together.

    public static List<List<String>> groupStrings(String[] strings) {
        // write your code here.
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String curr = strings[i];
            String delta = "";
            for (int j = 0; j < curr.length()-1; j++) {
                char a = curr.charAt(j);
                char b = curr.charAt(j+1);
                int d = b-a<0?b-a+26:b-a;
                delta+= ((int)d)+" ";
            }
            ArrayList<String> strings1 = map.getOrDefault(delta,new ArrayList<String>());
            strings1.add(curr);
            map.put(delta,strings1);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Length of the array
        int N = sc.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        List<List<String>> stringsGrouped = groupStrings(arr);

        for (List<String> lst : stringsGrouped) {
            Collections.sort(lst);
        }

        stringsGrouped.sort(new ListComparator());

        display(stringsGrouped);

    }

    // Comparator for sorting the result list.
    static class ListComparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> l1, List<String> l2) {

            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            for (int i = 0; i < l1.size(); i++) {
                String l1str = l1.get(i);
                String l2str = l2.get(i);

                return l1str.compareTo(l2str);

            }

            return 0;

        }
    }

    // Function to display a List of Lists of strings.
    public static void display(List<List<String>> list) {

        for (int i = 0; i < list.size(); i++) {

            List<String> currList = list.get(i);

            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }

            System.out.println();
        }

    }

}