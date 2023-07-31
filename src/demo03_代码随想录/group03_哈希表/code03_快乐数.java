package demo03_代码随想录.group03_哈希表;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/happy-number/
 */
public class code03_快乐数 {
    public boolean isHappy(int n) {
        /*
            只可能存在两种情况：
            1. 符合快乐数要求，fastNum = 1
            2. 陷入一个环中不断循环
         */
        int slowNum = n;
        int fastNum = getNext(n);
        while (fastNum != 1 && slowNum != fastNum) {
            slowNum = getNext(slowNum);
            fastNum = getNext(getNext(fastNum));
        }
        return fastNum == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }
}
