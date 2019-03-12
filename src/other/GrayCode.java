package other;

/**
 * 格雷反射码（循环码） (****在这里不考虑负数****)
 * 十进制    二进制      格雷码
 * 0        000         000
 * 1        001         001
 * 2        010         011
 * 3        011         010
 * 4        100         110
 * 5        101         111
 * 6        110         101
 * 7        111         100
 */
public class GrayCode {
    public static void main(String[] args) {

    }

    /**
     * 自然二进制码转格雷码
     * grayCode = i ^ (i>>1);
     */
    public static int toGrayCode(int i) {
        return i ^ (i>>1);
    }

    /**
     * 格雷码转自然二进制码
     *
     *  格雷码 1 1 1
     *
     *  自然码 1 0 1
     *  格雷码最高位不变，格雷码的第i位与自然码的第i+1位异或得自然码的第i位。
     *  格雷码Gn ``` G3 G2 G1
     *
     *  自然码An ``` A3 A2 A1
     *   An = Gn;
     *   A(n-1) = G(n-1) ^ An;
     *   ``````
     *   A(i) = G(i) ^ A(i-1);
     *   ``````
     *   A1 = G1 ^ A2;
     */
    public static int toBinary(int i) {
        //TODO
        return 0;
    }
}
