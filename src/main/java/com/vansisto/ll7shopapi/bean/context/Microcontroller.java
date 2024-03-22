package com.vansisto.ll7shopapi.bean.context;

public class Microcontroller {
    public double getTankVolume() {
        Tank tank = Context.getContext().getTank();
        return tank.getVolume();
    }
}
