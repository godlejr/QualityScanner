package hcc.material.qualityscanner.ui.scanner.activity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hcc.material.qualityscanner.R;
import hcc.material.qualityscanner.ui.base.activity.BaseActivity;
import hcc.material.qualityscanner.ui.scanner.presenter.ScannerPresenter;
import hcc.material.qualityscanner.ui.scanner.presenter.ScannerPresenterImpl;
import hcc.material.qualityscanner.ui.scanner.view.ScannerView;

public class ScannerActivity extends BaseActivity implements ScannerView {

    private IncludedToolbarLayout includedToolbarLayout;
    private CaptureManager captureManager;
    private ScannerPresenter mPresenter;
    private Bundle mSavedInstanceState;

    @BindView(R.id.zxing_barcode_scanner)
    DecoratedBarcodeView barcodeScannerView;

    @BindView(R.id.in_activityscanner_toolbar)
    View mToolbar;

    @BindView(R.id.tv_activityscanner_intro)
    TextView mIntroMessage;

    @BindColor(R.color.scannerColor)
    int mScannerColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        ButterKnife.bind(this);

        this.mPresenter = new ScannerPresenterImpl();
        this.mPresenter.onAttach(this);

        this.mSavedInstanceState = savedInstanceState;

        init();
    }

    @Override
    protected void init() {
        this.mPresenter.init();
    }

    @Override
    public void showToolbarTitle(String message) {
        includedToolbarLayout.mToolbarTitle.setText(message);
    }

    @Override
    public void showIntroMessage(String message) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(message);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(mScannerColor), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mIntroMessage.setText(spannableStringBuilder);
    }

    @Override
    public void setToolbarLayout() {
        includedToolbarLayout = new IncludedToolbarLayout();
        ButterKnife.bind(includedToolbarLayout, mToolbar );
    }


    @Override
    public void setCaptureManager() {
        captureManager = new CaptureManager(this, barcodeScannerView);
        captureManager.initializeFromIntent(getIntent(), mSavedInstanceState);
        captureManager.decode();
    }

    @Override
    @OnClick(R.id.ib_toolbarmainback_back)
    public void onClickBack() {
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        captureManager.onSaveInstanceState(outState);
    }


    static class IncludedToolbarLayout {
        @BindView(R.id.ib_toolbarmainback_back)
        ImageButton mToolbarBackBtn;

        @BindView(R.id.tv_toolbarmainback_title)
        TextView mToolbarTitle;

    }
}
