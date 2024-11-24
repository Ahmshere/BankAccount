package helpers;

import java.util.Random;

public class PostCodeGenerator {
    public static String generatePostCode() {
        Random random = new Random();
        int length = random.nextBoolean() ? 5 : 6;
        StringBuilder postCode = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            postCode.append(digit);
        }
        return postCode.toString();
    }
}
