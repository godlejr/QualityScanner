package hcc.material.qualityscanner.ui.scanner.presenter;

import hcc.material.qualityscanner.ui.base.presenter.BasePresenterImpl;
import hcc.material.qualityscanner.ui.scanner.view.ScannerView;

public class ScannerPresenterImpl<V extends ScannerView>  extends BasePresenterImpl<V> implements ScannerPresenter<V> {

    public ScannerPresenterImpl() {
    }


    @Override
    public void init() {
        //툴바 셋팅
        getBaseView().setToolbarLayout();
        getBaseView().showToolbarTitle("QR 코드 스캔");

        //intro 내용
        getBaseView().showIntroMessage("QR Code를 스캔해 주세요.");

        //캡처 설정
        getBaseView().setCaptureManager();
    }
}
