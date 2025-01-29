// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/description/
class KMP {
    public int[] tempArray(char pattern[]) {
        int lps[] = new int[pattern.length];
        int idx = 0;

        for (int i = 1; i < pattern.length;) {
            if (pattern[i] == pattern[idx]) {
                lps[i] = idx + 1;
                idx++;
                i++;
            } else {
                if (idx != 0) idx = lps[idx - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public List<Integer> findOccurrences(String s, String pattern) {
        List<Integer> indices = new ArrayList<>();
        char[] text = s.toCharArray();
        char[] pat = pattern.toCharArray();
        int[] lps = tempArray(pat);

        int i = 0, j = 0;
        while (i < text.length) {
            if (text[i] == pat[j]) {
                i++;
                j++;
                if (j == pat.length) {
                    indices.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return indices;
    }
}

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        KMP kmp = new KMP();

        List<Integer> aIndices = kmp.findOccurrences(s, a);
        List<Integer> bIndices = kmp.findOccurrences(s, b);
        List<Integer> result = new ArrayList<>();

        for (int i : aIndices) {
            for (int j : bIndices) {
                if (Math.abs(i - j) <= k) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}
