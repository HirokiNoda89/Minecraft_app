package com.morijyobi.minecraft;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.morijyobi.minecraft.recipe.RecipeActivity;

import jp.co.imobile.sdkads.android.ImobileSdkAd;

/**
 * Created by 4163104 on 2017/09/07.
 */

public class home extends AppCompatActivity {
    ListView listview;
    String[] members = {"ワールド","レシピ","レシピ検索","精錬とは"};
    long currentTimeMillis;
    SharedPreferences preference;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("マイクラ座標管理");

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






        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.base);
        listview = (ListView) findViewById(R.id.listview);

        for (String str: members){
            adapter.add(str);
        }


        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i1 = new Intent(home.this,ListActivity.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2 = new Intent(home.this,RecipeActivity.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(home.this,Search_Activity.class);
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4 = new Intent(home.this,Web_Activity.class);
                        startActivity(i4);
                        break;

                }
            }
        });

        currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sp = getSharedPreferences("",MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        if (sp.getBoolean("first_start",false)){
            long sampleTimeTest111 = currentTimeMillis + 60000;
            preference = getSharedPreferences("UnixTime",MODE_PRIVATE);
            editor = preference.edit();
            editor.putLong("setTime",sampleTimeTest111);
            editor.commit();
            editor.apply();


            e.putBoolean("first_start",true);
            e.commit();

        }else{
            e.putBoolean("first_start",false);
            e.commit();
            Log.i("test","起動");
        }
    }
}

