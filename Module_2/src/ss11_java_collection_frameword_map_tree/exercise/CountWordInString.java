package ss11_java_collection_frameword_map_tree.exercise;
import java.util.*;

public class CountWordInString {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần đếm: ");
        String string = scanner.nextLine();
        int count;
        String[] strings = string.toLowerCase().split(" ");
        Map<String, Integer> map = new TreeMap<>();
        map.put(strings[0], 1);
        for (int i = 1; i < strings.length; i++) {
            count = 1;
            if (map.containsKey(strings[i])){
                count = map.get(strings[i]) +1;
            }
            map.put(strings[i], count);
//            for (String key : map.keySet()) {
//                if (key.equals(strings[i])) {
//                    count = map.get(key) +1;
//                }
//                map.put(strings[i], count);
//            }
        }
        for (String key : map.keySet()) {
            System.out.println(key + " có số lần xuất hiện là: " + map.get(key));
        }
    }
}