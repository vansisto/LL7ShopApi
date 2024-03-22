package com.vansisto.ll7shopapi.bean.context;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Context {

    private static Context context;
    private Context() {}

    private Microcontroller microcontroller = new Microcontroller();
    private Dasboard dasboard = new Dasboard();
    private Tank tank = new Tank();

    public static Context getContext() {
        if (Objects.isNull(context)) {
            context = new Context();
        }
        return context;
    }

}
