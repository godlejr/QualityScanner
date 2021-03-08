package hcc.material.qualityscanner.ui.main.interactor;

import hcc.material.qualityscanner.ui.base.interactor.BaseInteractor;
import hcc.material.qualityscanner.ui.main.presenter.MainPresenter;

public interface MainInteractor<V extends MainPresenter> extends BaseInteractor<V> {


    void getVisitMassageFromVMS(String MainId, String MainPw);
}
