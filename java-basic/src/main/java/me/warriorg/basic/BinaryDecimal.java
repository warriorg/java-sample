package me.warriorg.basic;

import java.math.BigInteger;

public class BinaryDecimal {
    /**

     * @Description: 十进制转换成二进制
     * @param decimalSource
     * @return String
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource)); // 转换成 BigInteger 类型，默认是十进制
        return bi.toString(2); // 参数 2 指定的是转化成二进制
    }

    /**
     * @Description: 二进制转换成十进制
     * @param binarySource
     * @return int
     */
    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);  // 转换为 BigInteger 类型，参数 2 指定的是二进制
        return Integer.parseInt(bi.toString());     // 默认转换成十进制
    }

    /**
     * @Description: 向左移位
     * @param num- 等待移位的十进制数, m- 向左移的位数
     * @return int- 移位后的十进制数
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * @Description: 向右移位
     * @param num- 等待移位的十进制数, m- 向右移的位数
     * @return int- 移位后的十进制数
     */
    public static int rightShift(int num, int m) {
        return num >>> m;
    }


    /**
     * @Description: 二进制按位“或”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“或”的结果
     */
    public static int or(int num1, int num2) {

        return (num1 | num2);

    }

    /**
     * @Description: 二进制按位“与”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“与”的结果
     */
    public static int and(int num1, int num2) {

        return (num1 & num2);

    }

    /**

     * @Description: 二进制按位“异或”的操作
     * @param num1- 第一个数字，num2- 第二个数字
     * @return 二进制按位“异或”的结果
     */

    public static int xor(int num1, int num2) {

        return (num1 ^ num2);

    }


    public static void main(String[] args) {

        int a = 53;
        String binary = "110101";
        System.out.println(String.format(" 数字 %d 的二进制是 %s", a, BinaryDecimal.decimalToBinary(a))); // 获取十进制数 53 的二进制数
        System.out.println(String.format(" 数字 %s 的十进制是 %d", binary, BinaryDecimal.binaryToDecimal(binary))); // 获取二进制数 110101 的十进制数


        int num = 53;
        int m = 1;
        System.out.println(String.format(" 数字 %d 的二进制向左移 %d 位是 %d", num, m, BinaryDecimal.leftShift(num, m)));   // 测试向左移位
        System.out.println(String.format(" 数字 %d 的二进制向右移 %d 位是 %d", num, m, BinaryDecimal.rightShift(num, m)));   // 测试向右移位

        System.out.println();

        m = 3;
        System.out.println(String.format(" 数字 %d 的二进制向左移 %d 位是 %d", num, m, BinaryDecimal.leftShift(num, m)));   // 测试向左移位
        System.out.println(String.format(" 数字 %d 的二进制向右移 %d 位是 %d", num, m, BinaryDecimal.rightShift(num, m)));   // 测试向右移位

        a = 53;
        int b = 35;

        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘或’结果是 %d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), BinaryDecimal.or(a, b), decimalToBinary(BinaryDecimal.or(a, b)))); // 获取十进制数 53 和 35 的按位“或”

        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘与’结果是 %d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), BinaryDecimal.and(a, b), decimalToBinary(BinaryDecimal.and(a, b))));  // 获取十进制数 53 和 35 的按位“与”

        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘异或’结果是 %d(%s)",
                a, decimalToBinary(a), a, decimalToBinary(a), BinaryDecimal.xor(a, a), decimalToBinary(BinaryDecimal.xor(a, a))));  // 获取十进制数 53 和 35 的按位“异或”


    }

    /**
     * @Title: decimalToBinary
     * @Description: 十进制转二进制，方法1：余数短除法除以二
     * @param decimalSource
     * @return: String
     */
    public static String decimalToBinary2(int decimalSource) {
        StringBuilder sb = new StringBuilder();
        while (decimalSource != 0) {
            sb.append(decimalSource % 2);
            decimalSource = decimalSource >> 1;
        }
        return sb.reverse().toString();
    }

    /**
     * @param decimalSource
     * @Title: decimalToBinary
     * @Description: 十进制转二进制，方法2：降二次幂及减法混合运算
     * @return: String
     */
    public static String decimalToBinary3(int decimalSource) {
        int length = (int) (Math.log(decimalSource) / Math.log(2));
        StringBuffer sb = new StringBuffer();
        do {
            decimalSource = (int) (decimalSource - Math.pow(2, length));
            int power = decimalSource <= 0 ? -1 : (int) (Math.log(decimalSource) / Math.log(2));
            for (int i = length; i > power; i--) {
                if (i == length) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            length = power;
        } while (decimalSource > 0);
        return sb.toString();
    }
    /**
     *
     * @Title: decimalToBinary
     * @Description: 十进制转二进制，方法3：位运算法
     * @param decimalSource
     * @return
     * @return: String
     */
    public static String decimalToBinary4(int decimalSource) {
        StringBuffer sb = new StringBuffer();
        while (decimalSource != 0) {
            //此&运算，decimalSource & 1，目的是获取最低位的二进制数值
            sb.append(decimalSource & 1);
            //此>>运算，decimalSource >> 1，目的是将获取到的最低位二进制数值除去
            decimalSource = decimalSource >> 1;
        }
        return sb.reverse().toString();
    }


//    负整数转换为二进制 要点：
//    取反加一 解释：将该负整数对应的正整数先转换成二进制，然后对其“取补”，再对取补后的结果加1即可。
//    例如要把-52换算成二进制：
//            1.先取得52的二进制：00110100
//            2.对所得到的二进制数取反：11001011
//            3.将取反后的数值加一即可：11001100 即：(-52)10=(11001100)2

}






