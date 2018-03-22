package com.morijyobi.minecraft;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    MemoOpenHelper helper = null;
    HashMap<String, String> data;
    SampleListAdapter adapter;
    ArrayList<SampleListItem> listItems = new ArrayList<>();
    SQLiteDatabase db;
    final ArrayList<HashMap<String, String>> memoList = new ArrayList<>();
    ListView listView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("メモ");
        listView = (ListView) findViewById(R.id.memoList);


        if (helper == null) {
            helper = new MemoOpenHelper(ListActivity.this);
        }
        db = helper.getWritableDatabase();
        try {
            Cursor c = db.rawQuery("select id, body, xyz, img, width, height from MEMO_TABLE order by id", null);
            boolean next = c.moveToFirst();

            while (next) {
                data = new HashMap<>();
                String id = c.getString(0);
                String body = c.getString(1);
                String xyz = c.getString(2);
                String img = c.getString(3);
                String width = c.getString(4);
                String height = c.getString(5);
                if (body.length() > 20) {
                    body = body.substring(0, 20) + "...";
                }
                data.put("id", id);
                data.put("body", body);
                data.put("xyz", xyz);
                data.put("image", img);
                data.put("width", width);
                data.put("height", height);
                memoList.add(data);
                next = c.moveToNext();

            }
        } finally {
            db.close();
        }

        for (int i = 0; i < memoList.size(); i++){
            if (memoList.size() != 0) {
                if (memoList.get(i).get("image") == null){
                    Resources resources = getResources();
                    bitmap = BitmapFactory.decodeResource(resources,R.drawable.no_image);
                }else{
                    byte[] bytes = Base64.decode(memoList.get(i).get("image"), Base64.DEFAULT);
                    bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                }
                SampleListItem item = new SampleListItem(bitmap, memoList.get(i).get("body") + " " +  memoList.get(i).get("xyz"));
                listItems.add(item);
            }
        }

        adapter = new SampleListAdapter(this,R.layout.samplelist_item,listItems);
        listView.setAdapter(adapter);


        // リスト項目をクリックした時の処理
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * @param parent ListView
             * @param view 選択した項目
             * @param position 選択した項目の添え字
             * @param id 選択した項目のID
             */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // インテント作成  第二引数にはパッケージ名からの指定で、遷移先クラスを指定
                Intent intent = new Intent(ListActivity.this, TestActivity.class);

                HashMap<String, String> test = memoList.get(position);
                String str = test.get("id");

                // 値を引き渡す (識別名, 値)の順番で指定します
                intent.putExtra("id", str);
                // Activity起動
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(onItemLongClickListener);

    }

    private AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            final int po = position;
            final String str = memoList.get(po).get("id");

            AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.this);
            dialog.setTitle("確認");
            dialog.setMessage("メモを削除してもよろしいですか？");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SQLiteDatabase db = helper.getWritableDatabase();
                    try {
                        db.execSQL("DELETE FROM MEMO_TABLE WHERE id = '" + str + "'");
                    } finally {
                        db.close();
                    }
                    memoList.remove(po);
                    listItems.remove(po);
                    adapter.notifyDataSetChanged();

                }
            });
            dialog.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
            return true;
        }
    };

    public void dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.this);
        dialog.setTitle("HELP");
        dialog.setMessage("右上のプラスアイコンをタップするとメモを新規作成できます。" +
                "メモをタップすると作ったメモの内容を確認できます。" +
                "メモを削除するときはメモを長押ししてください。" );
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(ListActivity.this, home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                break;
            case R.id.add_memo:
                intent = new Intent(ListActivity.this, CreateMemoActivity.class);
                intent.putExtra("id", "");
                startActivity(intent);
                break;
            case R.id.help:
                dialog();
                break;
        }
        return true;
    }
}
