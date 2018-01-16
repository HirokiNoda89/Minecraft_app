package to.msn.wings.minecraft_memo2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 4163104 on 2017/12/01.
 */

public class TestActivity extends AppCompatActivity {

    MemoOpenHelper helper = null;
    String id = "";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        if (helper == null){
            helper = new MemoOpenHelper(TestActivity.this);
        }

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        SQLiteDatabase db = helper.getReadableDatabase();
        imageView = (ImageView) findViewById(R.id.imgView);

        try{
            Cursor c = db.rawQuery("select body,xyz,img from MEMO_TABLE where uuid = '"+ id +"'", null);
            boolean next = c.moveToFirst();
            while (next){
                String dispBody = c.getString(0);
                String dispXyz = c.getString(1);
                String bmpstr = c.getString(2);
                byte[] bytes = Base64.decode(bmpstr,Base64.DEFAULT);
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bytes,0,bytes.length));
                TextView body = (TextView) findViewById(R.id.textView1);
                TextView xyzbody = (TextView) findViewById(R.id.textView2);
                body.setText(dispBody,TextView.BufferType.NORMAL);
                xyzbody.setText(dispXyz,TextView.BufferType.NORMAL);
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
