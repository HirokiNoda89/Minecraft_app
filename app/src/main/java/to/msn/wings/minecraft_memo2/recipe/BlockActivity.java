package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import to.msn.wings.minecraft_memo2.R;

public class BlockActivity extends Activity {

    ListView listview;
    String[] members = {"鉱石ブロック","グロウストーン","羊毛","色付き羊毛","TNT","ハーフブロック","階段","雪ブロック",
            "雪","粘土ブロック","レンガブロック","石レンガ","苔石レンガ","模様入り石レンガ","砂岩","赤砂岩","本棚","ジャック・オ・ランタン",
            "スイカ（ブロック）","ネザー水晶ブロック","模様入りネザー水晶ブロック","干草の俵","色付きテラコッタ","色付きガラス",
            "スライムブロック","花崗岩","安山岩","閃緑岩","磨かれた花崗岩","磨かれた安山岩","磨かれた閃緑岩","苔石","粗い土",
            "プリズマリン","プリズマリンレンガ","ダークプリズマリン","シーランタン","エンドストーンレンガ","プルプァブロック",
            "マグマブロック","ネザーウォートブロック","赤ネザーレンガ","骨ブロック","コンクリートパウダー"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        intent = new Intent(BlockActivity.this,Block_OreActivity.class);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.block_base);
        listview = (ListView) findViewById(R.id.listview);

        for (String str: members){
            adapter.add(str);
        }

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent.putExtra("key",0);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("key",1);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("key",2);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("key",3);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("key",4);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("key",5);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("key",6);
                        startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("key",7);
                        startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("key",8);
                        startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("key",9);
                        startActivity(intent);
                        break;
                    case 10:
                        intent.putExtra("key",10);
                        startActivity(intent);
                        break;
                    case 11:
                        intent.putExtra("key",11);
                        startActivity(intent);
                        break;
                    case 12:
                        intent.putExtra("key",12);
                        startActivity(intent);
                        break;
                    case 13:
                        intent.putExtra("key",13);
                        startActivity(intent);
                        break;
                    case 14:
                        intent.putExtra("key",14);
                        startActivity(intent);
                        break;
                    case 15:
                        intent.putExtra("key",15);
                        startActivity(intent);
                        break;
                    case 16:
                        intent.putExtra("key",16);
                        startActivity(intent);
                        break;
                    case 17:
                        intent.putExtra("key",17);
                        startActivity(intent);
                        break;
                    case 18:
                        intent.putExtra("key",18);
                        startActivity(intent);
                        break;
                    case 19:
                        intent.putExtra("key",19);
                        startActivity(intent);
                        break;
                    case 20:
                        intent.putExtra("key",20);
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
                    case 37:
                        intent.putExtra("key",37);
                        startActivity(intent);
                        break;
                    case 38:
                        intent.putExtra("key",38);
                        startActivity(intent);
                        break;
                    case 39:
                        intent.putExtra("key",39);
                        startActivity(intent);
                        break;
                    case 40:
                        intent.putExtra("key",40);
                        startActivity(intent);
                        break;
                    case 41:
                        intent.putExtra("key",41);
                        startActivity(intent);
                        break;
                    case 42:
                        intent.putExtra("key",42);
                        startActivity(intent);
                        break;
                    case 43:
                        intent.putExtra("key",43);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
