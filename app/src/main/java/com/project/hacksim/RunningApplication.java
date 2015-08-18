package com.project.hacksim;
import Data.*;
import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kerman on 22.4.2015.
 */
public class RunningApplication extends Application {

    Rigg r;
    ArrayList<Target> targets;
    Target[] targetList = {};
    Util util;
    Uporabnik usr;
    public static final String IME_DAT="igra.hack";
    @Override
    public void onCreate(){
        super.onCreate();
    }
    public String test;
}
