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

public class OtherActivity extends Activity {

    ListView listview;
    String[] members = {"エンチャントテーブル","金床","ビーコン","鉱物","金インゴット","金塊","鉄インゴット","鉄塊","レッドストーン","絵画",
            "額縁","植木鉢","看板","はしご","紙","本","革","スライムボール","フェンス","ネザーレンガフェンス","石の壁(苔石の壁)",
            "鉄格子","カーペット","板ガラス","色付きガラス板","骨粉","スイカの種","カボチャの種","エンダーアイ","エンダーチェスト",
            "花火の星","ロケット花火","旗","防具立て","エンダークリスタル","エンドロッド","シュルカーボックス"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        intent = new Intent(OtherActivity.this, Other_EnchantmentTable_Activity.class);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_base);
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
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                        intent.putExtra("key",position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
