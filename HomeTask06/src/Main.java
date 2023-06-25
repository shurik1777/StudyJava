import HardwareStore.MobilePhoneStructureAdnCriteria;

import java.util.*;

import static HardwareStore.MobilePhoneStructureAdnCriteria.getCriteriaFromUser;

public class Main {
    public static void main(String[] args) throws Exception {
//        // Первая часть заданий
        //// Заполнение экземплярами набора
//        Set<MobilePhoneStructureAdnCriteria> phones = new HashSet<>();
//        phones.add(new MobilePhoneStructureAdnCriteria("OnePlus 9 Pro", 12, 256, "Android", "Morning Mist", 6.5, 1));
//        phones.add(new MobilePhoneStructureAdnCriteria("iPhone 12", 4, 256, "iOS", "Graphite", 6.06, 2));
//        phones.add(new MobilePhoneStructureAdnCriteria("Xiaomi Redmi Note 8 Pro", 8, 256, "Android", "Blue", 6.53, 3));
//
//
//        // Вывод всех экземпляров на печать
//        for (MobilePhoneStructureAdnCriteria phone : phones) {
//            System.out.println(phone);
//        }
//
//        // Добавление и сравнение нескольких экземпляров и вывод на печать результатов
//
//        MobilePhoneStructureAdnCriteria phone1 = new MobilePhoneStructureAdnCriteria("OnePlus 9 Pro", 12, 256, "Android", "Morning Mist", 6.5, 1);
//        MobilePhoneStructureAdnCriteria phone2 = new MobilePhoneStructureAdnCriteria("iPhone 12", 4, 256, "iOS", "Graphite", 6.06, 2);
//
//        System.out.println(phone1.equals(phone2) + "\tсравниваем несколько отдельно добавленных экземпляров, идентичных 1 и 2 в наборе");
//        System.out.println(phones.contains(phone2) + "\tпоиск одного экземпляра наборе");


        // Вторая часть заданий
        List<MobilePhoneStructureAdnCriteria> phones = new ArrayList<>();
        // Заполнение экземплярами набора:
        phones.add(new MobilePhoneStructureAdnCriteria("Samsung Galaxy S21", 8, 128, "Android", "Phantom Gray", 6.2, 1));
        phones.add(new MobilePhoneStructureAdnCriteria("iPhone 12", 4, 256, "iOS", "Graphite", 6.06, 2));
        phones.add(new MobilePhoneStructureAdnCriteria("OnePlus 9 Pro", 12, 256, "Android", "Morning Mist", 6.5, 3));
        phones.add(new MobilePhoneStructureAdnCriteria("Xiaomi Redmi Note 8 Pro", 8, 256, "Android", "Blue", 6.53, 4));
        phones.add(new MobilePhoneStructureAdnCriteria("HTC U11", 4, 64, "Android", "Black", 4.2, 5));
        phones.add(new MobilePhoneStructureAdnCriteria("Lenovo Lumia", 4, 64, "Android", "Green", 4.5, 6));

        Map<String, Object> criteria = getCriteriaFromUser();
        // getCriteriaFromUser Метод, который запрашивает у пользователя критерии фильтрации
        List<MobilePhoneStructureAdnCriteria> filteredPhones = MobilePhoneStructureAdnCriteria.filterMobilePhones(phones, criteria);
        // filterMobilePhones Статический метод, который принимает на вход список телефонов и критерии фильтрации, и возвращает отфильтрованный список телефонов, удовлетворяющих заданным критериям.
        System.out.println("Результаты фильтрации: ");
        for (MobilePhoneStructureAdnCriteria phone : filteredPhones) {
            System.out.println(phone);
        }
    }
}
