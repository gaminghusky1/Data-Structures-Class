package BigData;

import java.io.*;
import java.util.ArrayList;

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
}
