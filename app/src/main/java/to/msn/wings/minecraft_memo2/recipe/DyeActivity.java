package to.msn.wings.minecraft_memo2.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import to.msn.wings.minecraft_memo2.Globals;
import to.msn.wings.minecraft_memo2.R;
import to.msn.wings.minecraft_memo2.home;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class DyeActivity extends AppCompatActivity {

    ListView listview;
    Intent intent;
    Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        intent = new Intent(DyeActivity.this, Dye_RoseRedActivity.class);

        globals = (Globals) this.getApplication();
        globals.GlobalsInit();
        String members[] = globals.dye_member;

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
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        intent.putExtra("key", position);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(DyeActivity.this,home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
