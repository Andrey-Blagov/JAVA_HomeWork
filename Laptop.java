import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Laptop {
    private String model;
    private int ramSize;
    private int storageSize;
    private String operatingSystem;
    private String color;

    
    public Laptop(String model, int ramSize, int storageSize, String operatingSystem, String color) {
        this.model = model;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    
    public String getModel() {
        return model;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    
    public void printInformation() {
        System.out.println("Модель: " + model);
        System.out.println("Объем ОЗУ: " + ramSize + " Гб");
        System.out.println("Объем ЖД: " + storageSize + " Гб");
        System.out.println("Операционная система: " + operatingSystem);
        System.out.println("Цвет: " + color);
        System.out.println();
    }

    
    public static List<Laptop> filterLaptops(List<Laptop> laptops, Map<String, Object> filter) {
        List<Laptop> result = new ArrayList<>();

        for (Laptop laptop : laptops) {
            boolean matches = true;

            for (Map.Entry<String, Object> entry : filter.entrySet()) {
                String criterion = entry.getKey();

                switch (criterion) {
                    case "ОбъемОзу":
                        matches &= laptop.getRamSize() >= (int) entry.getValue();
                        break;
                    case "ОбъемЖд":
                        matches &= laptop.getStorageSize() >= (int) entry.getValue();
                        break;
                    case "ОперационнаяСистема":
                        matches &= laptop.getOperatingSystem().equals(entry.getValue());
                        break;
                    case "Цвет":
                        matches &= laptop.getColor().equals(entry.getValue());
                        break;
                    
                }
            }

            if (matches) {
                result.add(laptop);
            }
        }

        return result;
    }
}

