package hcc.material.qualityscanner.repository.remote.async;


import hcc.material.qualityscanner.entity.VisitScan;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 유저 관련 레파지토리 레이어 인터페이스
 * <p>
 * 유저 관련 api url 함수 정보
 */
public interface VisitScanRepository {

    @GET("login.json")
    Call<VisitScan> getUserByIdAndPassword(@Query("loginId") String loginId, @Query("loginPw") String loginPw);

}
