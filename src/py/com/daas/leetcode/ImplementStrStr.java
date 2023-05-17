package py.com.daas.leetcode;

public class ImplementStrStr {
    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    Example 1:
    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.

    Example 2:
    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
    Explanation: "leeto" did not occur in "leetcode", so we return -1.

    Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.
     */
    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("mississippi", "issi"));
        System.out.println(implementStrStr.strStr("mississippi", "issip"));
        System.out.println(implementStrStr.strStr("padbutsad", "sad"));
        System.out.println(implementStrStr.strStr("leetcode", "leeto"));
    }

    public int strStr(String haystack, String needle) {
        // haystack.length > needle.length
        // if (hIndex == nIndex) for all needle.length we found it
        if (haystack == null || needle == null)
            return -1;

        int hIndex = 0;
        int nIndex = 0;
        while (hIndex < haystack.length() && nIndex < needle.length()) {
            char hC = haystack.charAt(hIndex);
            char nC = needle.charAt(nIndex);
            if (hC == nC) {
                nIndex++;
            } else {
                hIndex =  hIndex - nIndex;
                nIndex = 0;
            }
            hIndex++;
        }

        return (nIndex == needle.length()) ? hIndex - needle.length() : -1;
    }
}
