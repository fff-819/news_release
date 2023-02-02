package com.uml;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test {
    public void te(List list){
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return 1;//第二个元素（o1）比第一个元素（o2）大，返回1
                if(o1==o2)
                    return 0;
                return -1;
            }
        });
    }
    @Test
    public void tee(){
        List<Integer> list = Arrays.asList(9,-3,99,11,1,0,12,0);
        System.out.println(list);
        te(list);
        System.out.println(list);
    }
}
