package com.jjh.sky.loadBalance.random;

/**
 * Created by jiajianhong on 16/9/14.
 */
public class RandomDomain {

    private String name;

    private double weight;

    public RandomDomain(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "name:" + this.name + ",weight:" + this.weight;
    }
}
