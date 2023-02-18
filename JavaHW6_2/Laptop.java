package JavaHW6_2;
/*
 Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
1. Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет выборку: имя ноутбука 
и выбранный критерий . Критерии фильтрации можно хранить в Map.Сделать выборку.
Например:
Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Пользователь ввел 1. Вывести в виде.
|Имя| ОЗУ|
|--------|-----------|
| Asus | 2ГБ |
| HP | 4ГБ |
| MSI | 6ГБ |
2. Отфильтровать ноутбуки первоначального множества. По имени ноутбука в алфавитном порядке, по цене по убыванию
Например, по алфавиту
|Имя| ОЗУ| Цена
|--------|-----------|-----------|
| Asus | 2ГБ | 4666|
| MSI | 4ГБ |6600|
| HP | 6ГБ| 5555|
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Laptop {
    public static void main(String[] args) {
        Laptops L1 = new Laptops("Acer", 8, 512, "NA           ", "red  ", 40000);
        Laptops L2 = new Laptops("HP  ", 4, 512, "Windows 10   ", "black", 35000);
        Laptops L3 = new Laptops("Asus", 4, 256, "Windows 11   ", "black", 30000);
        Laptops L4 = new Laptops("Dell", 16, 1024, "Linux      ", "grey ", 45000);
        Laptops L5 = new Laptops("Sony", 32, 1024, "Windows 11 ", "black", 60000);

        List<Laptops> laptopsList = Arrays.asList(L1, L2, L3, L4, L5);

        Menu(laptopsList);

    }

    public static void Menu(List<Laptops> list) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Runnable> menu = new HashMap<>();
        menu.put(1, () -> getAllRAM(list));
        menu.put(2, () -> getAllHD(list));
        menu.put(3, () -> getAllOS(list));
        menu.put(4, () -> getAllColor(list));
        menu.put(5, () -> getAllPrice(list));
        menu.put(6, () -> System.out.println("Выход"));
        int userCommand = 0;
        do {
            try {
                System.out.println("\nВведите цифру, соответствующую необходимому критерию:");
                System.out.println(
                        "1 - ОЗУ\n2 - Объем жесткого диска\n3 - Операционная система\n4 - Цвет\n5 - Цена\n6 - Выход");

                userCommand = sc.nextInt();

                menu.get(userCommand).run();
                sortMapLap(list, userCommand);
            } catch (Exception e) {
                System.out.println("Неправильный ввод!");
            }
        } while (userCommand != 6);
        sc.close();
    }

    public static void sortMapLap(List<Laptops> list, int userCommand) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Отсортировать по выбранной категории:  нажмите любую клавишу");
        String sortCheck = sc.next();
        if (sortCheck.equals(""))
            System.out.println("\nФирма|ОЗУ(ГБ)|Объем ЖД(ГБ)|Опер. Cистема|Цвет|Цена(руб)|");
        try {
            printSortedListInteger(sortingByValueHashInteger(filLaptopMapsInteger(list, userCommand)));
        } catch (Exception e) {
            printSortedListString(sortingByValueHash(filLaptopMaps(list, userCommand)));
        }
        // sc.close();

    }

    public static Map<String, Object> getAllRAM(List<Laptops> list) {
        Map<String, Object> lapRam = new HashMap<>();
        for (Laptops el : list) {
            lapRam.put(el.getName(), el.getRam());
        }
        ShowMapLaptops(lapRam, " ГБ");
        return lapRam;
    }

    public static Map<String, Object> getAllHD(List<Laptops> list) {
        Map<String, Object> lapHD = new HashMap<>();
        for (Laptops el : list) {
            lapHD.put(el.getName(), el.getHardDrive());
        }
        ShowMapLaptops(lapHD, " ГБ");
        return lapHD;
    }

    public static Map<String, Object> getAllOS(List<Laptops> list) {
        Map<String, Object> lapOS = new HashMap<>();
        for (Laptops el : list) {
            lapOS.put(el.getName(), el.getOperatingSystem());
        }
        ShowMapLaptops(lapOS, "");
        return lapOS;
    }

    public static Map<String, Object> getAllColor(List<Laptops> list) {
        Map<String, Object> lapColor = new HashMap<>();
        for (Laptops el : list) {
            lapColor.put(el.getName(), el.getColor());
        }
        ShowMapLaptops(lapColor, "");
        return lapColor;
    }

    public static Map<String, Object> getAllPrice(List<Laptops> list) {
        Map<String, Object> lapPrice = new HashMap<>();
        for (Laptops el : list) {
            lapPrice.put(el.getName(), el.getPrice());
        }
        ShowMapLaptops(lapPrice, " руб");
        return lapPrice;
    }

    public static void ShowMapLaptops(Map<String, Object> map, String param) {
        Map<String, Object> sortedMap = new TreeMap<>(map);
        for (Map.Entry<String, Object> el : sortedMap.entrySet()) {
            System.out.println("| " + el.getKey() + " | " + el.getValue() + param + " | ");
        }
    }

    public static List<String> getLapClassFields(Laptops laptop) {
        List<String> laptopField = Arrays.asList(laptop.getName(), Integer.toString(laptop.getRam()),
                Integer.toString(laptop.getHardDrive()), laptop.getOperatingSystem(),
                laptop.getColor(), Integer.toString(laptop.getPrice()));
        return laptopField;
    }

    public static Map<List<String>, String> filLaptopMaps(List<Laptops> listLap, int indexSort) {
        Map<List<String>, String> mapForSorting = new HashMap<>();
        String temp1 = new String();
        for (Laptops el : listLap) {
            List<String> temp = new ArrayList<>();
            temp = getLapClassFields(el);
            temp1 = temp.get(indexSort);
            mapForSorting.put(temp, temp1);
        }
        return mapForSorting;

    }

    public static Map<List<String>, Integer> filLaptopMapsInteger(List<Laptops> listLap, int indexSort) {
        Map<List<String>, Integer> mapForSorting = new HashMap<>();
        Integer temp1 = 0;
        for (Laptops el : listLap) {
            List<String> temp = new ArrayList<>();
            temp = getLapClassFields(el);
            temp1 = Integer.parseInt(temp.get(indexSort));
            mapForSorting.put(temp, temp1);
        }
        return mapForSorting;

    }

    public static Map<List<String>, String> sortingByValueHash(Map<List<String>, String> userhashmap) {
        userhashmap = userhashmap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        return userhashmap;
    }

    public static Map<List<String>, Integer> sortingByValueHashInteger(Map<List<String>, Integer> userhashmap) {
        userhashmap = userhashmap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        return userhashmap;
    }

    public static void printSortedListInteger(Map<List<String>, Integer> map) {
        for (var el : map.entrySet()) {
            System.out.println(String.join("| ", el.getKey()));
        }

    }

    public static void printSortedListString(Map<List<String>, String> map) {
        for (var el : map.entrySet()) {
            System.out.println(String.join("| ", el.getKey()));
        }
    }

}

class Laptops {
    String name;
    Integer ram;
    Integer hardDrive;
    String operatingSystem;
    String color;
    Integer price;

    Laptops(String name, Integer ram, Integer hardDrive, String operatingSystem, String color, Integer price) {
        this.name = name;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getHardDrive() {
        return hardDrive;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public Integer getPrice() {
        return price;
    }

}
