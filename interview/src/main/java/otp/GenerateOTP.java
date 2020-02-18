package otp;

import java.util.Random;

/**
 * @author badrikant.soni
 * https://www.tutorialspoint.com/Generating-OTP-in-Java
 */
public class GenerateOTP {

    public static void main(String[] args) {

        System.out.println(generateOTP(4));
        System.out.println(generateOTP(4));
        System.out.println(generateOTP(4));
    }

    private static char[] generateOTP(int length) {

        String numbers = "1234567890";
        Random random = new Random();
        char[] otp = new char[length];
        for(int i = 0; i < length; i++){
            int num = random.nextInt(length);
            otp[i] = numbers.charAt(num);
        }
        return otp;
    }
}
