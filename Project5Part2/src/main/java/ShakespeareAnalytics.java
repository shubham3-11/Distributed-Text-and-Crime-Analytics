/**
 * Author: Shubham Singh
 * Andrew ID: shubham4
 * Purpose: Spark analysis on Shakespeare's "All's Well That Ends Well"
 * Task: Project5 - Part_2 - ShakespeareAnalytics
 */



import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.SparkConf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ShakespeareAnalytics {
    public static void main(String[] args) {
        // Set up Spark configuration and context
        SparkConf conf = new SparkConf().setAppName("Shakespeare Analytics").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Load the file as an RDD of strings
        JavaRDD<String> lines = sc.textFile("src/main/resources/allswell.txt");

        // Task 0: Number of lines
        long numLines = lines.count();
        System.out.println("Number of lines: " + numLines);

        // Task 1: Number of words
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split("[^a-zA-Z]+")).iterator())
                .filter(word -> !word.isEmpty());
        long numWords = words.count();
        System.out.println("Number of words: " + numWords);

        // Task 2: Number of distinct words
        long numDistinctWords = words.distinct().count();
        System.out.println("Number of distinct words: " + numDistinctWords);

        // Task 3: Number of symbols (including spaces, punctuation)
        JavaRDD<String> symbols = lines.flatMap(line -> Arrays.asList(line.split("")).iterator());
        long numSymbols = symbols.count();
        System.out.println("Number of symbols: " + numSymbols);

        // Task 4: Number of distinct symbols
        long numDistinctSymbols = symbols.distinct().count();
        System.out.println("Number of distinct symbols: " + numDistinctSymbols);

        // Task 5: Number of distinct letters (case-sensitive)
        long numDistinctLetters = symbols
                .filter(s -> s.matches("[a-zA-Z]"))
                .distinct()
                .count();
        System.out.println("Number of distinct letters: " + numDistinctLetters);

        // Task 6: Search for a word (case-sensitive)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search (case-sensitive): ");
        String searchWord = scanner.nextLine();

        JavaRDD<String> matchedLines = lines.filter(line -> line.contains(searchWord));
        System.out.println("Lines containing the word \"" + searchWord + "\":");
        for (String matchedLine : matchedLines.collect()) {
            System.out.println(matchedLine);
        }

        // Stop the Spark context
        sc.stop();
    }
}