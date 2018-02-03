package rdm.qhacks.com.musicmatch.Activities;

import android.os.Bundle;
import android.view.Window;

import rdm.qhacks.com.musicmatch.R;
import rdm.qhacks.com.musicmatch.View.MusicMatchView;

public class MusicMatch extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_music_match);
    }


    protected void setupView(){
        this.pv =  new MusicMatchView(findViewById(R.id.MusicMatch), getApplicationContext(), getWindowManager().getDefaultDisplay());
    }


}
