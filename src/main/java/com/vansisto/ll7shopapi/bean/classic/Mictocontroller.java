package com.vansisto.ll7shopapi.bean.classic;

public class Mictocontroller {

    private Tank tank;

    public Mictocontroller(Tank tank) {
        this.tank = tank;
    }

    public double getTankVolume() {
        return tank.getVolume();
    }
}
