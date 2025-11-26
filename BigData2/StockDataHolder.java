package BigData2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StockDataHolder {
    private List<StockData> stockDataList;

    public StockDataHolder(String filename) throws IOException {
        stockDataList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            stockDataList.add(new StockData(line));
        }
    }

    public void sort() {
        Collections.sort(stockDataList);
    }

    public void sortBy(String by) {
        stockDataList.sort((a, b) -> comparatorBy(by, a, b));
    }

    private int comparatorBy(String by, StockData a, StockData b) {
        return comparatorBy(by, a.get(by), b.get(by));
    }

    private int comparatorBy(String by, String a, String b) {
        if (by.equals("Date")) {
            // Lexicographical comparison works here because the dates are always same length
            int yearComparison = a.substring(6).compareTo(b.substring(6));
            int monthComparison = a.substring(0, 2).compareTo(b.substring(0, 2));
            if (yearComparison != 0) {
                return yearComparison;
            } else if (monthComparison != 0) {
                return monthComparison;
            } else {
                return a.substring(3, 5).compareTo(b.substring(3, 5));
            }
        } else if (by.equals("Volume")) {
            return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
        } else {
            double aVal = Double.parseDouble(a.substring(1));
            double bVal = Double.parseDouble(b.substring(1));
            return Double.compare(aVal, bVal);
        }
    }

    public StockData binarySearch(String by, String val) {
        int idx = lowerBound(by, val);
        if (idx >= stockDataList.size() || !stockDataList.get(idx).get(by).equals(val)) {
            return null;
        }
        return stockDataList.get(idx);
    }

    public double getAverageBetween(String fromDate, String toDate, String by) {
        int fromIdx = lowerBound("Date", fromDate);
        int toIdx = upperBound("Date", toDate);
        if (fromIdx > toIdx || fromIdx >= stockDataList.size()) {
            return 0;
        }
        double sum = 0;
        for (int i = fromIdx; i < toIdx; i++) {
            if (by.equals("Volume")) {
                sum += Double.parseDouble(stockDataList.get(i).get(by));
            } else {
                sum += Double.parseDouble(stockDataList.get(i).get(by).substring(1));
            }
        }
        return sum / (toIdx - fromIdx);
    }

    private int lowerBound(String by, String val) {
        sortBy(by);
        return lowerBound(by, val, 0, stockDataList.size());
    }

    private int lowerBound(String by, String val, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        String currVal = stockDataList.get(mid).get(by);
        if (comparatorBy(by, currVal, val) >= 0) {
            return lowerBound(by, val, lo, mid);
        } else {
            return lowerBound(by, val, mid + 1, hi);
        }
    }

    private int upperBound(String by, String val) {
        sortBy(by);
        return upperBound(by, val, 0, stockDataList.size());
    }

    private int upperBound(String by, String val, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        String currVal = stockDataList.get(mid).get(by);
        if (comparatorBy(by, currVal, val) <= 0) {
            return upperBound(by, val, mid + 1, hi);
        } else {
            return upperBound(by, val, lo, mid);
        }
    }

    public StockData get(int idx) {
        return stockDataList.get(idx);
    }

    public List<StockData> getStockDataList() {
        return stockDataList;
    }
}
