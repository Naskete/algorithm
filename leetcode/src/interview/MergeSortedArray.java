package interview;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[ ] args) {


        int[ ] a = {1, 2, 3, 4, 5};


        int[ ] b = {-5, 0, 2, 3, 4, 5, 6, 7};


        int[ ] mergedArray = mergeArray(a, b);

        System.out.println(Arrays.toString(mergedArray));

    }

    /**
     * 合并两个有序数组，并去重。 不允许用 set list map 等复杂对象，纯c语言语法。
     * 1,代码行数  20
     * 2,复杂度 20
     * 3,代码逻辑可读性 20
     * 4,交付时间 20
     * 5,其它综合 20
     * @param arr1
     * @param arr2
     * @return
     */

    public static int[] mergeArray(int[ ] arr1, int[ ] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] temp = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                // 检查是否与结果数组中最后一个元素重复
                if (k == 0 || temp[k - 1] != arr1[i]) {
                    temp[k++] = arr1[i];
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (k == 0 || temp[k - 1] != arr2[j]) {
                    temp[k++] = arr2[j];
                }
                j++;
            } else {
                // 两个数组当前元素相等
                if (k == 0 || temp[k - 1] != arr1[i]) {
                    temp[k++] = arr1[i];
                }
                i++;
                j++;
            }
        }

        // 处理arr1剩余元素
        while (i < n1) {
            if (k == 0 || temp[k - 1] != arr1[i]) {
                temp[k++] = arr1[i];
            }
            i++;
        }

        // 处理arr2剩余元素
        while (j < n2) {
            if (k == 0 || temp[k - 1] != arr2[j]) {
                temp[k++] = arr2[j];
            }
            j++;
        }

        return Arrays.copyOf(temp, k);
    }
}
