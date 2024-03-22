package com.vansisto.ll7shopapi.bean.context;

public class Dasboard {
    public void showCurrentTankVolume() {
        Microcontroller microcontroller = Context.getContext().getMicrocontroller();
        System.out.println(microcontroller.getTankVolume());
    }
}
