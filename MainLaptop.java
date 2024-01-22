import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainLaptop {
    public static void main(String[] args) {
        
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Asus", 8, 512, "Windows", "Grey"));
        laptops.add(new Laptop("HP", 16, 256, "Linux", "Black"));
        laptops.add(new Laptop("Apple", 32, 1024, "MacOS", "Silver"));
        laptops.add(new Laptop("Acer", 8, 750, "Windows", "Blue"));
        laptops.add(new Laptop("Sony", 4, 2048, "Windows", "White"));
        
        Map<String, Object> filter = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int selectedCriterion = scanner.nextInt();

        switch (selectedCriterion) {
            case 1:
                filter.put("ОбъемОзу", enterMinValue("ОЗУ"));
                break;
            case 2:
                filter.put("ОбъемЖд", enterMinValue("Объем ЖД"));
                break;
            case 3:
                filter.put("ОперационнаяСистема", enterStringValue("Операционная система"));
                break;
            case 4:
                filter.put("Цвет", enterStringValue("Цвет"));
                break;
            
        }

        
        List<Laptop> filteredLaptops = Laptop.filterLaptops(laptops, filter);

        System.out.println("Результаты фильтрации:");
        for (Laptop laptop : filteredLaptops) {
            laptop.printInformation();
        }
    }

    
    private static int enterMinValue(String parameter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимальное значение для " + parameter + ":");
        return scanner.nextInt();
    }

    private static String enterStringValue(String parameter) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение для " + parameter + ":");
        return scanner.next();
    }
}
