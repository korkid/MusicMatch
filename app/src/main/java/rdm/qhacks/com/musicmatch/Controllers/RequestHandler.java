package rdm.qhacks.com.musicmatch.Controllers;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Singleton RequestHandler : Handles all HTTP requests made by the app
 */
public class RequestHandler extends BaseController {

    private static final RequestHandler requestInstance = new RequestHandler();

    private Context activityContext;
    private RequestQueue queue;

    private ConcurrentHashMap<String, String> storedResponse = new ConcurrentHashMap<>();

    /** Constructor is private to prevent creating multiple Request handlers throughout the program */
    private RequestHandler(){}

    /**
     * @Method initData : resets the Context of the requestInstance and resets the Request Queue
     * @param activityContext : Context of the Activity
     */
    public void initData(Context activityContext){
        RequestHandler.requestInstance.activityContext = activityContext;
        RequestHandler.requestInstance.queue = Volley.newRequestQueue(this.activityContext);
    }

    /**
     * @Method newGetRequest : Creates and stores a simple get request
     * @param pageUrl : String  url of where to fetch the request
     */
    public void newGetRequest(String pageUrl, final String identifier){
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, pageUrl,
                response -> {
                    storedResponse.put(identifier, response);
                }, error -> Log.d("Error", error.toString()));
        RequestHandler.requestInstance.queue.add(stringRequest);
    }

    /**
     * @Method addToRequestQueue : Provides functionality for creating other Requests and adding it to the queue
     * @param request : Request
     */
    public void addToRequestQueue(Request request){
        RequestHandler.requestInstance.queue.add(request);
    }

    /**
     * @Method getInstance : Provides access to the instance
     * @return RequestHandler
     */
    public static RequestHandler getInstance(){return requestInstance;}

    /**
     * @Method getStoredResponse : get response of specified reponse
     * @return String : response as a string
     */
    public String getStoredResponse(String responseID){return this.storedResponse.get(responseID);}
}