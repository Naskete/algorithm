package daliy;

import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {
    Map<Character, int[]> sheetMap;

    public Spreadsheet(int rows) {
        sheetMap = new HashMap<>();
        for (char key = 'A'; key <= 'Z'; key++) {
            sheetMap.put(key, new int[rows]);
        }
    }

    public void setCell(String cell, int value) {
        char key = cell.charAt(0);
        int idx = getCellIdx(cell);
        sheetMap.get(key)[idx - 1] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        String val = formula.substring(1);
        String[] split = val.split("\\+");
        return getCellVal(split[0]) + getCellVal(split[1]);
    }

    private int getCellVal(String key) {
        char c = key.charAt(0);
        if (c >= 'A' && c <= 'Z') {
            int cellIdx = getCellIdx(key);
            return sheetMap.get(c)[cellIdx - 1];
        }
        return Integer.parseInt(key);
    }

    public int getCellIdx(String cell) {
        String substring = cell.substring(1);
        return Integer.parseInt(substring);
    }
}
