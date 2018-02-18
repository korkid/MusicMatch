package rdm.qhacks.com.musicmatch.Controllers.CallBack;

/**
 * This functional interface allows for the usage of Data call back driven requests
 */
public interface StringCallBack extends CallBack {
    void OnSuccess(String response);
}
