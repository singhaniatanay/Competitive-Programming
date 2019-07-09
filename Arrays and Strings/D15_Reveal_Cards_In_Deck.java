import java.util.*;

public class D15_Reveal_Cards_In_Deck {

    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input a deck of cards
    // It should return the answer deck
    public static int[] deckRevealedIncreasing(int[] deck) {
        //write code here
        Arrays.sort(deck);
        int[] indexes = new int[deck.length];
        Queue<Integer> indexQ = new LinkedList<>();
        int i=0;
        int j=0;
        while (i<deck.length){
            indexQ.add(i);
            i++;
        }
        while (!indexQ.isEmpty()){
            indexes[j] = indexQ.remove();
            j++;
            if(!indexQ.isEmpty()){
                indexQ.add(indexQ.remove());
            }
        }
        int k=0;
        int[] arr= new int[deck.length];
        for(int l:indexes){
            arr[l] = deck[k++];
        }
        return arr;
    }
    // -----------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = deckRevealedIncreasing(arr);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

}