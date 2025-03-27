import java.io.*;

public class FileHandler {
    public static void writeFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
    public static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }
    public static void modifyFile(String fileName, String oldContent, String newContent) throws IOException {
        String fileContent = readFile(fileName);
        fileContent = fileContent.replace(oldContent, newContent);
        writeFile(fileName, fileContent);
    }

    public static void main(String[] args) {
        try {
            String fileName = "example.txt";
            String initialContent = "This is the original content of the file.";
            String oldContent = "original";
            String newContent = "modified";
            writeFile(fileName, initialContent);
            System.out.println("File written successfully.");
            String content = readFile(fileName);
            System.out.println("File content:\n" + content);
            modifyFile(fileName, oldContent, newContent);
            System.out.println("File modified successfully.");
            content = readFile(fileName);
            System.out.println("Updated file content:\n" + content);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
