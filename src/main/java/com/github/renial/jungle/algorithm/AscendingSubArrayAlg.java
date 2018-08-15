package com.github.renial.jungle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AscendingSubArrayAlg {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 9, 2, 2, 5, 10, 8, 11);
        System.out.println(runSimple(list));
    }

    public static List<Integer> runSimple(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            // 如果当前元素小于等于前一个元素，表示子列表 temp 已结束
            if (list.get(i) <= list.get(i - 1)) {
                // 判断子列表 temp 是否比 result 长
                if (temp.size() > result.size()) {
                    result = temp;
                }
                temp = new ArrayList<>();
            }
            temp.add(list.get(i));
        }

        // 判断最后一个子列表 temp
        if (temp.size() > result.size()) {
            result = temp;
        }
        return result;
    }
}
