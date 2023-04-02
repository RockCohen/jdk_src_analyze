package javas.langs;

public class BitUtils {
    /**
     * the index zero record the highest bit of b
     * @param b
     * @return
     */
    public static Bit[] getBits(Byte b) {
        int size = Byte.SIZE;
        Bit[] bits = new Bit[size];
        for(int i = 0; i< size; i++){
            bits[size-i-1] = Bit.getBit(i,b);
        }
        return bits;
    }

    public static Bit[] getBits(Short s) {
        int size = Short.SIZE;
        Bit[] bits = new Bit[size];
        for(int i = 0; i< size; i++){
            bits[size-i-1] = Bit.getBit(i,s);
        }
        return bits;
    }
    public static Bit[] getBits(Integer integer) {
        int size = Integer.SIZE;
        Bit[] bits = new Bit[size];
        for(int i = 0; i< size; i++){
            bits[size-i-1] = Bit.getBit(i,integer);
        }
        return bits;
    }
    public static Bit[] getBits(Long l) {
        int size = Long.SIZE;
        Bit[] bits = new Bit[size];
        for(int i = 0; i< size; i++){
            bits[size-i-1] = Bit.getBit(i,l);
        }
        return bits;
    }


    public static Bit negate(Bit bit) {
        bit.negate();
        return bit;
    }
}
