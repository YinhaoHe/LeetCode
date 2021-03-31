import java.util.*;

class Main{

     public static void main(String []args){
        String out = solution("1A 1B,2C 2C","1B" );
        System.out.println(out);
     }
     
     public static String solution(String S, String T){
         
         String[] Tstr = T.split("\\s+");
         String[] sstr = S.split(","); 
         Set<String> set = new HashSet();
         
         for(String s: Tstr)
            set.add(s);
            
        int sunk = 0, hit = 0;
        for(int i=0; i<sstr.length; i++){
            String[] s = sstr[i].split("\\s+");
            int R1 = Integer.parseInt(s[0].substring(0, s[0].length()-1));
            char C1 = s[0].charAt(s[0].length()-1);
            int R2 = Integer.parseInt(s[1].substring(0, s[1].length()-1));
            char C2 = s[1].charAt(s[1].length()-1);
            
            //System.out.println(R1+" "+C1+" "+R2+" "+C2);
            int total = 0, count = 0;
            for(int r = R1; r<= R2; r++){
                for(char c = C1; c<= C2; c++){
                    total++;
                    String tmp = ""+r+c;
                    if(set.contains(tmp)){
                        count++;
                    }
                }
            }
            
            if(total == count){
                sunk++;
            }
            else if(count>0){
                hit++;
            }
            
        }
         return " "+sunk+","+hit; 
     }
}