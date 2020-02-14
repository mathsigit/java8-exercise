package com.mathsigit.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FuncAndConstruct {

    public static void main(String[] args) {
        String[] names = new String[]{"Justin", "caterpillar", "Bush"};
        //final String[] names = new ImpIFace().generateArrays(4,5);
        System.out.println("Origin order: " + String.join(", ", names));
        FuncAndConstruct fac = new FuncAndConstruct();
        fac.anonymousCategorySort(names);
        System.out.println("After sorting by AnonymousCategorySort: " + String.join(", ", names));
        names = new String[]{"Justin", "caterpillar", "Bush"};
        System.out.println("Origin order: " + String.join(", ", names));
        fac.lambdaSort(names);
        System.out.println("After sorting by LambdaSort: " + String.join(", ", names));
    }

    public FuncAndConstruct(){}

    public void anonymousCategorySort(String[] sortC){
        Arrays.sort(sortC, (name1, name2) -> name1.length() - name2.length());
    }

    public void lambdaSort(String[] sortC){
        Arrays.sort(sortC, StringOrder::byLength);
    }

    public Comparator generateComnparatorWithAnonymous(){
        return (Comparator<String>) (s1, s2) -> s1.length() - s2.length();
    }

    public Comparator generateComnparatorWithLambda(){
        return (Comparator<String>) String::compareTo;
    }
}
