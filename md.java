/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que.6 Write a program to compute a message digest for a file of any type and any size. 

*/

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java md <file_path>");
            return;
        }

        String filePath = args[0];
        Path path = Paths.get(filePath);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            FileInputStream fis = new FileInputStream(path.toFile());
            DigestInputStream dis = new DigestInputStream(fis, md);

            byte[] buffer = new byte[8192];
            while (dis.read(buffer) != -1) {
                // Read the file and update the message digest
            }

            byte[] digest = md.digest();
            dis.close();

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            System.out.println("Message Digest (SHA-256): " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not found.");
        } catch (IOException e) {
            System.out.println("Error: Failed to read the file.");
        }
    }
}
