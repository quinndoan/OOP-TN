package hust_soict_globalict_garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "src\\hust_soict_globalict_garbage\\CircuitJS1_Desktop_Mod_1.2.5_x64_setup.exe";
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace(); // In thong tin ve loi
            return; // Thoat khoi chuong trinh vi khong the doc file
        }

        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b: inputBytes){
            outputString += (char)b;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
