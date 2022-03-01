package ss0_my_project;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        String a = "a";
        System.out.println(a.charAt(0));
    }
    static char[] solution(String arg1) {
        String[] stringArr = arg1.split("");
        List<String> result = new ArrayList<>();
        for(int i=0 ; i< stringArr.length ; i++){
            for(int j=i+1;j< stringArr.length;j++){
                if(stringArr[i].equals(stringArr[j]) && !result.contains(stringArr[i])){
                    result.add(stringArr[i]);
                    break;
                }
            }
        }
        char[] charArray = new char[result.size()];
        for(int i=0;i<charArray.length;i++){
            charArray[i]=result.get(i).charAt(0);
        }
        return charArray;
    }

}
