package com.campusseven;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        //List<Integer> scores = Arrays.asList(5,7,1,9,2,8);
        List<String> scores = Arrays.asList("z", "x", "spring", "java");
        //Collections.sort(scores);
        Collections.sort(scores, (o1, o2) -> o1.length() - o2.length());

        scores.forEach(System.out::println);    //:: 기호는 메소드 참조 연산자, 특정 메소드를 직접 호출하지 않고 참조로 넘기기 위해 사용

    }
}
