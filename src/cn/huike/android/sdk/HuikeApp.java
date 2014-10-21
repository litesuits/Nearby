package cn.huike.android.sdk;

import android.app.Application;

/**
 * @author MaTianyu
 */
public class HuikeApp extends Application {
    private static HuikeApp app;
    private static HuikeSdk sdk;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        sdk = HuikeSdk.getInstance();
        sdk.initilize(this);
    }

    public static HuikeApp getApp() {
        return app;
    }

    public static HuikeSdk getSdk() {
        return sdk;
    }
}
