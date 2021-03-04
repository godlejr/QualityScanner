package hcc.material.qualityscanner.ui.main.presenter;

import hcc.material.qualityscanner.ui.base.presenter.BasePresenter;
import hcc.material.qualityscanner.ui.main.view.MainView;

public interface MainPresenter<V extends MainView> extends BasePresenter<V> {
    void onScannerInitialized();
}
