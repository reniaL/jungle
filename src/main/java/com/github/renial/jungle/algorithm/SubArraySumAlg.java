package com.github.renial.jungle.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of numbers, and a sum. Find a sub-set of the array, which add up to the sum.
 * <p>
 * Or return null if no sub-sets meet requirements.
 * <p>
 * https://www.nowcoder.com/questionTerminal/7f24eb7266ce4b0792ce8721d6259800
 */
public class SubArraySumAlg {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 8, 11, 15);
        int sum = 40;
        System.out.println("result: " + runSimple(list, sum));
    }

    public static List<Integer> runSimple(List<Integer> list, int sum) {
        List<List<Integer>> allList = new ArrayList<>(); // 存放全部子列表
        List<List<Integer>> temp;

        // 遍历每个元素
        for (Integer i : list) {
            // 复制一份原有的子列表，再加上一个空列表。然后 temp 的每个列表都加一个 i
            temp = copyList(allList);
            temp.add(new ArrayList<>());
            for (List<Integer> oneList : temp) {
                oneList.add(i);
                allList.add(oneList); // 将每个新列表添加到全列表中，也可以在 for 循环后一次性 addAll
                if (oneList.stream().mapToInt(Integer::intValue).sum() == sum) { // 判断 temp 中的每个列表，和是否为 sum
                    allList.forEach(System.out::println);
                    return oneList;
                }
            }
        }
        allList.forEach(System.out::println);
        return null;
    }

    private static List<List<Integer>> copyList(List<List<Integer>> allList) {
        List<List<Integer>> result = new ArrayList<>();
        allList.forEach(x -> result.add(new ArrayList<>(x)));
        return result;
    }
}
