package rdm.qhacks.com.musicmatch.View;

import android.view.View;

import java.util.HashMap;

/**
 * This class is the parent class to all views in the app
 */
public abstract class ParentView {

    protected GraphicsDisplayer gd;
    protected HashMap<String, View> activityViews = new HashMap<>();
    abstract protected void setupLayout();
    public HashMap<String, View> getAllActivityViews(){return activityViews;}
    public View getView(String viewName){return activityViews.get(viewName);}
}
