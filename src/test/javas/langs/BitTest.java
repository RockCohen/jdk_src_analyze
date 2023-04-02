package test.javas.langs;

import javas.langs.Bit;
import javas.langs.BitUtils;

public class BitTest {
    public static void main(String[] args) {
        test3();
    }
    public static void  test1() {
        System.out.println(Bit.getBit(0, 1));
    }

    public static void test2() {
        Bit[] bits = BitUtils.getBits((byte)-16);
        Bit[] bits2 = BitUtils.getBits((byte)16);
        System.out.println(bits.length);
        for(Bit bit : bits) {
            System.out.print(bit+" ");
        }
        System.out.println();
        for(Bit bit : bits2) {
            System.out.print(bit+" ");
        }
    }
    public static void test3() {
        Bit bit = new Bit(new StringBuffer("01"));
        System.out.println(bit);
    }
}
