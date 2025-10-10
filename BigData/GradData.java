package BigData;

import java.util.*;

public class GradData {
    private static final String[] columns = {"College_ID", "IQ", "Prev_Sem_Result", "CGPA", "Academic_Performance",
            "Internship_Experience", "Extra_Curricular_Score", "Communication_Skills", "Projects_Completed", "Placement"};
    private static final Class<?>[] types = {String.class, Integer.class, Double.class, Double.class, Integer.class,
            Boolean.class, Integer.class, Integer.class, Integer.class, Boolean.class};
    private final Map<String, Object> data;

    public GradData(String dataString) {
        data = new LinkedHashMap<>();
        String[] temp = dataString.split(",");
        for (int i = 0; i < columns.length; i++) {
            Object value;
            if (types[i] == Boolean.class) {
                value = temp[i].equals("Yes");
            } else if (types[i] == Integer.class) {
                value = Integer.parseInt(temp[i]);
            } else if (types[i] == Double.class) {
                value = Double.parseDouble(temp[i]);
            } else {
                value = temp[i];
            }
            data.put(columns[i], value);
        }
    }

    public <T> T get(String columnName, Class<T> type) {
        if (!data.containsKey(columnName)) {
            return null;
        }
        return type.cast(data.get(columnName));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> pair : data.entrySet()) {
            Object v = pair.getValue();
            sb.append(pair.getKey()).append(": ");
            if (v == null || (v.toString()).isEmpty()) {
                sb.append("no data");
            } else {
                sb.append(v);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
