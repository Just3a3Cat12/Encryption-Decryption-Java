import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

interface Mode {
    String shiftAlgo(int key, char[] data);

    String unicodeAlgo(int key, char[] data);
}

class EncDec implements Mode {
    List<Character> cyphered = new ArrayList<>(); // We can use StringBuilder instead of List.
    @Override
    public String shiftAlgo(int key, char[] data) {
        if (Math.abs(key)> 26) {
            key = key % 26;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 64 && data[i] < 91) {
                if (data[i] + key > 90) {
                    cyphered.add((char) (data[i] + key - 26));
                } else if (data[i] + key < 65) {
                    cyphered.add((char) (data[i] + key + 26));
                } else {
                    cyphered.add((char) (data[i] + key));
                }
            } else if (data[i] > 96 && data[i] < 123) {
                if (data[i] + key > 122) {
                    cyphered.add((char) (data[i] + key - 26));
                } else if (data[i] + key < 97) {
                    cyphered.add((char) (data[i] + key + 26));
                } else {
                    cyphered.add((char) (data[i] + key));
                }
            } else {
                cyphered.add(data[i]);
            }
        }
//        String abc = cyphered.toString().replace(", ", "");
//        System.out.println(abc.substring(1, abc.length() - 1));
        return cyphered.toString().replace(", ", "").replaceAll("\\[|\\]", "");
    }                           // replacing unwanted characters in List. removing sq. bracket and comma space.

    @Override
    public String unicodeAlgo(int key, char[] data) {
        for (int i = 0; i < data.length; i++) {
            cyphered.add((char) (data[i] + key));
        }
        return cyphered.toString().replace(", ", "").replaceAll("\\[|\\]", "");
    }                           // replacing unwanted characters in List. removing sq. bracket and comma space.
}

public class EncryptionDecryption {
    public static void main(String[] args) {
        String command = "enc"; // Default encryption
        int key = 0;    // Default key
        String data = "";
        String filePath = "";
        String outputFilePath = null;
        String algo = "shift";
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-mode")) {
                    command = args[i + 1];
                }
                if (args[i].equals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                }
                if (args[i].equals("-in")) {
                    filePath = args[i + 1];
                    try {
                        data = new String(Files.readAllBytes(Paths.get(filePath)));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (args[i].equals("-out")) {
                    outputFilePath = args[i + 1];
                }
                if (args[i].equals("-data")) {
                    data = args[i + 1];
                }
                if (args[i].equals("-alg")) {
                    algo = args[i + 1];
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        char[] original = data.toCharArray(); // Converting data to array.
        if (command.equals("dec")) {    // setting key to negative to go in decryption.
            key = key * -1;
        }

        EncDec processing = new EncDec();

        if (outputFilePath != null) {
            File file = new File(outputFilePath);
            try (FileWriter writer = new FileWriter(file)) {
                if (algo.equals("shift")) {
                    writer.write(processing.shiftAlgo(key, original));
                } else {
                    writer.write(processing.unicodeAlgo(key, original));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            if (algo.equals("shift")) {
                System.out.println(processing.shiftAlgo(key, original));
            } else {
                System.out.println(processing.unicodeAlgo(key, original));
            }
        }
    }
}
