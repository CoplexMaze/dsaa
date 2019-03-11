package other;

public class fanruan_1 {
    public static void main(String[] args) {
        SpecialNumber a1 = new SpecialNumber(2322221231233L, "74151231239654");
        SpecialNumber b1 = new SpecialNumber(92452333343L, "7412345926111111");
        System.out.println(SpecialNumber.add(a1, b1));
        SpecialNumber a2 = new SpecialNumber(2322231233L, "05");
        SpecialNumber b2 = new SpecialNumber(9245343L, "555");
        System.out.println(SpecialNumber.ride(a2, b2));
    }
}

class SpecialNumber {
    long z;
    String x;

    public SpecialNumber(){
        z = 0;
        x = "";
    }
    public SpecialNumber(long l, String s) {
        z = l;
        x = s;
    }

    public static SpecialNumber add (SpecialNumber a, SpecialNumber b) {
        String as, bs, tail;
        long l = a.z + b.z;
        if (a.x.length() > b.x.length()) {
            as = a.x.substring(0, b.x.length());
            bs = b.x;
            tail = a.x.substring(b.x.length());
        } else {
            bs = b.x.substring(0, a.x.length());
            as = a.x;
            tail = b.x.substring(a.x.length());
        }
        long a_x = Long.parseLong(as);
        long b_x = Long.parseLong(bs);
        String s1 = String.valueOf(a_x + b_x);
        if(s1.length() != as.length()) {
            s1 = s1.substring(1);
            l++;
        }

        return new SpecialNumber(l, s1 + tail);
    }

    public static SpecialNumber ride (SpecialNumber a, SpecialNumber b) {
        long l = a.z * b.z;
        long a_x = Long.parseLong(a.x);
        long b_x = Long.parseLong(b.x);
        String s1 = String.valueOf(a_x * b_x);
        int c = a.x.length() + b.x.length() - s1.length();
        for(int i = 0; i < c; i++) {
            s1 = "0" + s1;
        }
        if (s1.length() > 18) s1 = s1.substring(0, 18);
        return new SpecialNumber(l, s1);
    }

    @Override
    public String toString() {
        return String.valueOf(z) + "." + x;
    }
}
