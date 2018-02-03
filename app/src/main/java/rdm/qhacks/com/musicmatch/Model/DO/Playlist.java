package rdm.qhacks.com.musicmatch.Model.DO;

import java.util.ArrayList;

/**
 * This is the Playlist DataObject which is a group of songs
 */
public class Playlist extends DataObject {

    private ArrayList<SongDO> setOfSongs;
    private String title;

    public Playlist(ArrayList<SongDO> setOfSongs, String title){
        this.setOfSongs = setOfSongs;
        this.title = title;
    }
}
