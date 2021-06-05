package me.warriorg.basic;


/****
 * 1. 先对每个三位数的个、十和百位数，都加上一个较大的随机数。
 * 2. 然后将每位上的数都除以 7，用所得的余数代替原有的个、十、百位数；
 * 3. 最后将第一位和第三位交换。
 *
 * 假如说，我们要加密数字 625，根据刚才的规则，我们来试试。假设随机数我选择 590127。
 * 那百、十和个位分别加上这个随机数，就变成了 590133，590129，590132。
 * 然后，三位分别除以 7 求余后得到 5，1，4。最终，我们可以得到加密后的数字就是 415。
 * 因为加密的人知道加密的规则、求余所用的除数 7、除法的商、以及所引入的随机数 590127，
 * 所以当拿到 415 的时候，加密者就可以算出原始的数据是 625。是不是很有意思？
 */
public class EncryptionDecryptNum {
    private static final int MAX = 590127;
    private static final int MULTIPLE = 7;

    public static void main(String[] args) {
        int value = encryptionNum(625);
        System.out.println(String.format("625加密后的值为%d", value));
        int deValue = decryptNum(value);
        System.out.println(String.format("%d解密后的值为%d", value, deValue));
    }

    public static int encryptionNum(int num) {
        System.out.println("加密前：" + num);
        // 1.取余 并 加上随机数
        int bit = num % 10;
        int tenBit = num % 100 / 10;
        int hundredBit = num % 1000 / 100;
        System.out.println(bit + "\t" + tenBit + "\t" + hundredBit);
        bit = bit + MAX;
        tenBit = tenBit + MAX;
        hundredBit = hundredBit + MAX;
        System.out.println(bit + "\t" + tenBit + "\t" + hundredBit);
        // 2.每个位数 除以7 取余代替原来的个十百
        bit = bit % MULTIPLE;
        tenBit = tenBit % MULTIPLE;
        hundredBit = hundredBit % MULTIPLE;
        System.out.println(bit + "\t" + tenBit + "\t" + hundredBit);
        // 3.swap 第一位和第三位
        int temp;
        temp = bit;
        bit = hundredBit;
        hundredBit = temp;
        System.out.println(bit + "\t" + tenBit + "\t" + hundredBit);
        int result = bit + tenBit * 10 + hundredBit * 100;
        System.out.println("加密结果为：" + result);
        return result;
    }
    public static int decryptNum(int num) {
        System.out.println("解密前：" + num);
        // 1.取余
        int bit = num % 10;
        int tenBit = num % 100 / 10;
        int hundredBit = num % 1000 / 100;
        // 2.交互位数
        int temp;
        temp = bit;
        bit = hundredBit;
        hundredBit = temp;
        // 3.乘回7的倍数
        // 这里可能有bug 只能针对当前的MAX值 如果换了一个随机值 要考虑 是否要+1
        int temp2 = (MAX / MULTIPLE) + 1;
        bit = bit + temp2 * MULTIPLE;
        tenBit = tenBit + temp2 * MULTIPLE;
        hundredBit = hundredBit + temp2 * MULTIPLE;
        // 4.减去随机数
        bit = bit - MAX;
        tenBit = tenBit - MAX;
        hundredBit = hundredBit - MAX;
        System.out.println(bit + "\t" + tenBit + "\t" + hundredBit);
        int result = bit + tenBit * 10 + hundredBit * 100;
        System.out.println("解密结果为：" + result);
        return result;
    }
}
