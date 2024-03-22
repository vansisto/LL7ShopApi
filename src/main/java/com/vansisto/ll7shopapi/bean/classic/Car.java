package com.vansisto.ll7shopapi.bean.classic;

public class Car {

    public static void main(String[] args) {
        Tank tank = new Tank();
        Mictocontroller mictocontroller = new Mictocontroller(tank);
        Dashboard dashboard = new Dashboard(mictocontroller);

        tank.setVolume(20);
        dashboard.showCurrentVolume();
    }
}
