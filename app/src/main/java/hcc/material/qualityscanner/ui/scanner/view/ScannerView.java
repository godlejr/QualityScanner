package hcc.material.qualityscanner.ui.scanner.view;

import hcc.material.qualityscanner.ui.base.view.BaseView;

public interface ScannerView extends BaseView {
    void showToolbarTitle(String message);
    void showIntroMessage(String message);
    void setToolbarLayout();
    void setCaptureManager();
    void onClickBack();

}
