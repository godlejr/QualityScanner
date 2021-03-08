package hcc.material.qualityscanner.ui.main.interactor;

import hcc.material.qualityscanner.common.utils.HttpErrorUtil;
import hcc.material.qualityscanner.entity.VisitScan;
import hcc.material.qualityscanner.ui.base.interactor.BaseInteractorImpl;
import hcc.material.qualityscanner.ui.main.presenter.MainPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractorImpl<V extends MainPresenter> extends BaseInteractorImpl<V> implements MainInteractor<V> {
    public MainInteractorImpl() {
    }

    @Override
    public void onAttach(V basePresenter) {
        super.onAttach(basePresenter);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void getVisitMassageFromVMS(String MainId, String MainPw) {
        Call<VisitScan> call = getVisitScanRepository().getUserByIdAndPassword(MainId, MainPw);
        call.enqueue(new Callback<VisitScan>() {
            @Override
            public void onResponse(Call<VisitScan> call, Response<VisitScan> response) {
                if (response.isSuccessful()) {
                    VisitScan vsitScan = response.body();
                    getBasePresenter().onGetVisitMassageFromVMS(vsitScan);
                } else {
                    getBasePresenter().onHttpError(new HttpErrorUtil().responseHandler(response));
                }
            }

            @Override
            public void onFailure(Call<VisitScan> call, Throwable t) {
                showThrowableLog(t);
                getBasePresenter().onHttpError(null);
            }
        });
    }
}
