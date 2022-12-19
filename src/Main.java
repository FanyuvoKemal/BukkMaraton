import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("4. feladat:");
        int completedCount = 0;
        int failedCount = 0;

        try {
            Scanner scanner = new Scanner(new File("bukkm2019.txt"));
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.contains(";")){
                    String[] parts = line.split(";");
                    if (!parts[4].equals("")){
                        completedCount++;
                    }
                    else {
                        failedCount++;
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("A bukkm2019.txt fájl nem található!");
        }

        System.out.printf("A versenyzők %.2f százaléka nem teljesítette a versenyt.%n%n", 100 * (float)failedCount / (completedCount + failedCount));


    }
}