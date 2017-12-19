package to.msn.wings.minecraft_memo2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class CreateMemoActivity extends Activity {

    MemoOpenHelper helper = null;
    boolean newFlag = false;
    String id = "";
    ImageView img;
    private static final int READ_REQUEST_CODE = 10000;
    Bitmap bitmap;
    String bmpstr;
    ImageButton imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_memo);


        img = (ImageView)findViewById(R.id.imgView);
        imgbtn = (ImageButton) findViewById(R.id.imgbtn);

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
                Cursor c = db.rawQuery("select body,xyz,img from MEMO_TABLE where uuid = '"+ id +"'", null);
                boolean next = c.moveToFirst();
                while (next) {
                    String dispBody = c.getString(0);
                    EditText body = (EditText)findViewById(R.id.body);
                    EditText Xinfo = (EditText) findViewById(R.id.X);
                    EditText Yinfo = (EditText) findViewById(R.id.Y);
                    EditText Zinfo = (EditText) findViewById(R.id.Z);
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
                        db.execSQL("insert into MEMO_TABLE(uuid, body, xyz, img) VALUES('"+ id +"', '"+ bodyStr + "' , '" + xyzStr + "' , '" + bmpstr + "' )");
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

    public void gallery(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent,READ_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK){

            InputStream in = null;
            try {
                in = getContentResolver().openInputStream(data.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap bmp = BitmapFactory.decodeStream(in);
            imgbtn.setImageBitmap(bmp);
            //img.setImageBitmap(bmp);

            bitmap = ((BitmapDrawable) imgbtn.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            bmpstr = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
        }
    }
}