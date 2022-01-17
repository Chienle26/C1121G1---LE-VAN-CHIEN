package ss12_search_algorithm.exercise;

import java.util.LinkedList;

public class FindStringBiggestConsecutive {
    public static void main(String[] args) {
        String string = "abcabcdgabmnsxy";
        LinkedList<Character> charTemp = new LinkedList<>();
        LinkedList<Character> charMax = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            if (charTemp.size() > 1 && string.charAt(i) <= charTemp.getLast()) {
                charTemp.clear();
            }

            charTemp.add(string.charAt(i));

            if (charTemp.size() > charMax.size()) {
                charMax.clear();
                charMax.addAll(charTemp);
            }
        }
        for (Character chars : charMax) {
            System.out.print(chars);
        }
    }
    /* Tính toán độ phức tạp của bài toán này:
            * 	1 vòng lặp * 3 câu lệnh = 3;
            * 	1 vòng lặp * 1 câu lệnh = 1;
            * 	T(n) = O(n)
            *  Độ phức tạp của bài toán là O(n) */
}
