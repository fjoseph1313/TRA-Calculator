package com.utopia.tracalculator.Model;

/**
 * Created by fjoseph1313 on 12/19/2016.
 */

public class Depreciation {

    private int age;
    private int rate;

    public Depreciation(int age, int rate) {
        this.age = age;
        this.rate = rate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
