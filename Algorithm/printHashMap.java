// 此时哈希表输出是无序的
public class Hash_Map_Demo { 
    public static void main(String[] args) 
    { 
  
        // Creating an empty HashMap 
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>(); 
  
        // Mapping int values to string keys 
        hash_map.put("Geeks", 10); 
        hash_map.put("4", 15); 
        hash_map.put("Geeks", 20); 
        hash_map.put("Welcomes", 25); 
        hash_map.put("You", 30); 
  
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map); 
  
        // Using keySet() to get the set view of keys 
        System.out.println("The set is: " + hash_map.keySet()); 
    } 
} 

// 若想有序输出HashMap

public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // HashMap<String,double> hashMap = new
        // HashMap<String,double>();///Syntax error on token "double",
        // Dimensions expected after this token
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        hashMap.put("aa", 90.0);
        hashMap.put("bb", 80.0);
        hashMap.put("cc", 70.0);

        找到对应的Key值

        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        Iterator iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ":" + value);
 
        }
 
    }
 
}
