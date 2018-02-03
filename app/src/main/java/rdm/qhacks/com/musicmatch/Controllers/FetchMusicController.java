package rdm.qhacks.com.musicmatch.Controllers;


import android.content.Context;

/**
 * This controller handles the request and recieving of music
 */
public class FetchMusicController extends BaseController {

    final private String WebRestEndpoint = "https://google.ca";
    final private String ResponseName = "Music Results";

    final private long requestWaitTimer = 500;

    public FetchMusicController(){}

    /**
     * This method sends the appropriate request containing all the data to the Azure ML endpoint for processing
     * @return
     */
    public String sendFetchAndGetResponse(Context context){
        RequestHandler.getInstance().initData(context);
        RequestHandler.getInstance().newGetRequest(this.WebRestEndpoint, ResponseName);
        try {
            boolean wait = true;
            while(wait){
                Thread.currentThread().sleep(requestWaitTimer); //Wait for request to process
                wait = RequestHandler.getInstance().getStoredResponse(ResponseName) == null;
            }

        } catch (InterruptedException | NullPointerException e) {
            e.printStackTrace();
        }
        return RequestHandler.getInstance().getStoredResponse(ResponseName);
    }
}
