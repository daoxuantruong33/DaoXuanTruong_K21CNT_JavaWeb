package com.k21cnt.dxt.lesson01.pkg_defaultmethod;

public class DemoDM implements Shape {
    @Override
    public void draw() {
        System.out.println("Vẽ hình từ DemoDM");
    }
    public static void main(String[] args) {
        DemoDM dm = new DemoDM();
        dm.draw();
        dm.setColor("Red");
    }
}
