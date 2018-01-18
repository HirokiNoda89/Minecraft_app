package to.msn.wings.minecraft_memo2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    MemoOpenHelper helper = null;
    HashMap<String,String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("メモ");
        

        if(helper == null){
            helper = new MemoOpenHelper(ListActivity.this);
        }

        final ArrayList<HashMap<String, String>> memoList = new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            Cursor c = db.rawQuery("select uuid, body, xyz, img from MEMO_TABLE order by id", null);
            boolean next = c.moveToFirst();

            while (next) {
                data = new HashMap<>();
                String uuid = c.getString(0);
                String body = c.getString(1);
                String xyz = c.getString(2);
                String img;
                img = c.getString(3);
                if(body.length() > 20){
                    body = body.substring(0, 20) + "...";
                }
                data.put("body",body);
                data.put("id",uuid);
                data.put("xyz",xyz);
                data.put("image",img);
                memoList.add(data);
                next = c.moveToNext();
            }
        } finally {
            db.close();
        }

        // Adapter生成
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                memoList, // 使用するデータ
                R.layout.raw, // 使用するレイアウト
                new String[]{"body","xyz"}, // どの項目を
                new int[]{android.R.id.text1, android.R.id.text2} // どのidの項目に入れるか
        );

        // idがmemoListのListViewを取得
        ListView listView = (ListView) findViewById(R.id.memoList);
        listView.setAdapter(simpleAdapter);

        // リスト項目をクリックした時の処理
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            /**
             * @param parent ListView
             * @param view 選択した項目
             * @param position 選択した項目の添え字
             * @param id 選択した項目のID
             */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // インテント作成  第二引数にはパッケージ名からの指定で、遷移先クラスを指定
                Intent intent = new Intent(ListActivity.this,TestActivity.class);

                HashMap<String,String> test = memoList.get(position);
                String str = test.get("id");

                // 選択されたビューを取得 TwoLineListItemを取得した後、text2の値を取得する
//                TwoLineListItem two = (TwoLineListItem)view;
//                TextView idTextView = (TextView)two.findViewById(android.R.id.text2);
//                TextView idTextView = (TextView)two.getText2();
//                String idStr = (String) idTextView.getText();
                // 値を引き渡す (識別名, 値)の順番で指定します
                intent.putExtra("id", str);
                // Activity起動
                startActivity(intent);
            }
        });

        // リスト項目を長押しクリックした時の処理
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            /**
             * @param parent ListView
             * @param view 選択した項目
             * @param position 選択した項目の添え字
             * @param id 選択した項目のID
             */
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final String idStr = ((HashMap<String,String>) memoList.get(position)).get("id");

                AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.this);
                dialog.setTitle("確認");
                dialog.setMessage("メモを削除してもよろしいですか？");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db = helper.getWritableDatabase();
                        try {
                            db.execSQL("DELETE FROM MEMO_TABLE WHERE uuid = '"+ idStr +"'");
                        } finally {
                            db.close();
                        }
                        memoList.remove(position);
                        simpleAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.create().show();
                return true;
            }
        });
    }

    public void dialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.this);
        dialog.setTitle("HELP");
        dialog.setMessage("右上のプラスアイコンをタップするとメモを新規作成できます。メモを削除するときはメモを長押ししてください。");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(ListActivity.this,home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                break;
            case R.id.add_memo:
                intent = new Intent(ListActivity.this,CreateMemoActivity.class);
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
