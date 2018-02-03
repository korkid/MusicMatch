package rdm.qhacks.com.musicmatch.Model.DO;

import java.io.File;

/**
 * This is the SongDO class which encapsulates all the fields relating to a song
 */
public class SongDO extends DataObject {
    private File songFile;
    private String filePath;
    private String songName;

    public SongDO(String filePath){
        this.filePath = filePath;

    }
}
