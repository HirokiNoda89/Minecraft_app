package to.msn.wings.minecraft_memo2;

import android.graphics.Bitmap;

/**
 * Created by 4163104 on 2018/02/07.
 */

public class SampleListItem {
    private Bitmap mThumbnail = null;
    private String mTitle = null;


    public SampleListItem(){};


    public SampleListItem(Bitmap thumbnail, String title){
        mThumbnail = thumbnail;
        mTitle = title;
    }

    public void setThumbnail(Bitmap thumbnail){
        mThumbnail = thumbnail;
    }

    public Bitmap getThumbnail(){
        return mThumbnail;
    }

    public String getTitle(){
        return mTitle;
    }
}
