package rdm.qhacks.com.musicmatch.View;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MusicMatchView extends ParentView {



    public MusicMatchView(ViewGroup viewGroup, Context context, Display display){
        this.gd = new GraphicsDisplayer(viewGroup, context, display);
        this.setupLayout();
    }

    @Override
    public void setupLayout() {

    }

    @Override
    public List<View> getAllActivityViews() {
        return null;
    }
}
