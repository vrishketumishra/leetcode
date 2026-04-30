package TwoPointer_SlindingWindow;
import java.util.HashMap;

public class FruitsintoBasket {
    public static  int totalFruit(int[] fruits) {
        int l=0;
        int r=0;
        int Maxlen=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r<fruits.length){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while(map.size()>2){
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()<=2){
                Maxlen=Math.max(Maxlen,(r-l+1));
            }
            r++;
        }
        return Maxlen;
    }

    static void main() {
       int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
}
