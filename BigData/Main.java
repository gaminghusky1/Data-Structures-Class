package BigData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<GradData> gradData = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("BigData/CollegePlacement.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            gradData.add(new GradData(line));
        }
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Which entry would you like to see? (Enter an integer 1-%d)%n", gradData.size());
        try {
            int i = Integer.parseInt(br.readLine()) - 1;
            if (i >= 0 && i < gradData.size()) {
                System.out.println(gradData.get(i));
            } else {
                System.out.println("Invalid integer received.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Didn't receive an integer.");
        }
    }

    public static double findMin(List<GradData> gradData, String column) {
        double minVal = Double.MAX_VALUE;
        for (GradData gd : gradData) {
            minVal = Math.min(minVal, gd.get(column));
        }
        return minVal;
    }

    public static double findMax(List<GradData> gradData, String column) {
        double maxVal = Double.MIN_VALUE;
        for (GradData gd : gradData) {
            maxVal = Math.max(maxVal, gd.get(column));
        }
        return maxVal;
    }

    public static int counter(ArrayList<GradData> input, String col, double search){
        int count = 0;
        for (GradData dataPoint: input) {
            if (search == dataPoint.get(col)) count++;
        }
        return count;
    }

    public static void sort(List<GradData> gradData, String column) {
        if (gradData.size() <= 1) return;
        int mid = gradData.size() / 2;
        List<GradData> left = new ArrayList<>(gradData.subList(0, mid));
        List<GradData> right = new ArrayList<>(gradData.subList(mid, gradData.size()));
        sort(left, column);
        sort(right, column);
        merge(left, right, gradData, column);
    }

    public static void changeValues(List<GradData> gradData, String column, double newVal) {
        for (GradData gd : gradData) {
            gd.set(column, newVal);
        }
    }

    private static void merge(List<GradData> left, List<GradData> right, List<GradData> dest, String column) {
        int leftIdx = 0;
        int rightIdx = 0;
        while (leftIdx < left.size() && rightIdx < right.size()) {
            if (left.get(leftIdx).get(column) <= right.get(rightIdx).get(column)) {
                dest.set(leftIdx + rightIdx, left.get(leftIdx));
                leftIdx++;
            } else {
                dest.set(leftIdx + rightIdx, right.get(rightIdx));
                rightIdx++;
            }
        }
        while (leftIdx < left.size()) {
            dest.set(leftIdx + rightIdx, left.get(leftIdx));
            leftIdx++;
        }
        while (rightIdx < right.size()) {
            dest.set(rightIdx + leftIdx, right.get(rightIdx));
            rightIdx++;
        }
    }

    public static void printDataSet(String fileName, ArrayList<GradData> gradData) {
        String[] columns = GradData.columns;
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < columns.length - 1; i++) {
                pw.print(columns[i] + ",");
            }
            pw.println(columns[columns.length - 1]);
            for (GradData gd : gradData) {
                for (int i = 0; i < columns.length - 1; i++) {
                    pw.print(gd.get(columns[i]) + ",");
                }
                pw.println(gd.get(columns[columns.length - 1]));
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
