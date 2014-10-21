package cn.huike.android.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import cn.huike.android.BaseTopbarActivity;
import cn.huike.android.R;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class HomeActivity extends BaseTopbarActivity implements View.OnClickListener {
    private RadioButton rbLeft, rbRight;
    private View           mainContainer;
    private ResideMenu     resideMenu;
    private ResideMenuItem itemCoupon;
    private ResideMenuItem itemCollect;
    private ResideMenuItem itemPsd;
    private ResideMenuItem itemLogout;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        setUpMenu();

        mainContainer = findViewById(R.id.mainContainer);
        rbLeft = (RadioButton) findViewById(R.id.rbNear);
        rbRight = (RadioButton) findViewById(R.id.rbFollow);
        rbLeft.setChecked(true);

        getIvLeft().setVisibility(View.VISIBLE);
        getIvLeft().setImageResource(R.drawable.ic_menu_list);
        getIvLeft().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        getIvRight().setVisibility(View.VISIBLE);
        getIvRight().setImageResource(R.drawable.ic_search);
        getIvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastor.showSingletonToast(R.string.search);
            }
        });

    }

    @Override
    public void onClick(View view) {

        if (view == itemCoupon) {
        } else if (view == itemCollect) {
        } else if (view == itemPsd) {
        } else if (view == itemLogout) {
        }

        resideMenu.closeMenu();
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.bkg);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.65f);

        // create menu items;
        itemCoupon = new ResideMenuItem(this, R.drawable.arrow_left, R.string.my_coupon);
        itemCollect = new ResideMenuItem(this, R.drawable.arrow_left, R.string.my_collect);
        itemPsd = new ResideMenuItem(this, R.drawable.arrow_left, R.string.my_psd);
        itemLogout = new ResideMenuItem(this, R.drawable.arrow_left, R.string.my_logout);

        itemCoupon.setOnClickListener(this);
        itemCollect.setOnClickListener(this);
        itemPsd.setOnClickListener(this);
        itemLogout.setOnClickListener(this);

        resideMenu.addMenuItem(itemCoupon, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemCollect, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPsd, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemLogout, ResideMenu.DIRECTION_LEFT);

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            toastor.showSingletonToast("open");
        }

        @Override
        public void closeMenu() {
            toastor.showSingletonToast("close");
        }
    };

    private void changeFragment(Fragment targetFragment) {
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu() {
        return resideMenu;
    }
}
