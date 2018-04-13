package com.morijyobi.minecraft.recipe;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.morijyobi.minecraft.R;
import com.morijyobi.minecraft.SpotParams;
import com.morijyobi.minecraft.home;

import jp.co.imobile.sdkads.android.ImobileSdkAd;

public class Block_OreActivity extends AppCompatActivity {

    int viewId;
    int strId;
    int draId;
    int imgviewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("レシピ詳細");

        Intent intent = getIntent();
        int key = intent.getIntExtra("key",0);

        Resources res = getResources();
        strId = res.getIdentifier("block" + key,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        draId = res.getIdentifier("blockItem" + key,"drawable",getPackageName());
        imgviewId = res.getIdentifier("gif1","id",getPackageName());

        switch (key){
            case 0:
            case 3:
            case 5:
            case 6:
            case 14:
            case 15:
            case 20:
            case 22:
            case 23:
            case 43:
                setContentView(R.layout.base_wood);
                ImageView imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(draId).into(target);
                TextView textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                ImageView imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
                CM();
                break;
            case 1:
            case 2:
            case 4:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
                setContentView(R.layout.base_wood);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
                CM();
                break;
        }
    }
    public void onClick(View v){
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main2,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(Block_OreActivity.this,home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
    public void CM(){
        //広告
        // スポット情報を設定します
        ImobileSdkAd.registerSpotInline(this, SpotParams.PUBLISHER_ID, SpotParams.MEDIA_ID, SpotParams.BANNER_SPOT_ID);
        // 広告の取得を開始します
        ImobileSdkAd.start(SpotParams.BANNER_SPOT_ID);

        // 広告を表示するViewを作成します
        FrameLayout imobileAdLayout = new FrameLayout(this);
        FrameLayout.LayoutParams imobileAdLayoutParam = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        // 広告の表示位置を指定
        imobileAdLayoutParam.gravity = (Gravity.BOTTOM | Gravity.CENTER);
        //広告を表示するLayoutをActivityに追加します
        addContentView(imobileAdLayout, imobileAdLayoutParam);
        // 広告を表示します
        ImobileSdkAd.showAd(this, SpotParams.BANNER_SPOT_ID, imobileAdLayout);
    }
}