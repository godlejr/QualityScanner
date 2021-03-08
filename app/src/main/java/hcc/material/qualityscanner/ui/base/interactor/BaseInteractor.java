package hcc.material.qualityscanner.ui.base.interactor;


import hcc.material.qualityscanner.repository.remote.async.VisitScanRepository;
import hcc.material.qualityscanner.ui.base.presenter.BasePresenter;

public interface BaseInteractor<V extends BasePresenter> {
    public void onAttach(V basePresenter);

    public void init();

    public void showThrowableLog(Throwable throwable);

    public void setVisitScanRepository(String Url);

    public VisitScanRepository getVisitScanRepository();

    public void clearVisitScanRepository();

}
