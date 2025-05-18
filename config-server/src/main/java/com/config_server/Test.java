package com.config_server;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    private static final Integer[] SAMPLE_ARRAY = {1, 2, 3, 2, 4, 5, 1, 6, 4};

    // 1. Using Set and List
    public static List<Integer> usingSetAndList() {
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int num : SAMPLE_ARRAY) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    // 2. Using Map for Counting Frequencies
    public static List<Integer> usingMapCounting( ) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : SAMPLE_ARRAY) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // 3. Using Java 8+ Streams
    public static List<Integer> usingStreams(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // 4. Using Java 16+ toList()
    public static List<Integer> usingToList(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList(); // Java 16+
    }

    // 5. Using Set Only (Stream Filter Style)
    public static Set<Integer> usingSetFilter(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(arr)
                .filter(n -> !seen.add(n))
                .boxed()
                .collect(Collectors.toSet());
    }


    // 6. Using by stream distinct method
    public static void findDistinct(){
        Arrays.stream(SAMPLE_ARRAY).distinct().forEach(System.out::print);
        System.out.println();
    }

    // 7. Using by stream and return list
    public static List<Integer> findDistinctList(){
        return Arrays.stream(SAMPLE_ARRAY).distinct().collect(Collectors.toList());
    }

    // Test all methods
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 4, 5, 1, 6, 4};

        System.out.println("Using Set and List: " + usingSetAndList());
        System.out.println("Using Map Counting: " + usingMapCounting());
        System.out.println("Using Streams: " + usingStreams(input));
        System.out.println("Using toList (Java 16+): " + usingToList(input));
        System.out.println("Using Set Filter: " + usingSetFilter(input));
        System.out.println("Using by stream and return list: " + findDistinctList());
    }
}
