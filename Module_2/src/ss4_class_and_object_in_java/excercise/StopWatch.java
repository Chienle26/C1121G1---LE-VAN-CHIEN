package ss4_class_and_object_in_java.excercise;

import java.util.Random;
import java.util.Scanner;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.getEndTime() - this.getStartTime();
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Random random = new Random();
        int size = 100000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }

        System.out.println("Start time (milliseconds): " + stopWatch.getStartTime());

        selectionSort(arr);

        System.out.println("End time (milliseconds): " + stopWatch.getEndTime());

        System.out.println("Total (milliseconds): " + stopWatch.getElapsedTime() + " miliseconds" + " ~ " + stopWatch.getElapsedTime() / 1000 + " seconds");
    }
}

