package com.kurotkin;

/**
 * Created by Vitaly on 03.05.17.
 */
public class Printer {
    public static void printDevice(Device[] data) {
        for(Device d : data) {
            System.out.println(d.name);
            for (Content c : d.content) {
                System.out.println(c.name + " = " + c.val.toString());
            }
            System.out.println();
        }
        System.out.println(data[0].name);
    }

    public static String getT(Device[] data) {
        for(Device d : data) {
            if (d.name.equals("balc")) {
                for (Content c : d.content) {
                    if (c.name.equals("t1")) {
                        return c.val.toString();
                    }
                }
            }
        }
        return "fail";
    }
}
