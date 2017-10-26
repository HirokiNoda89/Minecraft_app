package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import to.msn.wings.minecraft_memo2.R;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class Dye_RoseRedActivity extends Activity {

    int viewId;
    int strId;
    int draId1;
    int imgviewId1;
    int draId2;
    int imgviewId2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int key = intent.getIntExtra("key",0);

        Resources res = getResources();
        strId = res.getIdentifier("dye" + key,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        draId1 = res.getIdentifier("dyeItem" + key,"drawable",getPackageName());
        imgviewId1 = res.getIdentifier("gif1","id",getPackageName());
        draId2 = res.getIdentifier("dyeItem" + key + "_" + 1,"drawable",getPackageName());
        imgviewId2 = res.getIdentifier("gif2","id",getPackageName());

        switch (key){
            case 0:
                setContentView(R.layout.base_bed);
                TextView textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                ImageView imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                ImageView imageView2 = (ImageView)findViewById(imgviewId2);
                imageView2.setImageDrawable(res.getDrawable(draId2));
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                setContentView(R.layout.base_wood);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                break;
        }
    }
}
