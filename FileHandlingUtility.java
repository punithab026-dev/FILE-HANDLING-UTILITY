import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Write to file
    public static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Read from file
    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            System.out.println("\nFile Content:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // Append (Modify file)
    public static void modifyFile(String fileName, String newContent) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // true = append
            writer.write("\n" + newContent);
            writer.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter content to write: ");
        String content = sc.nextLine();
        writeFile(fileName, content);

        readFile(fileName);

        System.out.print("\nEnter content to append: ");
        String newContent = sc.nextLine();
        modifyFile(fileName, newContent);

        readFile(fileName);

        sc.close();
    }
}
