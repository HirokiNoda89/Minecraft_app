package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import to.msn.wings.minecraft_memo2.Globals;
import to.msn.wings.minecraft_memo2.R;

public class ArmorActivity extends Activity {

    ListView listview;
    Intent intent;
    Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        globals = (Globals) this.getApplication();
        globals.GlobalsInit();
        String members[] = globals.armor_member;

        intent = new Intent(ArmorActivity.this, Armor_HelmetsActivity.class);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.base);
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
                        intent.putExtra("key", position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
