package to.msn.wings.minecraft_memo2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class CreateMemoActivity extends AppCompatActivity {

    MemoOpenHelper helper = null;
    boolean newFlag = false;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_memo);

        if(helper == null){
            helper = new MemoOpenHelper(CreateMemoActivity.this);
        }
        Intent intent = this.getIntent();
        id = intent.getStringExtra("id");
        if(id.equals("")){
            newFlag = true;
        }else{
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                Cursor c = db.rawQuery("select body from MEMO_TABLE where uuid = '"+ id +"'", null);
                boolean next = c.moveToFirst();
                while (next) {
                    String dispBody = c.getString(0);
                    EditText body = (EditText)findViewById(R.id.body);
                    body.setText(dispBody, TextView.BufferType.NORMAL);
                    next = c.moveToNext();
                }
            } finally {
                db.close();
            }
        }

        Button registerButton = (Button) findViewById(R.id.register);

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText body = (EditText)findViewById(R.id.body);
                EditText Xinfo = (EditText) findViewById(R.id.X);
                EditText Yinfo = (EditText) findViewById(R.id.Y);
                EditText Zinfo = (EditText) findViewById(R.id.Z);
                String bodyStr = body.getText().toString();
                String X = Xinfo.getText().toString();
                String Y = Yinfo.getText().toString();
                String Z = Zinfo.getText().toString();
                String xyzStr ="X:" + X + "," + "Y:" + Y + "," + "Z:" + Z;

                SQLiteDatabase db = helper.getWritableDatabase();
                try {
                    if(newFlag){
                        id = UUID.randomUUID().toString();
                        db.execSQL("insert into MEMO_TABLE(uuid, body, xyz) VALUES('"+ id +"', '"+ bodyStr + "' , '" + xyzStr + "' )");
                    }else{
                        //更新処理
                    }
                } finally {
                    db.close();
                }
                Intent intent = new Intent(CreateMemoActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });

        Button backButton = (Button) findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateMemoActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }
}