package main.java.com.grayliu.alg.tree;

/**
 * Created by liuhui-ds9 on 2017/8/29.
 * <p>
 * 1,2,3,4,2,1�����ֵ
 * <p>
 * У��
 * ��ʼ����ֵ
 * ������ֹ����
 * ѭ��
 * ���������
 * �ݹ��ѭ�����˳����������ҵ�������
 * <p>
 * <p>
 * ǰ�᣺ֻ�д��ں�С�����������û�е��ڣ���Ϊ���ڲ����ж�ͼ�ε�����
 * <p>
 * ���ֲ��������������õĶ�����
 */
public class BinarySearch {

    public static int search_1(int[] array, int start, int end, int key) {
        //У��
        if (array.length == 0 || start > end) return -1;
        //��ʼ���˳�����
        int mid = (start + end) / 2;
        //ִ�еݹ�
        if (array[mid] == key) {
            return mid;
        } else if (start == end) {
            return -1;
        } else if (array[mid] > key) {
            return search_1(array, start, mid - 1, key);
        } else {
            return search_1(array, mid + 1, end, key);
        }
    }

    public static int search(int[] array, int key) {
        //�����β��Ϸ��˳�
        if (array.length == 0) return -1;
        //��ʼ���˳�����
        int start = 0;
        int end = array.length;
        int half = (start + end) / 2;
        //ִ��ѭ��
        while (array[half] != key) {
            //�������һ��û���ҵ��˳�
            if (start == end) {
                return -1;
            } else if (array[half] < key) {
                start = half + 1;
            } else if (array[half] > key) {
                end = half - 1;
            }
            half = (start + end) / 2;
        }
        return half;
    }

    public static void main(String... args) {
        int[] array = {1, 2, 3, 5, 6};
        System.out.println(search_1(array, 0, 4, 5));
    }

    /**
     * Ŀǰ����ͨ�����Ժ�����ٿ���һ���������
     */
    static class Method2 {

        /**
         * @param numbers
         * @param start
         * @param end
         */

        public static void twoWaySearch(int[] numbers, int start, int end) {
            if (numbers == null || numbers.length <= 0) {
                return;
            }

            if (start == end) {
                System.out.println(numbers[start]);
                return;
            }
            int half = (end + start) / 2;
            if (numbers[half] > numbers[start]) {
                twoWaySearch(numbers, half, end);
            } else {
                twoWaySearch(numbers, start, half);
            }
        }


        public static void main(String... args) {
            System.out.println("inner class");

            int[] numbers = {1, 2, 3, 4, 5, 2, 1};

            twoWaySearch(numbers, 0, numbers.length);

        }
    }

}
