package com.morijyobi.minecraft;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 4163104 on 2017/12/01.
 */

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";
    private SharedPreferences preference;
    private SharedPreferences.Editor editor;
    MemoOpenHelper helper = null;
    String id = "";
    ImageView imageView;
    LinearLayout imageLayout;
    Bitmap bitmap2;
    Bitmap bitmap1;
    int height;
    int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        setTitle("詳細");

        if (helper == null){
            helper = new MemoOpenHelper(TestActivity.this);
        }



        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        SQLiteDatabase db = helper.getReadableDatabase();
        imageView = (ImageView) findViewById(R.id.imageView);
        Resources resources = getResources();


        try{
            Cursor c = db.rawQuery("select body,xyz,img,width,height from MEMO_TABLE where id = '"+ id +"'", null);
            boolean next = c.moveToFirst();
            while (next){
                String dispBody = c.getString(0);
                String dispXyz = c.getString(1);
                String bmpstr = c.getString(2);
                width = c.getInt(3);
                height = c.getInt(4);

                if (bmpstr != null ){
                    byte[] bytes = Base64.decode(bmpstr,Base64.DEFAULT);
                    bitmap1 = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    bitmap2 = Bitmap.createScaledBitmap(bitmap1,width,height,false);
                }else{
                    bitmap2 = BitmapFactory.decodeResource(resources,R.drawable.no_image);
                }

                TextView body = (TextView) findViewById(R.id.textView1);
                TextView xyzbody = (TextView) findViewById(R.id.textView2);
                body.setText(dispBody, TextView.BufferType.NORMAL);
                xyzbody.setText(dispXyz, TextView.BufferType.NORMAL);
                imageView.setImageBitmap(bitmap2);
                next = c.moveToNext();

            }
        }finally {
            db.close();
        }
    }

    public void onClick(View v){
        finish();
    }

}

