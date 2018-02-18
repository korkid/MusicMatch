package rdm.qhacks.com.musicmatch.View;

import android.content.Context;
import android.view.ViewGroup;

/**
 * This class is the parent class to all views in the app
 */
public abstract class ParentView {

    protected ViewGroup viewGroup;
    protected Context context;

    abstract public void setupLayout();
}
