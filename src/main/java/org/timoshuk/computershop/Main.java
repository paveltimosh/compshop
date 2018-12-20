package org.timoshuk.computershop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Main  {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final org.slf4j.Logger LOG2 = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Вася");
        list.add("Петя");
        list.add("Шура");
        list.add("Коля");

        Iterator iterator = list.iterator();
        int counter = 1;
        while (iterator.hasNext()){
            if (counter%2 == 0) {
                iterator.remove();
            }
            System.out.println(iterator.next());
            counter++;
        }

        System.out.println(list);
    }

}

