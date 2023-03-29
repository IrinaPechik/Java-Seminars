package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Counter {
    private static final List<String> data = Arrays.asList(
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d",
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d",
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d",
            "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d", "aa", "bbb", "c", "d");

    public static void main(String[] args) {
        int charCount = doParallelWork(data);
        System.out.println("Total character count: " + charCount);
    }

    public static int doParallelWork(List<String> data) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        int numTasks = 3;
        int dataSize = data.size();
        int batchSize = dataSize / numTasks;
        int remaining = dataSize % numTasks;

        // Create tasks and submit them to the executor
        List<Callable<Integer>> tasks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < numTasks; i++) {
            int start = i * batchSize;
            int end = start + batchSize;
            if (i == numTasks - 1) {
                end += remaining;
            }

            final List<String> subList = data.subList(start, end);
            Callable<Integer> task = () -> {
                int count = 0;
                for (String str : subList) {
                    count += str.length();
                }
                return count;
            };
            tasks.add(task);
        }

        int totalCharCount = 0;
        try {
            List<Future<Integer>> futures = executor.invokeAll(tasks);
            for (Future<Integer> future : futures) {
                totalCharCount += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        return totalCharCount;
    }
}
