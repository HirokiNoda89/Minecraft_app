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


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.truck_base);
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
                    case 23:
                    case 24:
                        intent.putExtra("key",position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
