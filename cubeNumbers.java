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

    private static int chooseMode(Scanner in) {
        System.out.println("Review information (1) or practice solving cubic roots (2)?");
        int mode = 0;
        String error = "Answer \'1\' for review or \'2\' for practice: ";
        mode = waitForInt(in,error);
        if (mode != 1 && mode != 2) {
            System.out.println("Default mode (2) chosen.");
            mode = 2;
        }
        return mode;
    }

    private static void practiceModeInfo(int n_min, int n_max) {
        System.out.println("Choosing numbers in the range ["+n_min+","+n_max+"]");
        System.out.println("Type \'exit\', \'quit\' or \'q\' to close the program.");
        System.out.println("Type \'mode\' to change the mode.\n");
    }

    private static int verifyAnswer(int answer, int n, int streak) {
        if (answer == n) {
            streak +=1;
            System.out.println("Your answer ("+n+") is correct. Streak: " + streak);
        } else {
            streak = 0;
            System.out.println("Your answer is wrong. The correct answer is " + n + ".");
        }
        return streak;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n_min = 1;
        int n_max = 100;

        if (args.length < 2) {
            System.out.println("Range missing, using default. Specify range like this: java cubeNumbers <min> <max>");
        } else {
            // Changing input to int
            try{
                n_min = Integer.parseInt(args[0]);
                n_max = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) {
                System.out.println("Range missing, using default. Specify range like this: java cubeNumbers <min> <max>");
            }

            // Changing the names if min is more than max
            if (n_min > n_max) {
                int n_temp = n_min;
                n_min = n_max;
                n_max = n_temp;
            }
        }

        // Choosing mode
        int mode = chooseMode(in);
        int streak = 0;

        boolean continueGame = true;
        while (continueGame) {
            // Review-mode
            if (mode == 1) {
                reviewNumbers(n_min, n_max);
                mode = 2;
            }

            // Practice-mode
            if (mode == 2) {
                practiceModeInfo(n_min, n_max);

                boolean continueMode = true;
                while (continueMode) {
                    // Randomly generating the answer
                    int n = (int) ((Math.random() * (n_max - n_min)) + n_min);

                    boolean answerIsNumber = false;
                    while (!answerIsNumber) {
                        answerIsNumber = true;

                        // Presenting the task and getting the answer from the user
                        System.out.println("What is the cubic root of " + n*n*n + "?");
                        String ans_str = in.nextLine().trim().toLowerCase();

                        if (ans_str.equals("exit") || ans_str.equals("quit") || ans_str.equals("q")) {
                            continueMode = false;
                            continueGame = false;
                        } else if (ans_str.equals("mode")) {
                            continueMode = false;
                            mode = chooseMode(in);
                        } else {
                            answerIsNumber = isInt(ans_str,"The answer must be an integer.");
                            if (answerIsNumber) {
                                // Verifying the answer
                                int answer = Integer.parseInt(ans_str);
                                streak = verifyAnswer(answer,n,streak);
                            }
                        }
                    }
                }
            }
        }
    }
}
