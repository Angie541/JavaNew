package javaIO;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tree {
    public static void main(String[] arg) throws Exception {
        String startPoint = "C:/Temp/movies";

        List<String> result = new ArrayList();
        try (Stream<Path> path = Files.walk(Paths.get(startPoint))) {
            result = path.filter(Files::isExecutable).map(x -> {

                if (Files.isDirectory(x)) {
                    return "             |" + "\n" + "dir:    " + "     |----" + x.getFileName().toString();
                }

                return "file:   " + "     |    " + x.getFileName().toString();

            }).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String textFile = "C:/Users/angelina/Projects/JavaIJ/src/test/java/javaIO/File.txt";
        FileWriter movieFile = new FileWriter(textFile);
        try {
            movieFile.write("Movie's List : \n");
            for (String file : result) {
                movieFile.write("\n" + file);
            }
        } catch (Exception e) {
            System.out.println("THERE IS NO SUCH FILE !!!");
        }

        movieFile.close();
    }
}