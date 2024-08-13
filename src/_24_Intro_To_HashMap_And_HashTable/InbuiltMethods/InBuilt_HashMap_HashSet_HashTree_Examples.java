package _24_Intro_To_HashMap_And_HashTable.InbuiltMethods;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class InBuilt_HashMap_HashSet_HashTree_Examples {
    public static void main(String[] args) {
//        String name = "lavkushwaha";
//        Integer a = 12;
//        System.out.println(a.hashCode());//hashcode is converted into int
//        System.out.println(name.hashCode());

        //HashMap<key,val>
        HashMap<String,Integer> map = new HashMap<>();
        map.put("lav",20);
        map.put("Ram",30);
        map.put("Kunal",50);
        map.put("Rahul",60);

        System.out.println(map.get("lav"));//20
        System.out.println(map.getOrDefault("suresh",100));//100
        System.out.println(map.containsKey("lav"));//true
        System.out.println(map.clone());//{lav=20, Kunal=50, Rahul=60, Ram=30}
        System.out.println(map.replace("Rahul",60,900));
        System.out.println(map.entrySet());//[lav=20, Rahul=900, Kunal=50, Ram=30]

        //Remove (key,value)
        System.out.println(map.remove("Ram",30));

        //print all key value pair.
//        System.out.println(map.entrySet());//[lav=20, Rahul=900, Kunal=50, Ram=30]
        System.out.println(map);//{lav=20, Rahul=900, Kunal=50}



        //Hashset - No duplicates value will store in HashSet.
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(34);
        set.add(22);
        set.add(22);
        set.add(78);
        set.add(78);
        set.add(56);
        System.out.println(set);//[34, 22, 56, 10, 78]

        //TreeMap
        TreeMap<String,Integer> maps = new TreeMap<>();
        maps.put("lav",20);
        maps.put("Ram",30);
        maps.put("Kunal",50);
        maps.put("Rahul",60);

        System.out.println(maps);

    }
}
