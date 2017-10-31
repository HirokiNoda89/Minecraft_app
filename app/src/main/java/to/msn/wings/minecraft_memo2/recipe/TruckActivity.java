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

public class TruckActivity extends Activity {

    ListView listview;
    String[] members = {"トロッコ","かまど付きトロッコ","チェスト付きトロッコ","ホッパー付きトロッコ","TNT付きトロッコ",
            "レール","パワードレール","ディテクターレール","アクティベーターレール","ボート"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        intent = new Intent(TruckActivity.this, Truck_MinecartActivity.class);


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
                        intent.putExtra("key", position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
