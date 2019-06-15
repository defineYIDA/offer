package subject;

import java.util.Comparator;

/**
 * @Author: zl
 * @Date: 2019/5/23 11:32
 */
public class Pro45 {
    /**
     *题45，把数组排成最小的数
     *    实现自定义的比较规则：nm 和 mn的关系，然后运用快排进行排序
     *    使用字符串或数组来解决大数问题
     *快排总结：
     *           1）重要条件：left < right---------1
     *           2）找基准点：a:以start索引位的元素为基准点，b:从start~end的范围内radom
     *           3）迭代：先右(从右找到第一个小于base的index，左移)后左(从左找到第一个大于base的index，右移)
     *           4）交换：对应index的元素值(满足条件1的情况下)
     *           5）交换：base和left的元素值
     *           6）递归：<start~left-1> <left+1~end>
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0) {
            return "";
        }
        MComparator com = new MComparator();
        quickSort(numbers, 0, numbers.length - 1, com);
        StringBuilder sb = new StringBuilder();

        for (int i : numbers) {
            sb.append(String.valueOf(i));
        }

        return sb.toString();
    }

    private void quickSort(int [] numbers, int start, int end, MComparator com) {
        if (start >= end) {
            return ;
        }
        int base = numbers[start];//基准点
        int left = start;
        int right = end;
        while (left < right) {
            /*
            //right 左移 找到第一个小于基准值的位置
            while (left < right && numbers[right] >= base) {
                right--;
            }
            //left 右移
            while (left < right && numbers[left] <= base) {
                left++;
            }
            */
            while (left < right && com.compare(numbers[right], base) >= 0) {
                right--;
            }
            //left 右移
            while (left < right && com.compare(numbers[left], base) <= 0) {
                left++;
            }
            if (left < right) {
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
            }
        }
        numbers[start] = numbers[left];
        numbers[left] = base;
        quickSort(numbers, start, left - 1, com);
        quickSort(numbers, left + 1, end, com);
    }
    private static class MComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String num1 = o1.toString();
            String num2 = o2.toString();
            String s1 = num1 + num2;
            String s2 = num2 + num1;
            return s1.compareTo(s2);
        }
    }

}
