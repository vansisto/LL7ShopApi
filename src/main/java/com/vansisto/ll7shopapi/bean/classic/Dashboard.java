package com.vansisto.ll7shopapi.bean.classic;

public class Dashboard {
    private Mictocontroller mictocontroller;
    public Dashboard(Mictocontroller mictocontroller) {
        this.mictocontroller = mictocontroller;
    }

    public void showCurrentVolume() {
        System.out.println(mictocontroller.getTankVolume());
    }
}
