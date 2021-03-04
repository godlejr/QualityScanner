package hcc.material.qualityscanner.ui.base.presenter;

import hcc.material.qualityscanner.ui.base.view.BaseView;

public interface BasePresenter<V extends BaseView> {

    public void onAttach(V baseView);

    public void init();

}
