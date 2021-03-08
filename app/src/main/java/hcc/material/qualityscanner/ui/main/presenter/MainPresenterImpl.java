package hcc.material.qualityscanner.ui.main.presenter;

import android.util.Log;

import hcc.material.qualityscanner.entity.VisitScan;
import hcc.material.qualityscanner.ui.base.presenter.BasePresenter;
import hcc.material.qualityscanner.ui.base.presenter.BasePresenterImpl;
import hcc.material.qualityscanner.ui.main.interactor.MainInteractor;
import hcc.material.qualityscanner.ui.main.interactor.MainInteractorImpl;
import hcc.material.qualityscanner.ui.main.view.MainView;

public class MainPresenterImpl<V extends MainView> extends BasePresenterImpl<V> implements  MainPresenter<V> {
    private MainInteractor mMainInteractor;


    public MainPresenterImpl() {
    }

    @Override
    public void init() {
        this.mMainInteractor = new MainInteractorImpl<MainPresenter>();
        this.mMainInteractor.onAttach(this);

        //repository setting
        getBaseView().setScannerUp();


    }

    @Override
    public void onScannerInitialized() {

    }

    @Override
    public void onScanQRcod(String url) {
        this.mMainInteractor.setVisitScanRepository(url);
    }

    @Override
    public void onGetVisitMassageFromVMS(VisitScan vsitScan) {
        getBaseView().showMessage(vsitScan.getMsg());
    }


}
