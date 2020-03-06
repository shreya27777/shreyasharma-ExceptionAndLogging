package org.example;

class HouseConstructionCost {
    private HouseType[] houseTypes = {HouseType.STANDARD, HouseType.ABOVE_STANDARD, HouseType.HIGH_STANDARDS,
            HouseType.FULLY_AUTOMATED};

    public double getCost(int choice, double area) throws Exception {
        if (choice < 4 && choice >= 0) {
            return houseTypes[choice].getCostPerSquareFeet() * area;
        } else {
            throw new Exception("Invalid Input");
        }
    }
}