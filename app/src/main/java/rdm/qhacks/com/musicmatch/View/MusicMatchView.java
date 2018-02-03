package rdm.qhacks.com.musicmatch.View;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.ImageView;

import rdm.qhacks.com.musicmatch.Controllers.FetchMusicController;
import rdm.qhacks.com.musicmatch.R;

public class MusicMatchView extends ParentView {

    FetchMusicController activityController;

    public MusicMatchView(ViewGroup viewGroup, Context context, Display display, FetchMusicController activityController){
        this.gd = new GraphicsDisplayer(viewGroup, context, display);
        this.activityController = activityController;
        this.setupLayout();
    }

    @Override
    protected void setupLayout() {
        this.gd.getActivityLayout().setBackgroundColor(Color.parseColor("#66ccff"));

        ImageView fetchSimilarMusic = new ImageView(this.gd.getActivityContext());
        this.gd.addTextToButton(fetchSimilarMusic, "Find me Music", 12, "OpenSans-Regular", "BLACK", R.drawable.background, 50,50, 0.5f,0.5f);
        this.activityViews.put("FetchMusic", fetchSimilarMusic);

        fetchSimilarMusic.setOnClickListener(view -> Log.d("Data returned", activityController.sendFetchAndGetResponse(this.gd.getActivityContext())));
    }
}
