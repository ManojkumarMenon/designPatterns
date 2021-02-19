package com.manoj.practice.solid;

public class LiskovSubstitutionPrincple {

    public static void main(String[] args) {

        RectangleWithoutSolid rectangle = new RectangleWithoutSolid();
        rectangle.setBreadth(5);
        rectangle.setLength(4);
        RectangleWithoutSolid square = new SquareWithoutSolid(4, 4);
        System.out.println(rectangle.area());

        System.out.println(square.area());

    }

    public static boolean testArea(RectangleWithoutSolid r) {
        return 5 * 4 == r.getLength() * r.getBreadth();
    }

}

class RectangleWithoutSolid {
    private int length;
    private int breadth;

    RectangleWithoutSolid() {

    }

    RectangleWithoutSolid(int l, int b) {
        this.length = l;
        this.breadth = b;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int area() {
        return this.length * this.breadth;
    }
}

class SquareWithoutSolid extends RectangleWithoutSolid {

    SquareWithoutSolid() {

    }

    SquareWithoutSolid(int l, int b) {
        this.setLength(l);
        this.setBreadth(b);
    }

    @Override
    public int area() {
        return this.getLength() * this.getBreadth();
    }
}

class RectangleWithSolid {
    private int length;
    private int breadth;
    private AreaCalculator cal;

    RectangleWithSolid() {

    }

    RectangleWithSolid(int l, int b) {
        this.length = l;
        this.breadth = b;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int area() {
        return cal.area(length, breadth);
    }
}

class SquareWithSolid {
    private int side;
    private AreaCalculator cal;

    SquareWithSolid() {

    }

    SquareWithSolid(int side) {
        this.side = side;
    }

    public int area() {
        return cal.area(side, side);
    }
}

class AreaCalculator {

    public int area(int length, int breadth) {
        return length * breadth;
    }
}