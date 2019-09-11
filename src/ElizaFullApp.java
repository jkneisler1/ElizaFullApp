import java.util.Scanner;
import java.util.Random;

/**
 * Replacements:
 ***************
 *      replace i with you
 *      replace me with you
 *      replace my with your
 *      replace am with are
 */

public class ElizaFullApp {
    public static void main(String[] args) {
        String greeting = "Good day.  What is your problem?  ";
        String userPrompt = "Enter your response here or enter Q to quit: ";
        boolean sessionActive = true;
        Scanner key = new Scanner(System.in);
        String userQu;
        String[] userReplace;
        StringBuilder userResp = new StringBuilder();
        String output;
        int hedgeIdx;
        int qualfIdx;
        String[] hedges = new String[3];
        hedges[0] = "Please tell me more";
        hedges[1] = "Many of my patients tell me the same thing";
        hedges[2] = "It is getting late, maybe we had better quit";

        String[] qualifiers = new String[3];
        qualifiers[0] = "Why do you say that";
        qualifiers[1] = "You seem to think that";
        qualifiers[2] = "So, you are concerned that";

        Random rand = new Random();

        System.out.print(greeting);

        while (sessionActive) {
            System.out.println(userPrompt);
            userQu = key.nextLine();
            hedgeIdx = rand.nextInt(3);
            qualfIdx = rand.nextInt(3);

            if (userQu.equalsIgnoreCase("q")) {
                sessionActive = false;
                System.out.println(">>> END");
            } else {
                userReplace = userQu.split(" ");            // split the user's question into tokens
                for (String token : userReplace) {
                    if (token.equalsIgnoreCase("i")) {
                        userResp.append("you ");
                    }
                    else if (token.equalsIgnoreCase("me")) {
                        userResp.append("you ");
                    }
                    else if (token.equalsIgnoreCase("my")) {
                        userResp.append("your ");
                    }
                    else if (token.equalsIgnoreCase("am")) {
                        userResp.append("are ");
                    }
                    else {
                        userResp.append(token + " ");
                    }
                }
                output = qualifiers[qualfIdx] + " " + userResp.toString() + "  " + hedges[hedgeIdx];
                System.out.println(output);
                userResp.delete(0, userResp.length());
            }
        }
    }
}
