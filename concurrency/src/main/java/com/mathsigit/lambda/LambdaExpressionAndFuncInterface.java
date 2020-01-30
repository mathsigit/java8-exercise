package com.mathsigit.lambda;

import com.mathsigit.lambda.it.Func;

public class LambdaExpressionAndFuncInterface {

    public static void main(String[] args) {

        LambdaExpressionAndFuncInterface aa = new LambdaExpressionAndFuncInterface();
        aa.GenerateFuncWithString();
        aa.GenerateFuncWithInt();
    }

    public LambdaExpressionAndFuncInterface(){}

    public void GenerateFuncWithString(){
        Func<String, Integer> func = (name1, name2) -> {
            return name1.length() - name2.length();
        };
        System.out.println(func.apply("abcd123","abcd"));
    }

    public void GenerateFuncWithInt(){
        Func<Integer, Integer> func = (n1, n2) -> n1 - n2;
        System.out.println(" = "+func.apply(7,9));
    }
}
