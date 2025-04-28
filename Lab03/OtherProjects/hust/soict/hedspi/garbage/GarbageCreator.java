package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; // Bạn có thể đổi thành đường dẫn đến file bất kỳ
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; // Nối chuỗi bằng +
        }
        long endTime = System.currentTimeMillis();

        System.out.println("GarbageCreator Time: " + (endTime - startTime) + "ms");
    }
}