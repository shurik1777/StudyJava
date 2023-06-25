package HardwareStore;

import java.util.*;


public class MobilePhoneStructureAdnCriteria {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double screenSize;
    private long id;

    public MobilePhoneStructureAdnCriteria(String model, int ram, int storage, String os, String color, double screenSize, long id) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.screenSize = screenSize;
        this.id = id;
    }

    // геттеры и сеттеры:
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        // метод проверяет равенство объектов по всем полям класса
        if (this == o) return true;
        if (!(o instanceof MobilePhoneStructureAdnCriteria)) return false;
        MobilePhoneStructureAdnCriteria that = (MobilePhoneStructureAdnCriteria) o;
        return Double.compare(that.getScreenSize(), getScreenSize()) == 0 &&
                getRam() == that.getRam() &&
                getStorage() == that.getStorage() &&
                getModel().equals(that.getModel()) &&
                getOs().equals(that.getOs()) &&
                getColor().equals(that.getColor()) &&
                getId() == that.getId();

    }

    @Override
    public int hashCode() {
        // метод вычисляет хеш-код объекта на основе значений всех полей класса
        return Objects.hash(getModel(), getRam(), getStorage(), getOs(), getColor(), getScreenSize(), getId());
    }

    @Override
    public String toString() {
        // метод возвращает строковое представление объекта в виде текстовой строки, содержащей все поля класса
        return "\n\nМобильный телефон --> " +
                "Модель = <" + model + '>' +
                ", Оперативная память = " + ram +
                ", Накопитель = " + storage +
                ", Операционная система = '" + os + '\'' +
                ", Цвет = '" + color + '\'' +
                ", Диагональ экрана = " + screenSize + "\" дюймов" +
                ", Id = " + id;
    }

    public static List<MobilePhoneStructureAdnCriteria> filterMobilePhones(List<MobilePhoneStructureAdnCriteria> phones, Map<String, Object> criteria) {
        // Статический метод принимает в качестве первого аргумента список объектов phones, а в качестве второго аргумента критерии отбора объектов из списка.
        // Возвращает список объектов phones, которые удовлетворяют переданным критериям.
        List<MobilePhoneStructureAdnCriteria> result = new ArrayList<>();
        for (MobilePhoneStructureAdnCriteria phone : phones) {
            boolean match = true;
            for (Map.Entry<String, Object> entry : criteria.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                switch (key) {
                    case "Оперативная память":
                        if (phone.getRam() < (int) value) {
                            match = false;
                        }
                        break;
                    case "Накопитель":
                        if (phone.getStorage() < (int) value) {
                            match = false;
                        }
                        break;
                    case "Операционная система":
                        if (!phone.getOs().equals(value)) {
                            match = false;
                        }
                        break;
                    case "Цвет":
                        if (!phone.getColor().equals(value)) {
                            match = false;
                        }
                        break;
                    case "Диагональ экрана":
                        if (phone.getScreenSize() < (double) value) {
                            match = false;
                        }
                        break;
                    case "Id":
                        if (phone.getId() < (long) value) {
                            match = false;
                        }
                        break;
                }
            }
            if (match) {
                result.add(phone);
            }
        }
        return result;
    }

    public static Map<String, Object> getCriteriaFromUser() {
        // метод приема данных от пользователя через меню с примерами и вывода их в консоль
        Map<String, Object> criteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Отфильтруйте список по критериям, основанным на возрастающем порядке введенного значения, после выбора критерия 1-6:");
        System.out.println("1. Оперативная память (ГБ) (Пример: 4,8,12)");
        System.out.println("2. Накопитель (ГБ) (Пример: 64,128,256)");
        System.out.println("3. Операционная система (Пример: Android,iOS)");
        System.out.println("4. Цвет (Пример: Graphite,Phantom Gray,Morning Mist,Blue,Black,Green)");
        System.out.println("5. Диагональ экрана (дюймы) (Пример: 4,6)");
        System.out.println("6. Id (Пример: 1,2 ... 5)");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Введите значение оперативной памяти (ГБ): ");
                int ram = scanner.nextInt();
                criteria.put("Оперативная память", ram);
                break;
            case 2:
                System.out.print("Введите значение накопителя (ГБ): ");
                int storage = scanner.nextInt();
                criteria.put("Накопитель", storage);
                break;
            case 3:
                System.out.print("Введите название операционной системы: ");
                String os = scanner.next();
                criteria.put("Операционная система", os);
                break;
            case 4:
                System.out.print("Введите название цвета: ");
                String color = scanner.next();
                criteria.put("Цвет", color);
                break;
            case 5:
                System.out.print("Введите значение диагонали экрана (дюймы): ");
                double screenSize = scanner.nextDouble();
                criteria.put("Диагональ экрана", screenSize);
                break;
            case 6:
                System.out.print("Введите значение Id: ");
                long id = scanner.nextLong();
                criteria.put("Id", id);
                break;
            default:
                System.out.println("Неверный выбор критерия.");
                break;
        }

        return criteria;
    }
}
