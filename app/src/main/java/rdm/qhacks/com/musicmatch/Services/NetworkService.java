package rdm.qhacks.com.musicmatch.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @Service This service handles all network conenctions made by app, starts on app boot load complete
 */
public class NetworkService extends Service {

    private static final String TAG = NetworkService.class.getSimpleName();
    private static NetworkService NSInstance;
    private RequestQueue requestQueue;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        NSInstance = this;
    }

    public NetworkService() {
        NSInstance = this;
    }

    public static synchronized NetworkService getNSInstance(){
        return NSInstance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <Type> void addToRequestQueue(Request<Type> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <Type> void addToRequestQueue(Request<Type> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }
}
