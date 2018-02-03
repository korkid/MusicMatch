package rdm.qhacks.com.musicmatch.View;

import android.view.View;

import java.util.List;

/**
 * This class is the parent class to all views in the app
 */
public abstract class ParentView {

    protected  GraphicsDisplayer gd;

    abstract public void setupLayout();

    abstract public List<View> getAllActivityViews();
}
