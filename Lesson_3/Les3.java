package Lesson_3;

import java.util.*;

public class Les3 {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<String> list = new ArrayList<>(Arrays.asList("qw","qwe", "qwee", "asd", "xzc", "gfd", "sad", "gfd", "qwee", "qwee"));
        Set<String> set = new LinkedHashSet<>(list);
        System.out.println(set);
        Iterator<String> iter = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
            System.out.println(iter.next() + " " + count);
            count = 0;
        }


        TelNumb spravochnik = new TelNumb();
        spravochnik.add("Snopok", "89966941005");
        spravochnik.add("Snopok", "2345");
        spravochnik.add("Sno", "834941005");
        spravochnik.get("Snopok");
    }
}
