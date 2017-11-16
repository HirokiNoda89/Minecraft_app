package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import to.msn.wings.minecraft_memo2.R;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class Other_EnchantmentTable_Activity extends Activity {

    int viewId;
    int strId;
    int viewId1;
    int strId1;
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
        strId = res.getIdentifier("other" + key,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        strId1 = res.getIdentifier("other" + key + "_" + 1 ,"string",getPackageName());
        viewId1 = res.getIdentifier("textView1","id",getPackageName());
        draId1 = res.getIdentifier("otherItem" + key,"drawable",getPackageName());
        imgviewId1 = res.getIdentifier("gif1","id",getPackageName());
        draId2 = res.getIdentifier("otherItem" + key + "_" + 1,"drawable",getPackageName());
        imgviewId2 = res.getIdentifier("gif2","id",getPackageName());

        switch (key){
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 21:
            case 23:
            case 26:
            case 27:
            case 28:
            case 29:
            case 33:
            case 34:
            case 35:
            case 36:
                setContentView(R.layout.base_wood);
                TextView textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                ImageView imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                break;
            case 3:
            case 18:
            case 20:
            case 22:
            case 24:
            case 31:
                setContentView(R.layout.base_wood);
                ImageView imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(draId1).into(target);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                break;
            case 25:
            case 30:
                setContentView(R.layout.base_bed);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                TextView textView1 = (TextView) findViewById(viewId1);
                textView1.setText(res.getString(strId1));
                imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                ImageView imageView2 = (ImageView)findViewById(imgviewId2);
                imageView2.setImageDrawable(res.getDrawable(draId2));
            break;
            case 32:
                setContentView(R.layout.base_bed);
                imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target1 = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(draId1).into(target1);
                ImageView imageView4 = (ImageView) findViewById(R.id.gif2);
                GlideDrawableImageViewTarget target2 = new GlideDrawableImageViewTarget(imageView4);
                Glide.with(this).load(draId2).into(target2);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                textView1 = (TextView) findViewById(viewId1);
                textView1.setText(res.getString(strId1));
                imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                imageView2 = (ImageView)findViewById(imgviewId2);
                imageView2.setImageDrawable(res.getDrawable(draId2));
                break;
        }
    }
}
