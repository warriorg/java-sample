package me.warriorg.hanlp;

import com.hankcs.hanlp.HanLP;

public class DemoTraditionalChinese2SimplifiedChinese {
    public static void main(String[] args) {
        int i = 10000;
        long start = System.currentTimeMillis();
        while (i > 0) {
            i--;
//            System.out.println(HanLP.convertToTraditionalChinese("用笔记本电脑写程序"));
            System.out.println(HanLP.convertToSimplifiedChinese("「以後等妳1-23423我们的国家&（88當上皇后，就能買士多啤梨慶祝了」"));
            System.out.println(HanLP.convertToSimplifiedChinese("尋陽江頭夜送客，楓葉荻花秋瑟瑟。 主人下馬客在船，舉酒欲飲無管弦。主人下馬客在船，舉酒欲飲無管弦。 醉不成歡慘將別，別時茫茫江浸月。醉不成歡慘將別，別時茫茫江浸月。 忽聞水上"));
            System.out.println(HanLP.convertToSimplifiedChinese("中國，是個具有五千年歷史古國，當然，中國的文字也是老祖先們遺留給我們的，繁體字對於中國是很重要的， 一個繁體字都是一篇故事，所以一定要學繁體字"));
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
