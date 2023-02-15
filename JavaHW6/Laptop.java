package JavaHW6;
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

public class Laptop {
    String name;
    int ram;
    int ssd;
    String os;
    String color;
    String price;

    public Laptop(String name, int ram, int ssd, String os, String color, String price){
        this.name = name;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String toString() {
        return String.format("name: %s, ram: %d ГБ, ssd: %d ГБ, OS: %s, color: %s, price:: %s ", name, ram, ssd, os, color, price);
    }

    public boolean equals(Object o) {
        Laptop t = (Laptop) o;
        return name == t.name;
    }
}
