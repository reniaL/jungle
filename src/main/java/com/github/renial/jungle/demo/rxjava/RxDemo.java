package com.github.renial.jungle.demo.rxjava;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Flowable;

public class RxDemo {

    public static void main(String[] args) {
        RxDemo demo = new RxDemo();
        demo.hello();
    }

    public void hello() {
        Flowable.just("Hello world").subscribe(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Flowable.fromIterable(list).filter(x -> x % 2 == 0).subscribe(System.out::println);
    }
}
