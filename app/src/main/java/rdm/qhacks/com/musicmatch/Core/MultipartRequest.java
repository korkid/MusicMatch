package rdm.qhacks.com.musicmatch.Core;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MultipartRequest extends Request<String> {

    private MultipartEntity entity = new MultipartEntity();
    private static final String FILE_PART_NAME = "file";
    private final Response.Listener<String> mListener;
    private final File mFilePart;
    private  String mStringPart,accessToken;

    public MultipartRequest(String url, Response.ErrorListener errorListener, Response.Listener<String> listener, File file,String accessToken)
    {
        super(Method.POST, url, errorListener);

        mListener = listener;
        mFilePart = file;
        this.accessToken = accessToken;
        buildMultipartEntity();
    }

    private void buildMultipartEntity()
    {
        entity.addPart(FILE_PART_NAME, new FileBody(mFilePart));
        try
        {
            entity.addPart("Content-Disposition", new StringBody("form-data"));
            entity.addPart("dir_path", new StringBody("IzEzOjE3"));
        }
        catch (UnsupportedEncodingException e)
        {
            VolleyLog.e("UnsupportedEncodingException");
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();

        if (headers == null
                || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }

        headers.put("Content-Type", "multipart/form-data");
        headers.put("_pkta",accessToken);


        return headers;
    }
    @Override
    public String getBodyContentType() {
        return entity.getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try
        {
            entity.writeTo(bos);
        }
        catch (IOException e)
        {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        return Response.success("Uploaded", getCacheEntry());
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }
}
