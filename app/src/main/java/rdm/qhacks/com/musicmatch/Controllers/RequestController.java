package rdm.qhacks.com.musicmatch.Controllers;


import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import java.util.UUID;

import rdm.qhacks.com.musicmatch.Controllers.CallBack.JSONCallBack;
import rdm.qhacks.com.musicmatch.Controllers.CallBack.StringCallBack;
import rdm.qhacks.com.musicmatch.Services.NetworkService;

/**
 * @Singleton RequestController : Handles all HTTP requests made by the app
 */
public class RequestController extends BaseController {
    public static RequestController requestControllerIntance = new RequestController();

    /** Constructor is private to prevent creating multiple Request handlers throughout the program */
    private RequestController(){}

    /**
     * @Method newGetRequest : Creates and stores a string get request
     * @param endPoint : String  url of where to fetch the request
     * @param  stringCallBack : : callback function that gets executed when the response is returned
     */
    public synchronized String newStringGetRequest(final String endPoint, final StringCallBack stringCallBack) {
        final String identifier = UUID.randomUUID().toString(); //generate random UUID that represents tag for request
        StringRequest stringRequest = new StringRequest(Request.Method.GET, endPoint,
                stringCallBack::OnSuccess,
                Throwable::printStackTrace);
        NetworkService.getNSInstance().addToRequestQueue(stringRequest,identifier);
        return identifier;
    }

    /**
     * @Method newGetRequest : Creates and stores a JSON get request
     * @param endPoint : String  url of where to fetch the request
     * @param jsonCallBack : callback function that gets executed when the response is returned
     */
    public synchronized String newJSONGetRequest(final String endPoint, final JSONCallBack jsonCallBack){
        final String identifier = UUID.randomUUID().toString(); //generate random UUID that represents tag for request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, endPoint, null,
                jsonCallBack::OnSuccess,
                Throwable::printStackTrace);
        NetworkService.getNSInstance().addToRequestQueue(jsonObjectRequest, identifier);
        return identifier;
    }

    /**
     * @Method cancelRequestByIdentifier : cancels a request by a given identifier
     * @param identifier : String identifier
     */
    public void cancelRequestByIdentifier(String identifier){
        NetworkService.getNSInstance().cancelPendingRequests(identifier);
    }

    /**
     * @Method getInstance : Provides access to the instance
     * @return RequestController
     */
    public static RequestController getInstance(){return requestControllerIntance;}
}