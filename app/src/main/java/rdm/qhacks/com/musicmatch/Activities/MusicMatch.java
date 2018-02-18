package rdm.qhacks.com.musicmatch.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.Window;
import android.widget.TextView;

import rdm.qhacks.com.musicmatch.Controllers.MusicMatchController;
import rdm.qhacks.com.musicmatch.R;
import rdm.qhacks.com.musicmatch.Services.NetworkService;
import rdm.qhacks.com.musicmatch.View.MusicMatchView;
import rdm.qhacks.com.musicmatch.View.ParentView;

public class MusicMatch extends BaseActivity {

    private ParentView musicMatchView; //View for this actvitiy
    private MusicMatchController musicMatchController; //Controller for this activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_music_match);

        startNetworkService();
        setupView();
        initializeController();
        sampleRetrieve();
    }

    /**
     * Helper method to start the Network service
     * To-do try to abstract this code
     */
    private void startNetworkService() {
        Intent intent = new Intent(this, NetworkService.class);
        startService(intent);
    }

    /**
     * Setup view
     */
    @Override
    protected void setupView(){
        ConstraintLayout activityLayout = findViewById(R.id.MusicMatchLayout);
        this.musicMatchView = new MusicMatchView(activityLayout, getApplicationContext());
        this.musicMatchView.setupLayout();
    }

    /**
     *  Setup controller if need be
     */
    @Override
    protected void initializeController() {
        this.musicMatchController = new MusicMatchController();
    }

    /* Business Logic Here*/
    @SuppressLint("FindViewByIdCast")
    protected void sampleRetrieve(){
        TextView result = findViewById(R.id.Results);
        findViewById(R.id.FetchButton).setOnClickListener(View -> this.musicMatchController.sendFetchAndGetStringResponse(result::setText));
    }

}
