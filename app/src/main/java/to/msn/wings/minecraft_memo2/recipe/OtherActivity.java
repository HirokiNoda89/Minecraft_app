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
                    case 25:
                        intent.putExtra("key",25);
                        startActivity(intent);
                        break;
                    case 26:
                        intent.putExtra("key",26);
                        startActivity(intent);
                        break;
                    case 27:
                        intent.putExtra("key",27);
                        startActivity(intent);
                        break;
                    case 28:
                        intent.putExtra("key",28);
                        startActivity(intent);
                        break;
                    case 29:
                        intent.putExtra("key",29);
                        startActivity(intent);
                        break;
                    case 30:
                        intent.putExtra("key",30);
                        startActivity(intent);
                        break;
                    case 31:
                        intent.putExtra("key",31);
                        startActivity(intent);
                        break;
                    case 32:
                        intent.putExtra("key",32);
                        startActivity(intent);
                        break;
                    case 33:
                        intent.putExtra("key",33);
                        startActivity(intent);
                        break;
                    case 34:
                        intent.putExtra("key",34);
                        startActivity(intent);
                        break;
                    case 35:
                        intent.putExtra("key",35);
                        startActivity(intent);
                        break;
                    case 36:
                        intent.putExtra("key",36);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
