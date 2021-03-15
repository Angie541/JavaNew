package javaIO;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeNewVersion {
    public static void main(String[] arg) throws Exception {
        String startPoint = arg[0];
        if (new File(startPoint).isDirectory()) {

            List<String> result = new ArrayList();

            try (Stream<Path> path = Files.walk(Paths.get(startPoint))) {
                result = path.filter(Files::isExecutable).map(x -> {

                    int numberOfDirs = 0;
                    List<Path> listOfDirs = null;

                    try {
                        listOfDirs = Files.walk(Path.of(startPoint))
                                .filter(p -> p != Path.of(startPoint) && p.toFile().isDirectory()).collect(Collectors.toList());

                        numberOfDirs = listOfDirs.size();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Path lastDirectoryPath = listOfDirs.get(numberOfDirs - 1).toAbsolutePath();

                    String str = "-";
                    String str1 = "  |";
                    String str2 = "   ";

                    if (Files.isDirectory(x)) {

                        if (startPoint.endsWith(x.toString())) {

                            return ("dir:         " + x.getFileName());
                        }

                        return ("             |" + str1.repeat(x.getNameCount() - x.resolve(startPoint).getNameCount() - 1) + "\ndir:         |" +
                                str1.repeat(x.getNameCount() - x.resolve(startPoint).getNameCount() - 1) + str.repeat(x.getNameCount()) + x.getFileName().toString());
                    }

                    if ((x.getParent().toString()).equalsIgnoreCase(lastDirectoryPath.toString())) {

                        return ("file:              " + str2.repeat(x.getNameCount() - x.resolve(startPoint).getNameCount() - 2) + x.getFileName().toString());
                    }

                    return ("file:   " + "     |" + str1.repeat(x.getNameCount() - x.resolve(startPoint).getNameCount() - 2) + "     " + x.getFileName().toString());

                }).collect(Collectors.toList());

                result.forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }

            String textFile = "C:/Users/angelina/Projects/JavaIJ/src/test/resources/File.txt";
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

        } else if (new File(startPoint).isFile()) {
            Stream<String> readableLines =
                    Files.lines(Paths.get(startPoint));

            long numberOfDirectories = readableLines
                    .flatMap(s -> Stream.of(s.contains("dir: "))).filter(t -> t.booleanValue())
                    .count();

            System.out.println("Number of directories: " + numberOfDirectories);

            Stream<String> readableLines1 =
                    Files.lines(Paths.get(startPoint));

            long numberOfFiles = readableLines1
                    .flatMap(s -> Stream.of(s.contains("file: "))).filter(t -> t.booleanValue())
                    .count();

            System.out.println("Number of files: " + numberOfFiles);

            Stream<String> readableLines2 =
                    Files.lines(Paths.get(startPoint));
            int numberOfDirectoriesWithFiles = 0;

            List n = Arrays.stream(readableLines2.toArray()).collect(Collectors.toList());
            for (int i = 0; i < n.size(); i++) {
                String a = n.get(i).toString();
                if (a.contains("dir:")) {
                    if (n.get(n.indexOf(a) + 1).toString().contains("file:")) {
                        numberOfDirectoriesWithFiles++;
                    }
                }
            }
            System.out.println("Average number of files in a directory: " + numberOfFiles / numberOfDirectoriesWithFiles);

            Stream<String> readableLines3 =
                    Files.lines(Paths.get(startPoint));

            List linesWithFileNames = Arrays.stream(readableLines3
                    .flatMap(s -> Stream.of(s.split("dir"))).filter(name -> name.contains("file:")).toArray()).collect(Collectors.toList());

            int sumOfFileNameLengths = 0;
            for (int i = 0; i < linesWithFileNames.size(); i++) {
                String str = linesWithFileNames.get(i).toString();
                String strWithoutAppendix1 = str.replace("  |", "");
                String strWithoutAppendix2 = strWithoutAppendix1.replace("file:           ", "");
                String fileName = strWithoutAppendix2.replace("   ", "");
                sumOfFileNameLengths = fileName.length() + sumOfFileNameLengths;
            }
            System.out.println("Average length of file name: " + sumOfFileNameLengths / numberOfFiles);
        }
    }
}