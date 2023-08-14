package py.com.daas.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println("containsDuplicate = " + AddBinary.addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (aLen >= 0 || bLen >= 0) {
            int sum = carry;
            if (aLen >= 0)
                sum += a.charAt(aLen--) - '0';
            if (bLen >= 0)
                sum += b.charAt(bLen--) - '0';
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

}
