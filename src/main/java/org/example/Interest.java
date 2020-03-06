package org.example;

class Interest {
    private double principal;
    private double rate;
    private double years;

    Interest(double principal, double rate, double years) {
        this.principal = principal;
        this.rate = rate;
        this.years = years;
    }

    double getSimpleInterest() {
        return principal * rate * years / 100;
    }

    double getCompoundInterest() {
        return principal * Math.pow((1 + rate / 100), years) - principal;
    }
}
