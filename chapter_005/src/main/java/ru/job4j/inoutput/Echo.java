package ru.job4j.inoutput;

public class Echo {
    public static void main(String[] args) {
//        for (String s: args) {
//            System.out.println(s);
//        }
        int firstArg;
        int secondArg;
        int thirdArg;
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
                secondArg = Integer.parseInt(args[1]);
                thirdArg = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
    }
}
