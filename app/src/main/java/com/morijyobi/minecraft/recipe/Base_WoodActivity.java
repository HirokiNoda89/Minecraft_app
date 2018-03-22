package com.morijyobi.minecraft.recipe;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.morijyobi.minecraft.R;
import com.morijyobi.minecraft.home;

public class Base_WoodActivity extends AppCompatActivity {

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("レシピ詳細");

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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main2,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(Base_WoodActivity.this,home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
