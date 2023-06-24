import HardwareStore.MobilePhoneStructureAdnCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static HardwareStore.MobilePhoneStructureAdnCriteria.getCriteriaFromUser;

public class Main {
    public static void main(String[] args) throws Exception{
        List<MobilePhoneStructureAdnCriteria> phones = new ArrayList<>();
        // Добавляю в список телефонов заполнение:
        phones.add(new MobilePhoneStructureAdnCriteria("Samsung Galaxy S21", 8, 128, "Android", "Phantom Gray", 6.2));
        phones.add(new MobilePhoneStructureAdnCriteria("iPhone 12", 4, 256, "iOS", "Graphite",6.06));
        phones.add(new MobilePhoneStructureAdnCriteria("OnePlus 9 Pro", 12, 256, "Android", "Morning Mist",6.5));
        phones.add(new MobilePhoneStructureAdnCriteria("Xiaomi Redmi Note 8 Pro", 8, 256, "Android", "Blue",6.53));
        phones.add(new MobilePhoneStructureAdnCriteria("HTC U11", 4, 64, "Android", "Blue",4.2));

        Map<String, Object> criteria = getCriteriaFromUser();
        List<MobilePhoneStructureAdnCriteria> filteredPhones = MobilePhoneStructureAdnCriteria.filterMobilePhones(phones, criteria);
    }
}