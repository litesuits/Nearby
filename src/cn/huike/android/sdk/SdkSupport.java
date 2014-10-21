package cn.huike.android.sdk;

import com.litesuits.common.assist.Toastor;
import com.litesuits.http.LiteHttpClient;

/**
 * @author MaTianyu
 * @date 2014-10-19
 */
public interface SdkSupport {
    HuikeSdk           sdk               = HuikeSdk.getInstance();
    Toastor           toastor           = sdk.getToastor();
    LiteHttpClient    client            = sdk.getHttpClient();
}
