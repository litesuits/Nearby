package cn.huike.android.sdk;

import android.content.Context;
import cn.huike.android.model.Theme;
import com.litesuits.android.async.AsyncTask;
import com.litesuits.common.assist.Toastor;
import com.litesuits.common.data.DataKeeper;
import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.async.HttpAsyncExecutor;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBase;

/**
 * @author MaTianyu
 */
public class HuikeSdk {
    private static HuikeSdk ourInstance = new HuikeSdk();
    /**
     * 全局context
     */
    private Context           context;
    /**
     * 简单数据存储器：存到文件中
     */
    private DataKeeper        dataKeeper;
    /**
     * 文本轻量级提示
     */
    private Toastor           toastor;
    /**
     * 发起http请求
     */
    private LiteHttpClient    httpClient;
    /**
     * 异步线程执行器
     */
    private HttpAsyncExecutor asyncExecutor;
    /**
     * 数据库存储器
     */
    private DataBase          dataBase;
    /**
     * 主题，为扩展主题做准备
     */
    private Theme             theme;

    public static HuikeSdk getInstance() {
        return ourInstance;
    }

    private HuikeSdk() { }

    public void initilize(Context context) {
        this.context = context = context.getApplicationContext();
        // 持久化少量数据，如配置信息
        dataKeeper = new DataKeeper(context, "huike_data");
        // 轻量级文本提示
        toastor = new Toastor(context);
        // HTTP client
        httpClient = LiteHttpClient.newApacheHttpClient(context);
        // 异步与并发，和AsyncTask公用一个线程池以节约资源
        asyncExecutor = HttpAsyncExecutor.newInstance(httpClient, AsyncTask.mCachedSerialExecutor);
        // 数据库操作
        dataBase = LiteOrm.newInstance(context, "huike.db");
        // 主题设置
        theme = new Theme(Theme.WHITE);
    }

    public Context getContext() {
        return context;
    }

    public DataKeeper getDataKeeper() {
        return dataKeeper;
    }

    public Toastor getToastor() {
        return toastor;
    }

    public LiteHttpClient getHttpClient() {
        return httpClient;
    }

    public HttpAsyncExecutor getAsyncExecutor() {
        return asyncExecutor;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public Theme getTheme() {
        return theme;
    }
}
