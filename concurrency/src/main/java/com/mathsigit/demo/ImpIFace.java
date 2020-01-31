package com.mathsigit.demo;

import com.mathsigit.demo.it.IFace;
import com.mathsigit.util.RandomString;

import java.util.ArrayList;
import java.util.List;

public class ImpIFace implements IFace {
    @Override
    public String[] generateArrays(int size, int stringLength) {
        List<String> lt = new ArrayList<>();
        RandomString session = new RandomString(stringLength);
        for(int i = 0;i < size;i++) {
            lt.add(session.nextString());
        }
        return lt.toArray(new String[size]);
    }
}
