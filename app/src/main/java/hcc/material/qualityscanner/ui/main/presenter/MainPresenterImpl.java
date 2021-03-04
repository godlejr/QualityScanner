package hcc.material.qualityscanner.ui.main.presenter;

import android.util.Log;

import hcc.material.qualityscanner.ui.base.presenter.BasePresenter;
import hcc.material.qualityscanner.ui.base.presenter.BasePresenterImpl;
import hcc.material.qualityscanner.ui.main.view.MainView;

public class MainPresenterImpl<V extends MainView> extends BasePresenterImpl<V> implements  MainPresenter<V> {


    public MainPresenterImpl() {
    }

    @Override
    public void init() {
        getBaseView().setScannerUp();
    }

    @Override
    public void onScannerInitialized() {

    }
}
