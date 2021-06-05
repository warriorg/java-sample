package me.warriorg.basic;

public class IterationMethod {

    public static void main(String[] args) {

        // 热代码技术？
//        System.out.println(String.format(" 舍罕王给了这么多粒：%d",   IterationMethod.getNumberOfWheat(63)));

        int grid = 63;
        long start, end = 0;
        start = System.currentTimeMillis();
        System.out.println(String.format(" 舍罕王给了这么多粒：%d", IterationMethod.getNumberOfWheat(grid)));
        end = System.currentTimeMillis();
        System.out.println(String.format(" 耗时 %d 毫秒 ", (end - start)));

        // 归纳法
        start = System.currentTimeMillis();
        System.out.println(String.format(" 舍罕王给了这么多粒：%d", (long)(Math.pow(2, grid)) - 1));
        end = System.currentTimeMillis();
        System.out.println(String.format(" 耗时 %d 毫秒 ", (end - start)));



        // 递归
        Result result = new Result();
        System.out.println(IterationMethod.prove(grid, result));


    }


    /**
     * @Description: 算算舍罕王给了多少粒麦子
     * @param grid- 放到第几格
     * @return long- 麦粒的总数
     */

    public static long getNumberOfWheat(int grid) {

        long sum = 0;      // 麦粒总数
        long numberOfWheatInGrid = 0;  // 当前格子里麦粒的数量

        numberOfWheatInGrid = 1;  // 第一个格子里麦粒的数量
        sum += numberOfWheatInGrid;

        for (int i = 2; i <= grid; i ++) {
            numberOfWheatInGrid *= 2;   // 当前格子里麦粒的数量是前一格的 2 倍
            sum += numberOfWheatInGrid;   // 累计麦粒总数
        }

        return sum;

    }

    /**
     * @Description: 使用函数的递归（嵌套）调用，进行数学归纳法证明
     * @param k- 放到第几格，result- 保存当前格子的麦粒数和麦粒总数
     * @return boolean- 放到第 k 格时是否成立
     */

    public static boolean prove(int k, Result result) {


        // 证明 n = 1 时，命题是否成立
        if (k == 1) {
            if ((Math.pow(2, 1) - 1) == 1) {
                result.wheatNum = 1;
                result.wheatTotalNum = 1;
                System.out.println(String.format("当前格的麦粒数:[%d],目前为止麦粒的总数[%d]", result.wheatNum, result.wheatTotalNum));
                return true;
            } else return false;
        }
        // 如果 n = (k-1) 时命题成立，证明 n = k 时命题是否成立
        else {


            boolean proveOfPreviousOne = prove(k - 1, result);
            result.wheatNum *= 2;
            result.wheatTotalNum += result.wheatNum;
            boolean proveOfCurrentOne = false;
            if (result.wheatTotalNum == (Math.pow(2, k) - 1)) proveOfCurrentOne = true;
            System.out.println(String.format("当前格的麦粒数:[%d],目前为止麦粒的总数[%d]", result.wheatNum, result.wheatTotalNum));

            if (proveOfPreviousOne && proveOfCurrentOne) return true;
            else return false;

        }

    }
}


class Result {
    public long wheatNum = 0;  // 当前格的麦粒数
    public long wheatTotalNum = 0;  // 目前为止麦粒的总数
}






