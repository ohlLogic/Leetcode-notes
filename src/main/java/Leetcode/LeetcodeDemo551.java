package com.Leetcode;

/**
 * Leetcode551, 学生出勤记录1
 * 模拟
 */
class  LeetcodeDemo551 {
    public static void main(String[] args) {
        System.out.println(checkPecord("PPALLL"));
    }

    public static boolean checkPecord(String s)
    {
        int coutA = 0, coutL = 0, cout = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'A') coutA++;
            if(s.charAt(i) == 'L')
            {
                coutL = Math.max(1, coutL);
                if(i < s.length() - 1)
                {
                    int j = i + 1;
                    while(j < s.length() && s.charAt(j) == s.charAt(i)) j++;
                    cout = j - i;
                    coutL = Math.max(coutL, cout);
                }
            }

        }

        if(coutA < 2 && coutL < 3) return true;
        return false;
    }

    public static boolean checkPecord1(String s)
    {
        int n = s.length();
        for(int i = 0, cnt = 0; i < n;)
        {
            char c = s.charAt(i);
            if(c == 'A')
            {
                cnt++;
                if(cnt >= 2) return false;
            }
            else if(c == 'L')
            {
                int j = i;
                while(j < n && s.charAt(j) == 'L') j++;
                int len = j - i;
                if(len >= 3) return false;
                i = j;
                continue;
            }
            i++;
        }
        return true;
    }
}
