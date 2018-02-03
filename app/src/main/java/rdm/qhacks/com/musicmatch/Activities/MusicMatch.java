package rdm.qhacks.com.musicmatch.Activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import rdm.qhacks.com.musicmatch.R;
import rdm.qhacks.com.musicmatch.View.GraphicsDisplayer;

public class MusicMatch extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);





        setContentView(R.layout.activity_music_match);


        //Initializing shit

        Context context = this;
        ConstraintLayout cl = findViewById(R.id.MusicMatch);

        GraphicsDisplayer musicMatch = new GraphicsDisplayer(cl, context, this.getWindowManager().getDefaultDisplay());


        //Graphics Below

        musicMatch.addText("MusicMatch", "OpenSans-ExtraBoldItalic", "BLACK", 2, 50, 50, 13);











    }








}
