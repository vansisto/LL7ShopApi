package com.vansisto.ll7shopapi.bean.context;

public class Car {

    public static void main(String[] args) {
        Context context = Context.getContext();

        Tank tank = Context.getContext().getTank();
        tank.setVolume(20);

        Dasboard dasboard = context.getDasboard();
        dasboard.showCurrentTankVolume();
    }
}
