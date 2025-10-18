package BigData;

import java.util.*;

public class GradData {
    public static final String[] columns = {"IQ", "Prev_Sem_Result", "CGPA", "Academic_Performance",
            "Extra_Curricular_Score", "Communication_Skills", "Projects_Completed"};
    private final Map<String, Double> data;

    public GradData(String dataString) {
        data = new LinkedHashMap<>();
        String[] temp = dataString.split(",");
        for (int i = 0; i < columns.length; i++) {
            data.put(columns[i], Double.parseDouble(temp[i]));
        }
    }

    public double get(String columnName) {
        if (!data.containsKey(columnName)) {
            throw new IllegalArgumentException(String.format("Column '%s' not found", columnName));
        }
        return data.get(columnName);
    }

    public void set(String columnName, double value) {
        if (!data.containsKey(columnName)) {
            throw new IllegalArgumentException(String.format("Column %s not found", columnName));
        }
        data.put(columnName, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> pair : data.entrySet()) {
            sb.append(pair.getKey()).append(": ").append(pair.getValue()).append("\n");
        }
        return sb.toString();
    }
}
