// ========================================================================================
// 2. Пусть дан список сотрудников:Иван Иванов и т.д.
//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
// =========================================================================================

package JavaHW5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class hw5_task2 {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        String persons = "Иван Иванов " +
                "Мура Шурина " +
                "Шура Мурина " +
                "Анна Каренина " +
                "Анна Австрийская " +
                "Иван Сидоров " +
                "Петр Первый " +
                "Павел Третий " +
                "Петр Второй " +
                "Мария Федорова " +
                "Марина Морская " +
                "Мария Чащина " +
                "Мария Гудкова " +
                "Марина Лугова " +
                "Анна Снаткина " +
                "Иван Грозный " +
                "Петр Петров " +
                "Иван Петров ";
        String[] listOfPersons = persons.split(" ");
        for (int i = 0; i < listOfPersons.length; i += 2) {
            if (nameMap.containsKey(listOfPersons[i])) {
                nameMap.replace(listOfPersons[i], nameMap.get(listOfPersons[i]) + 1);
            } else {
                nameMap.put(listOfPersons[i], 1);
            }
        }
        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }
        System.out.println(sortedNameMap);
    }
}