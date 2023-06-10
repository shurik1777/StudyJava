import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Создаем объект StringBuilder
        StringBuilder whereClause = new StringBuilder("select * from students where ");

        // Создаем json-строку с параметрами для фильтрации
        JSONObject filterParams = new JSONObject();
        filterParams.put("name", "Ivanov");
        filterParams.put("country", "Russia");
        filterParams.put("city", "Moscow");
        filterParams.put("age", null);

        // Проходим по каждому параметру и добавляем его в условие WHERE
        for (Object key : filterParams.keySet()) {
            String value = (String) filterParams.get(key);
            if (value != null) {
                whereClause.append(key).append(" = '").append(value).append("' and ");
            }
        }

        // Убираем последний "and" из условия WHERE
        whereClause.delete(whereClause.length() - 5, whereClause.length());

        // Выводим результат в файл
        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            fileWriter.write(whereClause.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
