package cn.huike.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import cn.huike.android.model.Theme;
import cn.huike.android.sdk.SdkSupport;

/**
 * @author matianyu
 */
public abstract class BaseSupportActivity extends FragmentActivity implements SdkSupport {
    protected Activity activity;
    protected Handler handler = new Handler();
    //protected String  TAG     = getClass().getSimpleName();

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setAppTheme();
        super.onCreate(savedInstanceState);
        activity = this;
    }

    protected void onResume() {
        super.onResume();
    }


    protected void onPause() {
        super.onPause();
    }

    protected Theme getBongTheme() {
        return sdk.getTheme();
    }

    protected void setAppTheme() {
        if (getBongTheme().isWhite()) {
            setTheme(R.style.AppTheme_White);
        } else {
            setTheme(R.style.AppTheme_Black);
        }
    }

    public void delayDo(Runnable run, long delay) {
        handler.postDelayed(run, delay);
    }

    public void cancelDo(Runnable run) {
        handler.removeCallbacks(run);
    }

    public void doSomeThings() {}
}