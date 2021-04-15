import java.util.Scanner;

class cubeNumbers {
    private static void reviewNumbers(int n_min, int n_max) {
        System.out.println("Review numbers:");
        int loop_min = (int)(n_min/10);
        int loop_max = (int)(n_max/10);
        for (int i = loop_min; i <= loop_max; i++) {
            System.out.println(i + "^3 = " + i*i*i);
        }
        System.out.println();
    }

    private static boolean isInt(String s, String error) {
        try{
            int i = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            System.out.println(error);
            return false;
        }
        return true;
    }

    private static int waitForInt(Scanner in, String error) {
        String answer_str = "";
        boolean answerIsNumber = false;
        while (!answerIsNumber) {
            answer_str = in.nextLine().trim();
            answerIsNumber = isInt(answer_str,error);
        }
        return Integer.parseInt(answer_str);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n_min = 1;
        int n_max = 100;

        if (args.length < 2) {
            System.out.println("Range missing, using default. Specify range like this: java cubeNumbers <min> <max>");
        } else {
            // Gjør om input til int
            try{
                n_min = Integer.parseInt(args[0]);
                n_max = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) {
                System.out.println("Range missing, using default. Specify range like this: java cubeNumbers <min> <max>");
            }

            // Endrer navnene dersom min er mer enn max
            if (n_min > n_max) {
                int n_temp = n_min;
                n_min = n_max;
                n_max = n_temp;
            }
        }

        System.out.println("Review information (1) or practice solving cubic roots (2)?");
        String error = "Answer \'1\' for review or \'2\' for practice: ";
        int mode = waitForInt(in,error);
        int streak = 0;

        if (mode == 1) {
            reviewNumbers(n_min, n_max);
            mode = 2;
        }
        if (mode == 2) {
            System.out.println("Choosing numbers in the range ["+n_min+","+n_max+"]");
            System.out.println("Type \'exit\', \'quit\' or \'q\' to close the program.\n");
            boolean exit = false;
            while (!exit) {
                boolean answerIsNumber = false;
                // Finner svaret
                int n = (int)(Math.random() * ((n_max-n_min)+1) + n_min);
                while (!answerIsNumber) {
                    answerIsNumber = true;
                    // Presenterer oppgaven for bruker og tar inn brukers svar
                    System.out.println("What is the cubic root of " + n*n*n + "?");
                    String ans_str = in.nextLine().trim().toLowerCase();

                    if (ans_str.equals("exit") || ans_str.equals("quit") || ans_str.equals("q")) {
                        exit = true;
                    } else {
                        // Prøver å gjøre om til int
                        int answer = 0;
                        try {
                            answer = Integer.parseInt(ans_str);
                        } catch(NumberFormatException e) {
                            answerIsNumber = false;
                        }
                        if (answerIsNumber) {
                            // Verifiserer svaret
                            if (answer == n) {
                                streak +=1;
                                System.out.println("Your answer ("+n+") is correct. Streak: " + streak);
                            } else {
                                streak = 0;
                                System.out.println("Your answer is wrong. The correct answer is " + n + ".");
                            }
                        }
                    }
                }
            }
        }

    }
}
