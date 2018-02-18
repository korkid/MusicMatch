package rdm.qhacks.com.musicmatch.Activities;

import android.support.v7.app.AppCompatActivity;


/**
 * All activities in this app extend from the base activity
 */
abstract public class BaseActivity extends AppCompatActivity {

    abstract void setupView();
    abstract void initializeController();

}
