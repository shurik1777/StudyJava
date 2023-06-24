package HardwareStore;

import java.util.*;


public class MobilePhoneStructureAdnCriteria {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double screenSize;

    public MobilePhoneStructureAdnCriteria(String model, int ram, int storage, String os, String color, double screenSize) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.screenSize = screenSize;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobilePhoneStructureAdnCriteria)) return false;
        MobilePhoneStructureAdnCriteria that = (MobilePhoneStructureAdnCriteria) o;
        return Double.compare(that.getScreenSize(), getScreenSize()) == 0 &&
                getRam() == that.getRam() &&
                getStorage() == that.getStorage() &&
                getModel().equals(that.getModel()) &&
                getOs().equals(that.getOs()) &&
                getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getRam(), getStorage(), getOs(), getColor(), getScreenSize());
    }

    @Override
    public String toString() {
        return "\n\nМобильный телефон --> " +
                "Модель = <" + model + '>' +
                ", Оперативная память = " + ram +
                ", Накопитель = " + storage +
                ", Операционная система = '" + os + '\'' +
                ", Цвет = '" + color + '\'' +
                ", Диагональ экрана = " + screenSize + "\" дюймов";
    }

    public static List<MobilePhoneStructureAdnCriteria> filterMobilePhones(List<MobilePhoneStructureAdnCriteria> phones, Map<String, Object> criteria) {
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
                }
            }
            if (match) {
                result.add(phone);
            }
        }
        return result;
    }
    public void MobilePhones() {
        for (int i = 0; i < this.phones.size(); i++) {
            MobilePhone phone = this.notebookList.get(i);
            System.out.println((i + 1) + ". " + phone.getModel() + ", RAM: " + phone.getRam() + " GB, Storage: " +
                    phone.getStorage() + " GB, OS: " + phone.getOs() + ", Color: " + phone.getColor() +
                    ", Screen Size: " + phone.getScreenSize() + " inches");
        }
    }

    public static Map<String, Object> getCriteriaFromUser() {
        Map<String, Object> criteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 7) {
            System.out.println("Выберите критерии фильтрации:");
            System.out.println("1. Оперативная память (ГБ)");
            System.out.println("2. Накопитель (ГБ)");
            System.out.println("3. Операционная система");
            System.out.println("4. Цвет");
            System.out.println("5. Диагональ экрана (дюймы)");
            System.out.println("6. Показать все телефоны");
            System.out.println("7. Завершить выбор");

            do {
                System.out.print("Введите номер критерия: ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 7);

            if (choice == 7) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Оперативная память (ГБ): ");
                    int ram = scanner.nextInt();
                    criteria.put("Оперативная память", ram);
                    break;
                case 2:
                    System.out.print("Накопитель (ГБ): ");
                    int storage = scanner.nextInt();
                    criteria.put("Накопитель", storage);
                    break;
                case 3:
                    System.out.print("Операционная система: ");
                    String os = scanner.next();
                    criteria.put("Операционная система", os);
                    break;
                case 4:
                    System.out.print("Цвет: ");
                    String color = scanner.next();
                    criteria.put("Цвет", color);
                    break;
                case 5:
                    System.out.print("Диагональ экрана (дюймы): ");
                    double screenSize = scanner.nextDouble();
                    criteria.put("Диагональ экрана", screenSize);
                    break;
                case 6:
                    System.out.print("Список всех телефонов: ");
                    System.out.println();
                    break;

            }
        }

        return criteria;
    }
}

