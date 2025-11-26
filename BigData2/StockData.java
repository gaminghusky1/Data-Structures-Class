package BigData2;

import java.util.Map;

public class StockData implements Comparable<StockData> {
    public static final Map<String, Integer> column_to_idx = Map.of(
            "Date", 0,
            "Close/Last", 1,
            "Volume", 2,
            "Open", 3,
            "High", 4,
            "Low", 5
    );
    public static final String[] columns = {"Date", "Close/Last", "Volume", "Open", "High", "Low"};
    private String[] data;

    public StockData(String row) {
        data = row.split(",");
    }

    public int compareTo(StockData o) {
        // Lexicographical comparison works here because the dates are always same length
        String a = this.get("Date");
        String b = o.get("Date");
        int yearComparison = a.substring(6).compareTo(b.substring(6));
        int monthComparison = a.substring(0, 2).compareTo(b.substring(0, 2));
        if (yearComparison != 0) {
            return yearComparison;
        } else if (monthComparison != 0) {
            return monthComparison;
        } else {
            return a.substring(3, 5).compareTo(b.substring(3, 5));
        }
    }

    public String get(String column) {
        return data[column_to_idx.get(column)];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            sb.append(columns[i]).append(": ").append(data[i]).append("\n");
        }
        return sb.toString();
    }
}
