package cn.huike.android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public abstract class BaseTopbarActivity extends BaseSupportActivity {
    private ImageView mIvLeft, mIvRight;
    private TextView mTvTitle, mTvRight, mTvLeft;
    private View mLlHeader,radioGroup;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initHeader();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initHeader();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initHeader();
    }

    private void initHeader() {
        mLlHeader = findViewById(R.id.mLlHeader);
        if (mLlHeader != null) {
            radioGroup = findViewById(R.id.radioGroup);
            mIvLeft = (ImageView) findViewById(R.id.mIvLeft);
            mIvRight = (ImageView) findViewById(R.id.mIvRight);
            mTvTitle = (TextView) findViewById(R.id.mTvTitle);
            mTvRight = (TextView) findViewById(R.id.mTvRight);
            mTvLeft = (TextView) findViewById(R.id.mTvLeft);
            View.OnClickListener finishLis = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            };
            mIvLeft.setOnClickListener(finishLis);
            mTvLeft.setOnClickListener(finishLis);
        }
    }

    public ImageView getIvLeft() {
        return mIvLeft;
    }

    public TextView getTvLeft() {
        return mTvLeft;
    }

    public ImageView getIvRight() {
        return mIvRight;
    }

    public TextView getTvTitle() {
        return mTvTitle;
    }

    public TextView getTvRight() {
        return mTvRight;
    }

    public View getRadioGroup() {
        return radioGroup;
    }

    public void setAppTitle(int resId) {
        getTvTitle().setText(resId);
    }

    public View getHeader() {
        return mLlHeader;
    }
}
