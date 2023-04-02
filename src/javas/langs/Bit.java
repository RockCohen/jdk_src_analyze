package javas.langs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 暂不支持枚举类型的bit提取
 */
public class Bit {
    // 使用byte来存储一个bit
    private  byte bit;

    public static Bit ONE = new Bit(1);

    public static Bit ZERO = new Bit(0);

    public Bit(boolean b) {
        bit = (byte) (b ? 1 : 0);
    }
    public Bit(Boolean b) {
        bit = (byte) (b.equals(Boolean.TRUE) ? 1 : 0);
    }
    public Bit(byte b) {
        if (b > 1 ||  b < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = b;
    }
    public Bit(Byte b) {
        if (b > 1 ||  b < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = b;
    }
    public Bit(short s) {
        if (s > 1 ||  s < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = (byte) s;
    }
    public Bit(Short s) {
        if (s > 1 ||  s < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = s.byteValue();
    }
    public Bit(int i) {
        if (i > 1 || i < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = (byte) i;
    }
    public Bit(Integer i) {
        if (i > 1 || i < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = i.byteValue();
    }
    public Bit(long l) {
        if (l > 1 || l < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = (byte) l;
    }
    public Bit(Long l) {
        if (l > 1 || l < 0) {
            throw new IllegalArgumentException("the parameter is not right! only 1 or 0 are allowed!");
        }
        bit = l.byteValue();
    }
    public Bit(CharSequence s) {
        String str = s.toString();
        boolean b = str.equals("0") || str.equals("00") || str.equals("0x0") || str.equals("1") || str.equals("01") || str.equals("0x1");
        if (!b) {
            throw new IllegalArgumentException("the parameter s is not match!");
        }
        bit = (byte) Integer.parseInt(str);
    }

    /**
     * get a bit value from n.
     * @param index the index to get from n.
     * @param n the target number.
     * @return the bit at index of n.
     */
    public static Bit getBit(int index, Object n) {
        if (!(n instanceof Number)) {
            throw new IllegalArgumentException("the parameter n is not allowed,only basic data type and sub type of Number are allowed!");
        }
        Number nn  = (Number) n;
        Class<? extends Number> aClass = nn.getClass();
        int size = getBitSize(aClass,nn);
        if (size <= 0) {
            throw new IllegalArgumentException("the the parameter n's size is less than 0! ");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("the index is out of bounds!");
        }
        return getBit(index,aClass,nn);
    }

    private static Bit getBit(int index,Class<? extends Number> aClass, Number n) {
        if (aClass.equals(Byte.class)) {
            Byte b = (Byte) n;
            return new Bit( (b >>index)&1);
        }
        if (aClass.equals(Short.class)) {
            Short s = (Short) n;
            return new Bit(s >>index & 1);
        }
        if (aClass.equals(Integer.class)) {
            Integer i = (Integer) n;
            return new Bit(i>>index & 1);
        }
        if (aClass.equals(Long.class)) {
            Long l = (Long) n;
            return new Bit(l>>index & 1);
        }else {
            throw new IllegalArgumentException("the parameter n is not allowed!");
        }
    }

    private static int getBitSize(Class<? extends Number> aClass, Number n) {

        if (aClass.equals(Byte.class)) {
            return Byte.SIZE;
        }
        if (aClass.equals(Short.class)) {
            return Short.SIZE;
        }
        if (aClass.equals(Integer.class)) {
            return Integer.SIZE;
        }
        if (aClass.equals(Long.class)) {
            return Long.SIZE;
        }
        throw new IllegalArgumentException(" the parameter n is not allowed,only Byte, Short, Integer, Long are allowed!");
    }

    @Override
    public String toString() {
        return String.valueOf(bit);
    }

    @Override
    public boolean equals(Object o) {
        if ( !(o instanceof Bit)) {
            throw new IllegalArgumentException("the parameter o's type is not allowed,must be Bit!");
        }
        Bit b = (Bit) o;
        return this.bit == b.bit;
    }

    /**
     * 取反
     */
    public void negate() {
        bit = (byte) (bit == 1 ? 0 : 1);
    }

    public Bit and(Bit bit) {
        return new Bit( this.bit & bit.bit);
    }
    public Bit or(Bit bit) {
        return new Bit(this.bit | bit.bit);
    }

    public Bit xor(Bit bit) {
        return new Bit(this.bit ^ bit.bit);
    }
}
