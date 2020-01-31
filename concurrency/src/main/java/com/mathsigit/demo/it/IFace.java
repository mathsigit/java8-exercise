package com.mathsigit.demo.it;

public interface IFace<R> {
    public default R[] generateArrays(){
        return generateArrays(0,0);
    }
    public R[] generateArrays(int size, int stringLength);
}
