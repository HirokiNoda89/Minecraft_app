package to.msn.wings.minecraft_memo2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class CreateMemoActivity extends AppCompatActivity {
    //TODO
    /*
    * ファイルパスで画像表示
    * */

    MemoOpenHelper helper = null;
    boolean newFlag = false;
    String id = "";
    private static final int READ_REQUEST_CODE = 10000;
    Bitmap bitmap;
    ImageButton imgbtn;
    int width;
    int height;
    String path2;
    byte[] path1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_memo);

        imgbtn = (ImageButton) findViewById(R.id.imgbtn);

        if (helper == null) {
            helper = new MemoOpenHelper(CreateMemoActivity.this);
        }
        Intent intent = this.getIntent();
        id = intent.getStringExtra("id");
        if (id.equals("")) {
            newFlag = true;
        } else {
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                Cursor c = db.rawQuery("select body,xyz,img,width,height from MEMO_TABLE where uuid = '" + id + "'", null);
                boolean next = c.moveToFirst();
                while (next) {
                    String dispBody = c.getString(0);
                    EditText body = (EditText) findViewById(R.id.body);
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
                EditText body = (EditText) findViewById(R.id.body);
                EditText Xinfo = (EditText) findViewById(R.id.X);
                EditText Yinfo = (EditText) findViewById(R.id.Y);
                EditText Zinfo = (EditText) findViewById(R.id.Z);
                String bodyStr = body.getText().toString();
                String X = Xinfo.getText().toString();
                String Y = Yinfo.getText().toString();
                String Z = Zinfo.getText().toString();
                String xyzStr = "X:" + X + "," + "Y:" + Y + "," + "Z:" + Z;

                SQLiteDatabase db = helper.getWritableDatabase();
                try {
                    if (newFlag) {
                        id = UUID.randomUUID().toString();

                        ContentValues cv = new ContentValues();
                        cv.put("body", bodyStr);
                        cv.put("xyz", xyzStr);
                        cv.put("img", path2);
                        cv.put("width", width);
                        cv.put("height", height);
                        db.insert("MEMO_TABLE", null, cv);


                    } else {
                        //更新処理
                    }
                } finally {
                    db.close();
                }

                Intent intent = new Intent(CreateMemoActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        Button backButton = (Button) findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateMemoActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void gallery(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK) {

            InputStream in = null;
            try {
                in = getContentResolver().openInputStream(data.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap bmp = BitmapFactory.decodeStream(in);
            imgbtn.setImageBitmap(bmp);

            bitmap = ((BitmapDrawable) imgbtn.getDrawable()).getBitmap();
            width = bitmap.getWidth();
            height = bitmap.getHeight();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            if (bitmap.getHeight() >= 2000 || bitmap.getWidth() >= 2000) {
                Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, width / 2, height / 2, false);
                bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            }


            path1 = Base64.encode(baos.toByteArray(), Base64.DEFAULT);
            path2 = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

        }
    }

}