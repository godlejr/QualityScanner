package hcc.material.qualityscanner.ui.base.presenter;

import hcc.material.qualityscanner.ui.base.view.BaseView;

public class BasePresenterImpl<V extends BaseView>  implements  BasePresenter<V> {

    private V mBaseView;

    public BasePresenterImpl() {
    }

    @Override
    public void onAttach(V baseView) {
        mBaseView = baseView;
    }

    @Override
    public void init() {

    }

    public V getBaseView() {
        return mBaseView;
    }

}
