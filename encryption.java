/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que.5 Program that can perform encryption and decryption
*/
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a message: ");
        String message = scanner.nextLine();
        
        System.out.print("Enter the encryption key (a number): ");
        int key = scanner.nextInt();
        
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);
        
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
    
    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + key) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        
        return encrypted.toString();
    }
    
    public static String decrypt(String encryptedMessage, int key) {
        StringBuilder decrypted = new StringBuilder();
        
        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) ((c - base - key + 26) % 26 + base));
            } else {
                decrypted.append(c);
            }
        }
        
        return decrypted.toString();
    }
}
