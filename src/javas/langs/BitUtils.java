package javas.langs;

public class BitUtils {
    /**
     * the index zero record the highest bit of b
     * @param b
     * @return
     */
    public static Bit[] getBits(Byte b) {
        int size = Byte.SIZE;
        return getBits(size,b);
    }

    /**
     * the index zero record the highest bit of b
     * @param s
     * @return
     */
    public static Bit[] getBits(Short s) {
        int size = Short.SIZE;
        return getBits(size,s);
    }

    /**
     * the index zero record the highest bit of b
     * @param integer
     * @return
     */
    public static Bit[] getBits(Integer integer) {
        int size = Integer.SIZE;
        return getBits(size,integer);
    }

    /**
     * the index zero record the highest bit of b
     * @param l
     * @return
     */
    public static Bit[] getBits(Long l) {
        int size = Long.SIZE;
        return getBits(size,l);
    }

    private static Bit[] getBits(int size, Number n) {
        Bit[] bits = new Bit[size];
        for(int i = 0; i< size; i++){
            bits[size-i-1] = Bit.getBit(i,n);
        }
        return bits;
    }

    public static boolean isEqual(Bit a, Bit b) {
        return a.equals(b);
    }

    public static Bit and(Bit a, Bit b) {
        return a.and(b);
    }

    public static Bit or(Bit a, Bit b) {
        return a.or(b);
    }

    public static Bit xor(Bit a, Bit b) {
        return a.xor(b);
    }

    public static Bit negate(Bit bit) {
        bit.negate();
        return bit;
    }




}
