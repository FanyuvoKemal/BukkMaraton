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

        System.out.println("5. feladat:");
        int femaleCount = 0;

        try {
            Scanner scanner = new Scanner(new File("bukkm2019.txt"));
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.contains(";")){
                    String[] parts = line.split(";");
                    if (parts[1].endsWith("n") && parts[0].startsWith("M")){
                        femaleCount++;
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("A bukkm2019.txt fájl nem található!");
        }

        System.out.printf("A rövidtávú versenyen %d női versenyző indult.%n%n", femaleCount);


        System.out.println("6. feladat:");
        boolean over6hours = false;

        try {
            Scanner scanner = new Scanner(new File("bukkm2019.txt"));
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.contains(";")){
                    String[] parts = line.split(";");
                    if (!parts[4].equals("")){
                        String[] timeParts = parts[4].split(":");
                        int hours = Integer.parseInt(timeParts[0]);
                        if (hours >= 6){
                            over6hours = true;
                            break;
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("A bukkm2019.txt fájl nem található!");
        }

        if (over6hours){
            System.out.println("Volt ilyen versenyző.");
        }
        else {
            System.out.println("Nem volt ilyen versenyző.");
        }
        System.out.println();


        System.out.println("7. feladat:");
        String winnerName = "";
        String winnerClub = "";
        int winnerTime = 0;

        try {
            Scanner scanner = new Scanner(new File("bukkm2019.txt"));
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.contains(";")){
                    String[] parts = line.split(";");
                    if (parts[1].equals("ff") && parts[0].startsWith("R") && !parts[4].equals("")){
                        String[] timeParts = parts[4].split(":");
                        int time = Integer.parseInt(timeParts[0]) * 3600 + Integer.parseInt(timeParts[1]) * 60 + Integer.parseInt(timeParts[2]);
                        if (time > winnerTime){
                            winnerTime = time;
                            winnerName = parts[2];
                            winnerClub = parts[3];
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("A bukkm2019.txt fájl nem található!");
        }

        if (!winnerClub.equals("")){
            System.out.printf("A rövidtávú verseny felnőtt férfi kategóriájának győztese: %s (%s), %02d:%02d:%02d idővel.%n%n",
                    winnerName, winnerClub, winnerTime / 3600, (winnerTime % 3600) / 60, winnerTime % 60);
        }
        else {
            System.out.printf("A rövidtávú verseny felnőtt férfi kategóriájának győztese: %s, %02d:%02d:%02d idővel.%n%n",
                    winnerName, winnerTime / 3600, (winnerTime % 3600) / 60, winnerTime % 60);
        }
    }
}