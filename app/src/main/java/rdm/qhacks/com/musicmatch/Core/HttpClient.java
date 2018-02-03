package rdm.qhacks.com.musicmatch.Core;


import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * This singleton handles all requests made by the app
 */
public class HttpClient {
    private static final HttpClient ourInstance = new HttpClient();

    public static HttpClient getInstance() {
        return ourInstance;
    }

    private HttpClient() {
    }

    public void postData(Context applicationContext, String title, String note, String imagePath, String imageDescription, final Listeners.APIPostDataListener listener) {
        //Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(applicationContext);
        Settings settings = new Settings(applicationContext);
        String selectedURL = settings.getChosenUrl();
        final String token = settings.getTokenKey();
        String url = "http://" + selectedURL + "/databox/api/v1/upload/files";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("Content-Disposition", "form-data");
        File file = new File(imagePath);

        try {
            MultipartRequest mr = new MultipartRequest(url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.d("response", response);
                }

            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Volley Request Error", error.getLocalizedMessage());
                }

            }, file, params) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Authorization", "Bearer " + token);
                    //params.put("Content-Type", "multipart/form-data");
                    return params;
                }
            };
            queue.add(mr);
        } catch (Exception exception) {
            Log.e("postData", exception.getMessage());
        }
    }
}
