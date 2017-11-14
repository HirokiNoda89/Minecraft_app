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

        switch (key){
            case 0:
            case 2:
            case 6:
                setContentView(R.layout.base_wood);
                ImageView imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(draId).into(target);
                TextView textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                ImageView imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
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
        }


    }

}
