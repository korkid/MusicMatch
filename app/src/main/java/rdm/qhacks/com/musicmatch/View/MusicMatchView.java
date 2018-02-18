package rdm.qhacks.com.musicmatch.View;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import rdm.qhacks.com.musicmatch.R;

public class MusicMatchView extends ParentView {

    private final String activityBackGroundColor = "#66ccff";

    public MusicMatchView(ViewGroup viewGroup, Context context){
        this.viewGroup = viewGroup;
        this.context = context;
    }

    /**
     * @Method setupLayout : Sets up the basic static UI that the MusicMatch activity will load
     *                       Initialize and create the fragments
     */
    @Override
    public void setupLayout() {
        //Set background colour
        this.viewGroup.setBackgroundColor(Color.parseColor(activityBackGroundColor));

        //Set title attributes
        TextView title = this.viewGroup.findViewById(R.id.MusicMatchTitle);
        title.setText(this.context.getString(R.string.app_name));
        title.setTextSize(TypedValue.COMPLEX_UNIT_PX, 135);

        //Setup Recycler View
    }

    public void accessFiles(){

    }


}
