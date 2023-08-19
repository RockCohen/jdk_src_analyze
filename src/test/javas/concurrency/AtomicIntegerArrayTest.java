package test.javas.concurrency;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        AtomicIntegerArray array = new AtomicIntegerArray(a);
        int length = array.length();
        for(int i = 0; i<length; i ++){
            System.out.println(array.get(i));
        }
    }
}
