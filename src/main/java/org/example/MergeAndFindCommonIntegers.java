package org.example;

import java.io.*;
import java.util.*;

public class MergeAndFindCommonIntegers {
    public static void main(String[] args) {
        String inputFile1 = "input1.txt";
        String inputFile2 = "input2.txt";
        String mergedFile = "merged.txt";
        String commonFile = "common.txt";

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();
        Set<Integer> commonSet = new HashSet<>();

        try {
            // Read integers from the first input file
            list1 = readIntegersFromFile(inputFile1);

            // Read integers from the second input file
            list2 = readIntegersFromFile(inputFile2);

            // Merge the lists
            mergedList.addAll(list1);
            mergedList.addAll(list2);

            // Find common integers
            Set<Integer> set1 = new HashSet<>(list1);
            Set<Integer> set2 = new HashSet<>(list2);
            for (Integer num : set1) {
                if (set2.contains(num)) {
                    commonSet.add(num);
                }
            }

            // Write the merged list to the merged file
            writeIntegersToFile(mergedFile, mergedList);

            // Write the common integers to the common file
            writeIntegersToFile(commonFile, new ArrayList<>(commonSet));

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }

    private static List<Integer> readIntegersFromFile(String filename) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }
        }
        return list;
    }

    private static void writeIntegersToFile(String filename, List<Integer> list) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer num : list) {
                writer.write(num.toString());
                writer.newLine();
            }
        }
    }
}
