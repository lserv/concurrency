package io.lenur.concurrency.multithreading.executor.forkjoinpool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private final int[] data;
 
    private static final int THRESHOLD = 20;
 
    public CustomRecursiveTask(int[] data) {
        this.data = data;
    }
 
    @Override
    protected Integer compute() {
        if (data.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
              .stream()
              .mapToInt(ForkJoinTask::join)
              .sum();
        } else {
            return processing(data);
        }
    }
 
    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new CustomRecursiveTask(
                Arrays.copyOfRange(data, 0, data.length / 2)));
        dividedTasks.add(new CustomRecursiveTask(
          Arrays.copyOfRange(data, data.length / 2, data.length)));
        return dividedTasks;
    }
 
    private Integer processing(int[] arr) {
        return Arrays.stream(arr)
          .filter(a -> a > 10 && a < 27)
          .map(a -> a * 10)
          .sum();
    }
}