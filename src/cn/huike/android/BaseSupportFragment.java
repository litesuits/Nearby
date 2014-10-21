package cn.huike.android;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;
import cn.huike.android.sdk.SdkSupport;

/**
 * @author MaTianyu
 * @date 14-7-21
 */
public abstract class BaseSupportFragment extends Fragment implements SdkSupport {
    protected Handler handler = new Handler();
    //protected String umengTag = getClass().getSimpleName();

    public void onResume() {
        super.onResume();
        //if (Log.isPrint) Log.i(umengTag, "umeng tag： " + umengTag);
    }

    public void onPause() {
        super.onPause();
    }

    protected View findViewById(int resId) {
        return getActivity().findViewById(resId);
    }

    public void doSomeThings() {}

    public void delayDo(Runnable run, long delay) {
        handler.postDelayed(run, delay);
    }
}
