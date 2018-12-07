package org.vironit.timoshuk.computershop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Main  {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final org.slf4j.Logger LOG2 = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println(Long.toHexString(Double.doubleToLongBits(Math.random())));
        System.out.println( UUID.randomUUID().toString());
    }

}

