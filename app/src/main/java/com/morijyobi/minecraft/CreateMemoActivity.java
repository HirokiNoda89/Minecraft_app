package com.morijyobi.minecraft;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class CreateMemoActivity extends AppCompatActivity {

    MemoOpenHelper helper = null;
    boolean newFlag = false;
    String id = "";
    private static final int READ_REQUEST_CODE = 10000;
    private static final int RESULT_CAMERA = 10001;
    Bitmap bitmap;
    Bitmap bitmap1;
    ImageButton imgbtn;
    int width;
    int height;
    String path2;
    byte[] path1;

    File picFile = null;// 写真のファイル名

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_memo);
        setTitle("座標登録");

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

//    public void camera(){
//        Intent takePhotoIntent = new Intent().setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(takePhotoIntent,READ_REQUEST_CODE);
//    }

    protected void onActivityResult1(int requestCode, int resultCode,Intent data){

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


            //path1 = Base64.encode(baos.toByteArray(), Base64.DEFAULT);
            path2 = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

        }
        //todo
        //ズームすると保存できない
        //サイズが小さい
        //画面固定必要？
        if (requestCode == RESULT_CAMERA && resultCode == RESULT_OK){

            Bitmap bitmap = null;
            Uri uri = null;
            Log.i("zl", String.valueOf(uri = data.getData()));
            // cancelしたケースも含む
            if( data.getExtras() == null){
                return;
            }
            else{

                uri = data.getData();
                String path = Globals.getImagePath(this,data.getData());

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //bitmap = (Bitmap) data.getExtras().get("data");

                // 画像サイズを計測
                
                //bitmap1 = Bitmap.createScaledBitmap(bitmap,width*4,height*4,false);

            }

            imgbtn.setImageBitmap(bitmap);
            //Bitmap bitmap2 = ((BitmapDrawable) imgbtn.getDrawable()).getBitmap();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap1.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);

            path2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
        }
    }

    public void dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(CreateMemoActivity.this);
        dialog.setTitle("選択");
        dialog.setMessage("カメラorギャラリー" );
        dialog.setPositiveButton("ギャラリー", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent, READ_REQUEST_CODE);
            }
        });
        dialog.setNegativeButton("カメラ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                SharedPreferences sp =null;


                long dateTaken = System.currentTimeMillis();
                // タイトル
                String filename = DateFormat.format("yyyy-MM-dd_kk.mm.ss", dateTaken).toString() + ".jpg";

                ContentResolver contentResolver = getContentResolver();
                ContentValues values = new ContentValues(5);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                values.put(MediaStore.Images.Media.DATE_MODIFIED, System.currentTimeMillis()/1000);
                values.put(MediaStore.Images.Media.TITLE, filename);
                values.put(MediaStore.Images.Media.DISPLAY_NAME, filename);
                values.put(MediaStore.Images.Media.DATE_TAKEN,System.currentTimeMillis());
                Uri pictureUri = contentResolver.insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                if(sp == null) sp = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("pictureUri", pictureUri.toString());
                editor.commit();


                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);

//                // TODO 写真のファイル名指定
//                picFile = new File(
//                        Environment.getExternalStorageDirectory(),
//                        "DCIM/Camera/IMG_test.jpg");
//
//                intent.putExtra(
//                        MediaStore.EXTRA_OUTPUT,
//                        Uri.fromFile(picFile));


                startActivityForResult(intent, RESULT_CAMERA);
            }
        });
        dialog.show();
    }

}