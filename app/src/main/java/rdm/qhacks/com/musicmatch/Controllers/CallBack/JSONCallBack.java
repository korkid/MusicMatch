package rdm.qhacks.com.musicmatch.Controllers.CallBack;


import org.json.JSONObject;

/**
 * This functional interface allows for the usage of Data call back driven requests
 */
public interface JSONCallBack extends  CallBack {
    void OnSuccess(JSONObject response);
}
