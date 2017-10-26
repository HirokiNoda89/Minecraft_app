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
 * Created by 4163104 on 2017/10/17.
 */

public class MachineActivity extends Activity {

    ListView listview;
    String[] members = {"木のドア","鉄のドア","木のトラップドア","鉄のトラップドア","フェンスゲート",
            "感圧式スイッチ","重量感圧板","ボタン","レバー","レッドストーントーチ",
            "レッドストーンリピーター","レッドストーンコンパレーター","ジュークボックス","音符ブロック","ドロッパー",
            "ディスペンサー","ピストン","粘着ピストン","レッドストーンランプ","トリップワイヤーフック",
            "トラップチェスト","ホッパー","レッドストーンブロック","日照センサー","オブザーバー"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        intent = new Intent(MachineActivity.this, Machine_Wooden_doorActivity.class);


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
                        intent.putExtra("key", 0);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("key", 1);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("key", 2);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("key", 3);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("key", 4);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("key", 5);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("key", 6);
                        startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("key", 7);
                        startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("key", 8);
                        startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("key", 9);
                        startActivity(intent);
                        break;
                    case 10:
                        intent.putExtra("key", 10);
                        startActivity(intent);
                        break;
                    case 11:
                        intent.putExtra("key", 11);
                        startActivity(intent);
                        break;
                    case 12:
                        intent.putExtra("key", 12);
                        startActivity(intent);
                        break;
                    case 13:
                        intent.putExtra("key", 13);
                        startActivity(intent);
                        break;
                    case 14:
                        intent.putExtra("key", 14);
                        startActivity(intent);
                        break;
                    case 15:
                        intent.putExtra("key", 15);
                        startActivity(intent);
                        break;
                    case 16:
                        intent.putExtra("key", 16);
                        startActivity(intent);
                        break;
                    case 17:
                        intent.putExtra("key", 17);
                        startActivity(intent);
                        break;
                    case 18:
                        intent.putExtra("key", 18);
                        startActivity(intent);
                        break;
                    case 19:
                        intent.putExtra("key", 19);
                        startActivity(intent);
                        break;
                    case 20:
                        intent.putExtra("key", 20);
                        startActivity(intent);
                        break;
                    case 21:
                        intent.putExtra("key",21);
                        startActivity(intent);
                        break;
                    case 22:
                        intent.putExtra("key",22);
                        startActivity(intent);
                        break;
                    case 23:
                        intent.putExtra("key",23);
                        startActivity(intent);
                        break;
                    case 24:
                        intent.putExtra("key",24);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
