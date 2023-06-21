package HashMapTest;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static HashMap<Integer, String> fill() {
        //fill(Integer[] intValue,String[] values)
        HashMap<Integer, String> outMap = new HashMap<>();
        outMap.put(123456, "Ivanov");
        outMap.put(321456, "Vasilev");
        outMap.put(234561, "Petrov");
        outMap.put(234432, "Ivanov");
        outMap.put(654321, "Petrov");
        outMap.put(345678, "Ivanov");
        return outMap;
    }

    public static void printHashMap(HashMap<Integer, String> outMap, String searchValue) {
        for (Map.Entry<Integer,String> item: outMap.entrySet())
        {
            if(item.getValue()==searchValue)
            {
                System.out.println(item.getValue()+" - "+item.getKey());
            }

        }
    }
}
