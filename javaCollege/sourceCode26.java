package com.example;

// import java.util.ArrayList;
// import java.util.List;
import java.util.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){

        List<String> blackpinkMembers = new ArrayList<String>();

        blackpinkMembers.add("Lisa");
        blackpinkMembers.add("Jennie");
        blackpinkMembers.add("Rose");
        blackpinkMembers.add("Jisoo");

        Iterator<String> blackpinkIter = blackpinkMembers.iterator();

        while (blackpinkIter.hasNext()){
            String member = blackpinkIter.next();

            if (member == "Rose"){
                blackpinkIter.remove();
            }

//            System.out.println(blackpinkIter.next());
        }
        blackpinkMembers.forEach(member -> System.out.println(member));


//        blackpinkIter.forEachRemaining(member -> System.out.println(member));
//
//        Map<String, String> map = new HashMap<String, String>();
//
//        map.put("Lisa", "Perempuan");
//        map.put("Jennie", "Perempuan");
//        map.put("Rose", "Perempuan");
//        map.put("Jiso", "Perempuan");
//
//        System.out.println(map.get("Lisa"));
//
//        map.clear();
//
//        map.forEach((key, value) -> System.out.println(key + " Berjenis Kelamin " + value));
//
//        System.out.println("");
//        List<String> blackpinkMembers = new ArrayList<String>();
//
//        blackpinkMembers.add("Lisa");
//        blackpinkMembers.add("Jennie");
//        blackpinkMembers.add("Rose");
//        blackpinkMembers.add("Jisoo");
//
//        System.out.println();
//        blackpinkMembers.forEach(member -> System.out.println(member));
//
//        System.out.println();
//        blackpinkMembers.removeIf(member -> member == "Rose" || member == "Jiso");
//
//        System.out.println();
//        blackpinkMembers.add("Rose");
//        blackpinkMembers.add("Jisoo");
//
//        blackpinkMembers.sort((member1, member2) -> member2.compareTo(member1));
//        blackpinkMembers.forEach(member -> System.out.println(member));
//
//        blackpinkMembers.removeAll(blackpinkMembers);


    }
}
