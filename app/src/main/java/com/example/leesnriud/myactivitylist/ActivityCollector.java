package com.example.leesnriud.myactivitylist;

import android.app.Activity;

import java.util.LinkedList;

/**
 * Created by lee.snriud on 2018/3/12.
 */

public class ActivityCollector {

    public static LinkedList<Activity> activities = new LinkedList<Activity>();
    public static void addActivity(Activity activity)
    {
        activities.add(activity);
    }
    public static void removeActivity(Activity activity)
    {
        activities.remove(activity);
    }
    public static void finishAll()
    {
        for(Activity activity:activities)
        {
            if(!activity.isFinishing())
            {
                activity.finish();
            }
        }
    }
}