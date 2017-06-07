package id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.service;

/**
 * Created by Dayinta-PC on 6/7/2017.
 */

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.PlayingFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.PopularFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.RatedFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.UpcominFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl306.daymovie.model.ResultResponds;


public class VolleySingleton {
    private static volatile VolleySingleton mInstance;
    private static PopularFragment mCtx;
    private static RatedFragment mCtx2;
    private static PlayingFragment mCtx3;
    private static UpcominFragment mCtx4;


    private RequestQueue mRequestQueue;

    /*private VolleySingleton(Context context)
    {
        if (mInstance != null)
        {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }*/

    private VolleySingleton(PopularFragment context) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    private VolleySingleton(RatedFragment context1) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx2 = context1;
        mRequestQueue = getRequestQueue();
    }

    private VolleySingleton(UpcominFragment context1) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx4 = context1;
        mRequestQueue = getRequestQueue();
    }

    private VolleySingleton(PlayingFragment context1) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx3 = context1;
        mRequestQueue = getRequestQueue();
    }

    public static VolleySingleton getInstance(PopularFragment context) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context);
            }
        }
        return mInstance;
    }

    public static VolleySingleton getInstance(RatedFragment context1) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context1);
            }
        }
        return mInstance;
    }

    public static VolleySingleton getInstance(UpcominFragment context1) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context1);
            }
        }
        return mInstance;
    }

    public static VolleySingleton getInstance(PlayingFragment context1) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context1);
            }
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getActivity());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(GsonGetRequest<ResultResponds> req) {
        getRequestQueue().add(req);
    }
}