package com.Leetcode;

/**
 * Leetcode68,文本左右对齐
 * 模拟
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo68 {
    public static void main(String[] args) {

    }
    public static List<String> fullJusttify(String[] words, int maxWidth)
    {
        List<String> res = new ArrayList<>();
        int n = words.length;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n;) {
            //list装载当前行所有word
            list.clear();
            list.add(words[i]);
            int cur = words[i++].length();
            //每个单词后面需要加上1个空格
            while(i < n && cur + 1 + words[i].length() <= maxWidth)
            {
                cur += 1 + words[i].length();
                list.add(words[i++]);
            }

            //当前行为最后一行，特殊处理左对齐
            if(i == n)
            {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while(sb.length() < maxWidth) sb.append(" ");
                res.add(sb.toString());
                break;
            }

            //如果当前行只有一个word，特殊处理左对齐
            int cnt = list.size();
            if(cnt == 1)
            {
                String str = list.get(0);
                while(str.length() != maxWidth) str += " ";
                res.add(str);
                continue;
            }

            /**
             * 其余情况
             * wordWidth:当前行单词总长度
             * spaceWidth:当前行空格总长度
             * spaceItem:往下取整后单位空格长度
             */
            //最后一个单词后面无空格
            int wordWidth = cur - (cnt - 1);
            int spaceWidth = maxWidth - wordWidth;
            int spaceItemWidth = spaceWidth / (cnt - 1);
            String spaceItem = "";
            for(int k = 0; k <spaceItemWidth; k++) spaceItem += " ";
            StringBuilder sb = new StringBuilder();
            for(int k = 0, sum = 0; k < cnt; k++)
            {
                String item = list.get(k);
                sb.append(item);
                if(k == cnt - 1) break;
                sb.append(spaceItem);
                sum += spaceItemWidth;
                int remain = cnt - k - 1 - 1;
                //空格无法均分时往左边多添加一个空格
                if(remain * spaceItemWidth + sum < spaceWidth)
                {
                    sb.append(" ");
                    sum++;
                }

            }

            res.add(sb.toString());
        }
        return res;
    }
}
