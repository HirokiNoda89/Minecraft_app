package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import to.msn.wings.minecraft_memo2.R;

/**
 * Created by 4163104 on 2017/09/28.
 */

public class ToolActivity extends Activity {

    ListView listview;
    String[] members = {"斧", "ツルハシ", "シャベル", "剣", "クワ", "弓", "矢", "マーキングの矢", "効果付きの矢", "火打石と打ち金",
            "バケツ", "コンパス", "時計", "釣り竿","白紙の地図","地図(拡張)","地図(複製)","ハサミ","ファイヤーチャージ","本と羽ペン",
            "著書/記入済みの本(コピー)","ニンジン付きの棒","首綱"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        intent = new Intent(ToolActivity.this, Tool_AxeActivity.class);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.tool_base);
        listview = (ListView) findViewById(R.id.listview);

        for (String str : members) {
            adapter.add(str);
        }

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
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
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        intent.putExtra("key",position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
