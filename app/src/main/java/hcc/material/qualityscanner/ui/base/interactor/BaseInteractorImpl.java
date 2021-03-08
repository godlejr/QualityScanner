package hcc.material.qualityscanner.ui.base.interactor;

import android.content.Context;
import android.util.Log;

import hcc.material.qualityscanner.repository.remote.async.VisitScanRepository;
import hcc.material.qualityscanner.repository.remote.interceptor.HttpInterceptor;
import hcc.material.qualityscanner.ui.base.presenter.BasePresenter;

public class BaseInteractorImpl<V extends BasePresenter> implements BaseInteractor<V> {
    private V mBasePresenter;

    //Reposiltory
    private VisitScanRepository mVisitScanRepository;


    private Context mContext;

    public BaseInteractorImpl() {

    }


    @Override
    public void onAttach(V basePresenter) {
        this.mBasePresenter = basePresenter;
        this.mContext = mBasePresenter.getContext();
    }

    @Override
    public void init() {

    }

    @Override
    public void showThrowableLog(Throwable throwable) {
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        String className = stackTraceElements[0].getClassName();
        String methodName = stackTraceElements[0].getMethodName();
        int lineNumber = stackTraceElements[0].getLineNumber();
        String fileName = stackTraceElements[0].getFileName();

        Log.e("Exception 발생 :: ", throwable.getMessage());
        Log.e("Exception 정보 :: ", className + "." + methodName + " " + fileName + " " + lineNumber + " " + "번째 line");

    }

    /**
     * repository getter/setter
     *
     * @Author 김동주 사원
     */

    @Override
    public void setVisitScanRepository(String Url) {
        this.mVisitScanRepository = new HttpInterceptor(this.mContext).getRetrofitForVisitScanRepository(Url).create(VisitScanRepository.class);
    }
    @Override
    public VisitScanRepository getVisitScanRepository() {
        return this.mVisitScanRepository;
    }

    @Override
    public void clearVisitScanRepository() {
        if (mVisitScanRepository != null) {
            mVisitScanRepository = null;
        }
    }

    public V getBasePresenter() {
        return this.mBasePresenter;
    }


}
