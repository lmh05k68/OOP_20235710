package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; // Giống như file trên
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b : inputBytes) {
            outputStringBuffer.append((char) b); // Nối chuỗi bằng StringBuffer
        }
        String outputString = outputStringBuffer.toString();
        long endTime = System.currentTimeMillis();

        System.out.println("NoGarbage Time: " + (endTime - startTime) + "ms");
    }
}