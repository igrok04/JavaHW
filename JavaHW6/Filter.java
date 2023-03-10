package JavaHW6;

import java.util.*;

public class Filter {
    public static void main(String[] args) {

        Laptop l1 = new Laptop("Asus", 2, 128, "Windows 10", "Purple", "price: 25 000 руб.");
        Laptop l2 = new Laptop("HP", 4, 256, "Windows 11", "Red", "price: 30 000 руб.");
        Laptop l3 = new Laptop("MSI", 16, 512, "Windows 10", "Grey", "price: 35 000 руб.");
        Laptop l4 = new Laptop("Sony", 32, 1024, "Windows 11", "Black", "price: 40 000 руб.");

        System.out.println("Выберите функцию:");
        System.out.println("1 - сортировка по ОЗУ");
        System.out.println("2 - сортировка по SSD");
        System.out.println("3 - сортировка по OS");
        System.out.println("4 - сортировка по цвету");
        Scanner sc = new Scanner(System.in, "ibm866");
        Integer choice = sc.nextInt();
        if (choice == 1) {

            System.out.printf("Введите минимальное значение ОЗУ в ГБ: ");
            Integer ram = sc.nextInt();
            if (ram == 2) {
                System.out.printf(
                        l1.toString() + "\n" + l2.toString() + "\n" + l4.toString() + "\n" + l3.toString() + "\n");
            } else if (ram > 2 && ram <= 4) {
                System.out.printf(l2.toString() + "\n" + l3.toString() + "\n" + l4.toString());
            } else if (ram > 4 && ram <= 16) {
                System.out.printf(l3.toString() + "\n" + l4.toString());
            } else if (ram > 16 && ram <= 32) {
                System.out.printf(l4.toString());
            } else
                System.out.println("Таких ноутбуков нет!");

        } else if (choice == 2) {

            System.out.printf("Введите минимальное значение SSD в ГБ: ");
            Integer ssd = sc.nextInt();
            if (ssd == 128) {
                System.out.printf(
                        l1.toString() + "\n" + l2.toString() + "\n" + l3.toString() + "\n" + l4.toString() + "\n");
            } else if (ssd > 128 && ssd <= 256) {
                System.out.printf(l2.toString() + "\n" + l3.toString() + "\n" + l4.toString());
            } else if (ssd > 256 && ssd <= 512) {
                System.out.printf(l3.toString() + "\n" + l4.toString());
            } else if (ssd > 512 && ssd <= 1024) {
                System.out.printf(l4.toString());
            } else
                System.out.println("Таких ноутбуков нет!");

        } else if (choice == 3) {

            System.out.println("Введите название OS: ");
            Scanner sc1 = new Scanner(System.in);
            String os = sc1.nextLine();
            if (os.equals("Windows")) {
                System.out.printf(
                        l1.toString() + "\n" + l2.toString() + "\n" + l3.toString() + "\n" + l4.toString() + "\n");
            } else if (os.equals("Windows 10")) {
                System.out.printf(l1.toString() + "\n" + l3.toString());
            } else if (os.equals("Windows 11")) {
                System.out.printf(l2.toString() + "\n" + l4.toString());
            } else
                System.out.println("Таких ноутбуков нет!");
            sc1.close();

        } else if (choice == 4) {

            System.out.println("Введите цвет: ");
            Scanner sc2 = new Scanner(System.in);
            String color = sc2.nextLine();
            if (color.equals("Purple")) {
                System.out.printf(l1.toString());
            } else if (color.equals("Red")) {
                System.out.printf(l2.toString());
            } else if (color.equals("Grey")) {
                System.out.printf(l3.toString());
            } else if (color.equals("Black")) {
                System.out.printf(l4.toString());
            } else
                System.out.println("Таких ноутбуков нет!");
            sc2.close();

        }
        sc.close();

    }
}

