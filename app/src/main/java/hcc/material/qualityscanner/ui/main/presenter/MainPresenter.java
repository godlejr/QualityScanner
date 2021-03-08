package hcc.material.qualityscanner.ui.main.presenter;

import hcc.material.qualityscanner.entity.VisitScan;
import hcc.material.qualityscanner.ui.base.presenter.BasePresenter;
import hcc.material.qualityscanner.ui.main.view.MainView;

public interface MainPresenter<V extends MainView> extends BasePresenter<V> {
    void onScannerInitialized();

    void onScanQRcod(String url);

    void onGetVisitMassageFromVMS(VisitScan vsitScan);
}
