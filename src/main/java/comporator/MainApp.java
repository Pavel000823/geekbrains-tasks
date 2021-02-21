package comporator;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        String[] list = {"123", "1235", "1234324234", "12312312"};
        Arrays.sort(list, new ComparatorLength());
    }
}
