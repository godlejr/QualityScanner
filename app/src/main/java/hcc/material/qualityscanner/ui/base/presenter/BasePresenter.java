package hcc.material.qualityscanner.ui.base.presenter;

import android.content.Context;

import hcc.material.qualityscanner.dto.HttpErrorDto;
import hcc.material.qualityscanner.ui.base.view.BaseView;

public interface BasePresenter<V extends BaseView> {

    public void onAttach(V baseView);

    public void init();

    public void onHttpError(HttpErrorDto httpErrorDto);

    public Context getContext();
}
