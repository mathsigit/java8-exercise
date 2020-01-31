package com.mathsigit.demo;

import com.mathsigit.demo.it.IFace;
import java.util.Arrays;

public class DemoExecute {

    public static void main(String[] args) {
        IFace e = new ImpIFace();
        Arrays.asList(e.generateArrays(3,10)).forEach(System.out::println);

    }
}
