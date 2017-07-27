package com.matteojoliveau.benchmark.msgpack;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {
    private final static ObjectMapper mpackMapper = new ObjectMapper(new MessagePackFactory());
    private final static ObjectMapper jsonMapper = new ObjectMapper();
    private final static double TIMES = 200000;

    public static void main(String[] args) throws IOException {
        final double times;
        if (args.length == 0) {
            times = TIMES;
        } else {
            times = Double.valueOf(args[0]);
        }

        System.out.println("--------------------------------");
        System.out.println("Testing JSON (" + times + " objects)");
        System.out.println("--------------------------------");
        double totalToJson = 0L;
        double totalFromJson = 0L;
        for (int i = 0; i < times; i++) {
            SecureRandom random = new SecureRandom();
            Address address = new Address(new BigInteger(130, random).toString(32), new BigInteger(130, random).toString(32), new BigInteger(130, random).toString(32), new BigInteger(130, random).intValue());
            Person person = new Person(new BigInteger(130, random).toString(32), new BigInteger(130, random).toString(32), new BigInteger(130, random).intValue(), address, null);
            double startT = System.currentTimeMillis();
            byte[] b = jsonMapper.writeValueAsBytes(person);
            double finishT = System.currentTimeMillis();
            totalToJson = totalToJson + (finishT - startT);

            double startF = System.currentTimeMillis();
            Person obj = jsonMapper.readValue(b, Person.class);
            double finishF = System.currentTimeMillis();
            totalFromJson = totalFromJson + (finishF - startF);
        }

        System.out.println(String.format("To JSON:\n    Total: %f ms\n    Average: %f ms", totalToJson, totalToJson / times));
        System.out.println(String.format("From JSON:\n    Total: %f ms\n    Average: %f ms", totalFromJson, totalFromJson / times));

        System.out.println("");

        System.out.println("--------------------------------");
        System.out.println("Testing MessagePack (" + times + " objects)");
        System.out.println("--------------------------------");
        double totalToMsgPack = 0L;
        double totalFromMsgPack = 0L;
        for (int i = 0; i < times; i++) {
            SecureRandom random = new SecureRandom();
            Address address = new Address(new BigInteger(130, random).toString(32), new BigInteger(130, random).toString(32), new BigInteger(130, random).toString(32), new BigInteger(130, random).intValue());
            Person person = new Person(new BigInteger(130, random).toString(32), new BigInteger(130, random).toString(32), new BigInteger(130, random).intValue(), address, null);
            double startT = System.currentTimeMillis();
            byte[] b = mpackMapper.writeValueAsBytes(person);
            double finishT = System.currentTimeMillis();
            totalToMsgPack = totalToMsgPack + (finishT - startT);

            double startF = System.currentTimeMillis();
            Person obj = mpackMapper.readValue(b, Person.class);
            double finishF = System.currentTimeMillis();
            totalFromMsgPack = totalFromMsgPack + (finishF - startF);
        }


        System.out.println(String.format("To MsgPack:\n    Total: %f ms\n    Average: %f ms", totalToMsgPack, totalToMsgPack / times));
        System.out.println(String.format("From MsgPack:\n    Total: %f ms\n    Average: %f ms", totalFromMsgPack, totalFromMsgPack / times));

    }
}
