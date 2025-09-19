package daliy;

public class Main {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3);
        System.out.println(spreadsheet.getValue("=3+5"));
    }
}
