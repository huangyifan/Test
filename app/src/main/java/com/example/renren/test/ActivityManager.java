package com.example.renren.test;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renren on 16/10/8.
 */
public class ActivityManager {

    private List<Activity> mActivities=new ArrayList<>();
    private static ActivityManager sInstance;

    private ActivityManager(){
    };

    public static ActivityManager instance() {
        if (sInstance==null){
            sInstance=new ActivityManager();
        }
        return sInstance;
    }

    public void registActivity(Activity activity) {
        mActivities.add(activity);
        Log.d("TAG","mActivities.size()="+mActivities.size());
    }

    public void unRigistActivity(Activity activity) {
        mActivities.remove(activity);
    }
}
