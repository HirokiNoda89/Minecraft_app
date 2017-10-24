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

public class BrewingActivity extends Activity {

    ListView listview;
    String[] members = {"醸造台","ガラス瓶","大釜","醗酵したクモの目","マグマクリーム","ブレイズパウダー","きらめくスイカ","金のニンジン"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        intent = new Intent(BrewingActivity.this, Brewing_StandActivity.class);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.food_base);
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
                }
            }
        });
    }
}
