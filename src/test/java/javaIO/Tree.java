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
        String startPoint = "C:/Temp/movies/Amon Amarth";

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
                
                
                if (Files.isDirectory(x)) {
                    
                     if (startPoint.endsWith(x.getFileName().toString())){

                        return("dir:         " + x.getFileName());
                     }
                        String  str = "-";
                    
                    return ("             |"  + "\ndir:         |" + str.repeat(x.getNameCount()) + x.getFileName().toString());
                }
                            
                        if ((x.getParent().toString()).equalsIgnoreCase(lastDirectoryPath.toString())) {     
                            

                       return("file:              " + x.getFileName().toString());
                    }

                return("file:   " + "     |     " + x.getFileName().toString());

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
            
            
       } else if(new File(startPoint).isFile()){
            int sumOfFileNameLengths = 0;
            String additionalPart = "file:        |     ";

            Stream<String> readableLines =
                Files.lines(Paths.get(startPoint));

            long  numberOfDirectories = readableLines
                .flatMap(s -> Stream.of(s.contains("dir: "))).filter(t -> t.booleanValue())
                .count();

            System.out.println("Number of directories: " + numberOfDirectories);


            Stream<String> readableLines1 =
                Files.lines(Paths.get(startPoint));

            long  numberOfFiles = readableLines1
                .flatMap(s -> Stream.of(s.contains("file: "))).filter(t -> t.booleanValue())
                .count();

            System.out.println("Number of files: " + numberOfFiles);


            Stream<String> readableLines2 =
                Files.lines(Paths.get(startPoint));

            long  numberOfDirectoriesWithFiles = readableLines2
                .flatMap(s -> Stream.of(s.contains("dir:         |----"))).filter(t -> t.booleanValue())
                .count();

            System.out.println("Average number of files in a directory: " + numberOfFiles/numberOfDirectoriesWithFiles );


            Stream<String> readableLines3 =
                Files.lines(Paths.get(startPoint));

            List linesWithFileNames = Arrays.stream(readableLines3
                .flatMap(s -> Stream.of(s.split("dir"))).filter(name -> name.contains("mp3")).toArray()).collect(Collectors.toList());

                for (int i = 0; i < linesWithFileNames.size(); i++) {

                  String str = linesWithFileNames.get(i).toString();
                  String fileName = str.substring(additionalPart.length());
                  sumOfFileNameLengths = fileName.length() + sumOfFileNameLengths;
                }
             System.out.println("Average length of file name: " + sumOfFileNameLengths/numberOfFiles );
        }
    }
}
