package net.cnam.inf330;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main class for running the Rover Mission Command Center application.
 */
public class Main {

    /**
     * Main method for running the Rover Mission Command Center application.
     *
     * @param args --
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = Main.readResourceFile("rover_data.txt");
        MissionCommandCenter mcc = MissionCommandCenter.getInstance(1, 1);
        List<String> outputLines = mcc.processRoverData(lines);

        System.out.println("\n===========");
        for (String line : outputLines)
            System.out.println(line);
        System.out.println("===========");

        // TODO 8) Write output lines to file
        String fileName = "src\\main\\resources\\output.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        else{
            System.out.println("Réécriture sur fichier pré-existant");
        }
        if (file.canWrite()) {
            FileWriter writer = new FileWriter(file, false);
            for (String line : outputLines)
                writer.write(line);
            writer.close();
        }
        else {
            System.out.println("Impossible d'écrire");
        }
    }

    /**
     * Read a file from the application's resource bundle.
     *
     * @param resourceFileName The name of the file to read
     * @return The list of lines read from the file, without the empty lines
     * @throws IOException
     * @throws URISyntaxException
     */
    public static List<String> readResourceFile(String resourceFileName) throws IOException, URISyntaxException {
        List<String> lines = Files.readAllLines(Paths.get(Main.class.getClassLoader()
                .getResource(resourceFileName).toURI()));

        return lines.stream().filter(line -> !line.isEmpty()).collect(Collectors.toList());
    }
}
