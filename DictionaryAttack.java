import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryAttack {
    public static void main(String[] args) {
        try {
            // Load the hashed passwords from the file
            List<String> hashedPasswords = loadHashedPasswords("passwords.txt");

            // Load the rockyou dictionary
            List<String> dictionary = loadDictionary("rockyou.txt");

            // Attempt to crack each hashed password
            for (String hashedPassword : hashedPasswords) {
                String crackedPassword = crackPassword(hashedPassword, dictionary);
                if (crackedPassword != null) {
                    System.out.println("Cracked password: " + crackedPassword);
                } else {
                    System.out.println("Password not found in dictionary.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load hashed passwords from a file
    private static List<String> loadHashedPasswords(String filePath) throws IOException {
        List<String> hashedPasswords = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            hashedPasswords.add(line.trim());
        }
        reader.close();
        return hashedPasswords;
    }

    // Load the rockyou dictionary
    private static List<String> loadDictionary(String filePath) throws IOException {
        List<String> dictionary = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            dictionary.add(line.trim());
        }
        reader.close();
        return dictionary;
    }

    // Attempt to crack a hashed password using a dictionary attack
    private static String crackPassword(String hashedPassword, List<String> dictionary) {
        for (String password : dictionary) {
            String hashedAttempt = hashPassword(password);
            if (hashedAttempt.equals(hashedPassword)) {
                return password;
            }
        }
        return null; // Password not found in dictionary
    }

    // Hash a password using MD5
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
