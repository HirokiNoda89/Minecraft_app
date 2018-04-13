package com.morijyobi.minecraft.recipe;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.morijyobi.minecraft.R;
import com.morijyobi.minecraft.SpotParams;
import com.morijyobi.minecraft.home;

import jp.co.imobile.sdkads.android.ImobileSdkAd;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class Dye_RoseRedActivity extends AppCompatActivity {

    int viewId;
    int strId;
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
                CM();
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
                CM();
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
                Intent intent = new Intent(Dye_RoseRedActivity.this,home.class);
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
