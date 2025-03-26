package com.k21cnt.dxt.lesson01.pkg_defaultmethod;

public interface Shape {
    void draw();
    default void setColor(String color) {
        System.out.println("Vẽ hình với màu " + color);
    }
}
