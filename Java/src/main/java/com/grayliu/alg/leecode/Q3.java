package com.grayliu.alg.leecode;

/**
 * Created by liuhui-ds9 on 2018/3/15.
 * <p>
 * ��������ַ���
 * <p>
 * ˼·��ͷ��ʼ�ۻ����������Ķ����¼ӽ����ģ��Ѻ�����ٽ��Ľ������
 */
public class Q3 {

    public static void get(char[] input) {
        int start = 0, end = 0;
        int maxStart = 0, maxEnd = 0;
        for (int i = 0; i < input.length; i++) {
            end = i;
            for (int j = i - 1; j >= start; j--) {
                if (input[i] == input[j]) {
                    start = j + 1;
                    break;
                }
            }
            if (end - start > maxEnd - maxStart) {
                maxEnd = end;
                maxStart = start;
            }
        }
        print(input, maxStart, maxEnd);
    }

    public static void print(char[] input, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(input[i]);
        }
    }

    public static void main(String... args) {
        char[] input = "1122345671".toCharArray();
        get(input);
    }

}
