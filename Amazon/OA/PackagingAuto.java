import java.util.*;

public class PackagingAuto {
    public static int packaging(int[] arr) {
        if (arr.length == 1){
            return 1;
        }
    
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for (int kk : arr){
            m.put(kk, m.getOrDefault(kk, 0) + 1);
        }

        int i = 0;
        int maxRes = 1;
        int borrowed = 0;
        ArrayList res = new ArrayList<Integer>();
        
        while (i < arr.length){
            
            if (m.containsKey(maxRes)){
                int payBack = m.get(maxRes) - borrowed;
                
                if (payBack == 0){
                    res.add(maxRes);
                    i++;
                    borrowed++;
                }
                
                else if (payBack > 0){
                    for (int j = 0; j < payBack; j++){
                        res.add(maxRes);
                    }
                    i += payBack;
                }
                
                else{
                    return arr.length;
                }
                
                borrowed -= m.get(maxRes);
                if (borrowed < 0){
                    borrowed = 0;
                }
                
            }
            
            else{
                res.add(maxRes);
                i++;
                borrowed++;
            }
            maxRes++;
        }

        return (int)res.get(arr.length - 1);
    }

    public static void main(String[] args) {
        // int[] arr = {3, 1, 3, 4};
        int[] arr = {1, 1, 1, 1};
        System.out.print(packaging(arr));
    }
}