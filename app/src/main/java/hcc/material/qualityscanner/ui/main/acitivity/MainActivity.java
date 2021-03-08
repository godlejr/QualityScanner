package hcc.material.qualityscanner.ui.main.acitivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hcc.material.qualityscanner.R;
import hcc.material.qualityscanner.ui.base.activity.BaseActivity;
import hcc.material.qualityscanner.ui.main.presenter.MainPresenter;
import hcc.material.qualityscanner.ui.main.presenter.MainPresenterImpl;
import hcc.material.qualityscanner.ui.main.view.MainView;
import hcc.material.qualityscanner.ui.scanner.activity.ScannerActivity;

public class MainActivity extends BaseActivity implements MainView  {

    private MainPresenter<MainView> mPresenter;

    private IntentIntegrator mIntentIntegrator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainPresenterImpl<MainView>();
        mPresenter.onAttach(this);

        init();
    }

    @Override
    public void setScannerUp() {
        mIntentIntegrator = new IntentIntegrator(this);
    }

    @Override
    @OnClick({R.id.ll_activitymain_scanner, R.id.tv_activitymain_scanner})
    public void onClickScannerBtn() {
        //일단 presenter로 안넘김
        mIntentIntegrator.setCaptureActivity(ScannerActivity.class).initiateScan();
    }


    @Override
    protected void init() {
        mPresenter.init();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
           if(resultCode == Activity.RESULT_OK) {
               IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
               String url = scanResult.getContents();


//               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//               startActivity(intent);
               this.mPresenter.onScanQRcod(url);


           }else{
                super.onActivityResult(requestCode, resultCode, data);
           }
    }                 
}
