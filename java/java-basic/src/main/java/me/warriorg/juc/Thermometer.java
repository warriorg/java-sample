package me.warriorg.juc;

import java.text.NumberFormat;

public class Thermometer {
    private static ThreadLocal<NumberFormat> nfLocal = new ThreadLocal<>();


    public NumberFormat initialValue() {
        NumberFormat nf=NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(2);
        return nf;
    }

    @Override
    public String toString() {
        NumberFormat nf= nfLocal.get();
        return nf.format(222);
    }

}
