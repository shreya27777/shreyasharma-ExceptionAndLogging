package org.example;

public enum HouseType {
    FULLY_AUTOMATED(2400), HIGH_STANDARDS(1800), ABOVE_STANDARD(1500), STANDARD(1200);

    private double costPerSquareFeet;

    HouseType(double costPerSquareFeet) {
        this.costPerSquareFeet = costPerSquareFeet;
    }

    public double getCostPerSquareFeet() {
        return costPerSquareFeet;
    }
}
