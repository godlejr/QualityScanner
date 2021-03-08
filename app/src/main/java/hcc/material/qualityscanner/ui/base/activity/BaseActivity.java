package hcc.material.qualityscanner.ui.base.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hcc.material.qualityscanner.R;
import hcc.material.qualityscanner.common.utils.ToastUtil;
import hcc.material.qualityscanner.ui.base.view.BaseView;

/**
 * BaseActivity
 *
 * @author 김동주
 * @since 2019.02.13
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected Context mContext;

    protected ToastUtil toastUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = BaseActivity.this;
        this.toastUtil = new ToastUtil(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void showMessage(String message) {
        toastUtil.showMessage(message);
    }

    protected abstract void init();

    @Override
    public Context getContext() {
        return this.mContext;
    }
}
