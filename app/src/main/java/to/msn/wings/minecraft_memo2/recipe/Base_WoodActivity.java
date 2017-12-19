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

public class Base_WoodActivity extends Activity {

    int viewId;
    int strId;
    int draId;
    int imgviewId;
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
        strId = res.getIdentifier("base" + key,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        draId = res.getIdentifier("baseItem" + key,"drawable",getPackageName());
        imgviewId = res.getIdentifier("gif1","id",getPackageName());
        strId1 = res.getIdentifier("base" + key + "_" + 1 ,"string",getPackageName());
        viewId1 = res.getIdentifier("textView1","id",getPackageName());
        draId1 = res.getIdentifier("baseItem" + key,"drawable",getPackageName());
        imgviewId1 = res.getIdentifier("gif1","id",getPackageName());
        draId2 = res.getIdentifier("baseItem" + key + "_" + 1,"drawable",getPackageName());
        imgviewId2 = res.getIdentifier("gif2","id",getPackageName());

        switch (key){
            case 0:
            case 2:
                setContentView(R.layout.base_wood);
                ImageView imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(draId1).into(target);
                TextView textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                ImageView imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                break;

            case 1:
            case 3:
            case 4:
            case 5:
                setContentView(R.layout.base_wood);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
                break;

            case 6:
                setContentView(R.layout.base_bed);
                imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target1 = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(draId1).into(target1);
                ImageView imageView4 = (ImageView) findViewById(R.id.gif2);
                GlideDrawableImageViewTarget target2 = new GlideDrawableImageViewTarget(imageView4);
                Glide.with(this).load(draId2).into(target2);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                TextView textView1 = (TextView) findViewById(viewId1);
                textView1.setText(res.getString(strId1));
                imageView1 = (ImageView)findViewById(imgviewId1);
                imageView1.setImageDrawable(res.getDrawable(draId1));
                ImageView imageView2 = (ImageView)findViewById(imgviewId2);
                imageView2.setImageDrawable(res.getDrawable(draId2));
                break;
        }
    }

}
