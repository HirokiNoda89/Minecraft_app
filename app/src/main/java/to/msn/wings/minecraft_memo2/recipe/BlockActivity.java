package to.msn.wings.minecraft_memo2.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import to.msn.wings.minecraft_memo2.Globals;
import to.msn.wings.minecraft_memo2.R;

public class BlockActivity extends AppCompatActivity {

    ListView listview;
    Intent intent;
    Globals globals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        intent = new Intent(BlockActivity.this,Block_OreActivity.class);

        globals = (Globals) this.getApplication();
        globals.GlobalsInit();
        String members[] = globals.block_member;

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
