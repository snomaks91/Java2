package Lesson_3;

import java.util.*;

public class TelNumb {

    public Map<String, Set<String>> telNumb = new HashMap<String, Set<String>>();

    public void add (String lastName, String number){
        Set<String> numb = new HashSet<>();
        if (telNumb.containsKey(lastName)) {
            telNumb.values().iterator().next().add(number);
        } else {
            numb.add(number);
            telNumb.put(lastName, numb);
        }
    }

    public void get (String lastName) {
        System.out.println(lastName + " " + telNumb.get(lastName));
    }
}

