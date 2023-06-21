package HashMapPhone;

import java.util.*;

public class PhoneBook {

    // Создаем HashMap для хранения контактов
    private static Map<String, List<String>> contacts = new HashMap<>();

    // Метод добавления контакта в телефонную книгу
    public void addContact(String name, String phone) {
        // Если контакт уже есть в книге, добавляем в него новый номер телефона
        if (contacts.containsKey(name)) {
            List<String> phones = contacts.get(name);
            if (!phones.contains(phone)) {
                phones.add(phone);
            }
        } else {
            // Если контакта еще нет в книге, создаем новый список телефонных номеров и добавляем его в HashMap
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            contacts.put(name, phones);
        }
    }

    // Метод вывода контактов в отсортированном порядке по количеству телефонов
    public void printContacts() {
        // Преобразуем HashMap в список Map.Entry и сортируем этот список с помощью компаратора (спасибо семинару)
        List<Map.Entry<String, List<String>>> list = new LinkedList<>(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, List<String>>>() {
            public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });

        // Выводим список контактов на консоль
        System.out.println("Contacts:");
        for (Map.Entry<String, List<String>> entry : list) {
            System.out.print(entry.getKey() + ": ");
            List<String> phones = entry.getValue();
            Collections.sort(phones);
            for (String phone : phones) {
                System.out.print(phone + " ");
            }
            System.out.println();
        }
    }
}
