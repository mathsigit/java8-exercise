package com.mathsigit.lambda;

import java.util.Arrays;
import java.util.stream.Stream;

public class FuncAndConstruct {



    public static void main(String[] args) {
        String[] names = {"Justin", "caterpillar", "Bush"};
        System.out.println("Origin order: " + String.join(",", names));
        FuncAndConstruct fac = new FuncAndConstruct();
        fac.AnonymousCategory(names);
        System.out.println("After sorting: " + String.join(",", names));
    }

    public FuncAndConstruct(){}

    public void AnonymousCategory(String[] sortC){
        Arrays.sort(sortC, (name1, name2) -> name1.length() - name2.length());
    }
}
