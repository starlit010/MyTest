package com.grayliu.alg.string;

import java.util.*;

/**
 * Created by liuhui-ds9 on 2018/3/9.
 * <p>
 * ��׼kmp����
 */
public class KmpTest {

    /**
     * @param str
     * @param pat
     * @return ���û�з���-1����������������ķ��صڼ�λ
     */
    public static int kmp(char[] str, char[] pat) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == pat[0]) {
                list.add(i);
            }
            if (list.size() > 0) {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    int index = iterator.next();
                    if (str[i] == pat[i - index] && i - index <= pat.length - 1) {
                        if (str[i] == pat[i - index] && i - index == pat.length - 1) {
                            return index;
                        } else if (str[i] == pat[i - index]) {
                            continue;
                        } else {
                            iterator.remove();
                        }
                    } else {
                        iterator.remove();
                    }
                }
            }
        }
        return -1;
    }


    /**
     * 重点是，两个字符串，两个指针
     * 如果两个字符串比对失败，那么大字符串的指针还没有越过小字符串，然后小字符串向后移动，看看有没有能满足大小匹配的情况
     * 初步测试完成，没有深入测试
     */
    public static List kmpTest2(String strLong, String strShort) {
        char[] charLong = strLong.toCharArray();
        char[] charShort = strShort.toCharArray();

        int sizeLong = charLong.length;
        int sizeShort = charShort.length;

        int indexLong = 0, indexShort = 0;

        ArrayList result = new ArrayList();

        for (; indexLong < sizeLong; indexLong++) {

            if (indexLong > sizeLong) {
                break;
            }

            if (indexShort > sizeShort) {
                result.add(indexLong - 1);
                indexShort = 0;
            }

            if (indexShort + 1 == sizeShort) {
                result.add(indexLong);
            }

            if (charLong[indexLong] == charShort[indexShort]) {
                indexShort++;
                continue;
            }

            if (charLong[indexLong] != charShort[indexShort]) {
                indexShort = getNext2(charLong, charShort, indexLong + 1, indexShort);
            }
        }

        return result;
    }


    public static int getNext2(char[] charLong, char[] charShort, int indexLong, int indexShort) {
        //回溯一个短字符串扫过的长度
        int tempIndex = 0;

        for (int i = indexLong - indexShort + 1; i < indexLong && indexShort >= 0; i++, indexShort--) {

            int tempI = i;

            for (int j = 0; j < indexShort; j++) {

                if (indexShort == 0 && charLong[tempI] == charShort[j]) {
                    tempIndex = j + 1;
                }

                if (tempI == indexLong && charLong[tempI] == charShort[j]) {
                    return tempIndex = j + 1;
                }

                if (charLong[tempI] != charShort[j]) {
                    break;
                }

                tempI++;
            }
        }

        return tempIndex;
    }

    public static void main(String... args) {
        String value = "BBCABCDABABCDABDDABDE";
        String pattern = "ABCDABD";
//        System.out.println(kmp(value.toCharArray(),pattern.toCharArray()));
//        System.out.println(getNext2(value.toCharArray(),pattern.toCharArray(),7,5));
        System.out.println(kmpTest2(value, pattern));
    }


    //测试用例，黑盒测试，两个输入，输入有长度属性，包含属性，排列组合为四种情况
    // 首先是字符串长度校验，


}
