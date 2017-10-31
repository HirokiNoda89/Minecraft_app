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
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        intent.putExtra("key",position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
