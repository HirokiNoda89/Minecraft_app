package com.morijyobi.minecraft;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import jp.co.imobile.sdkads.android.ImobileSdkAd;

/**
 * Created by 4163104 on 2017/12/19.
 */

public class Search_Hit_Activity extends AppCompatActivity {

    int viewId;
    int strId;
    int draId;
    int imgviewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("詳細");

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        int strid = intent.getIntExtra("nameid",-1);

        Resources res = getResources();
        strId = res.getIdentifier(""+ str + strid,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        draId = res.getIdentifier("" + str + "Item" + strid,"drawable",getPackageName());
        imgviewId = res.getIdentifier("gif1","id",getPackageName());

        setContentView(R.layout.base_wood);
        TextView textView = (TextView)findViewById(viewId);
        textView.setText(res.getString(strId));
        ImageView imageView = (ImageView) findViewById(R.id.gif1);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(draId).into(target);
        CM();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
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
