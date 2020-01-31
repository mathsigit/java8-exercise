package com.mathsigit.lambda;

import com.mathsigit.demo.ImpIFace;
import com.mathsigit.demo.it.IFace;

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

    public Comparator generateComnparator(){
        //return (Comparator<String>) (s1, s2) -> s1.length() - s2.length();
        return (Comparator<String>) String::compareTo;
    }
}
