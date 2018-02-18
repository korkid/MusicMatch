package rdm.qhacks.com.musicmatch.View;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This class is the parent class to all views in the app
 */
public abstract class ParentView {

    protected ViewGroup viewGroup;
    protected Context context;

    abstract public void setupLayout();

    public <ViewObject extends TextView> void setTextViewText(ViewObject textView, String text){
        textView.setText(text);
    }

}
