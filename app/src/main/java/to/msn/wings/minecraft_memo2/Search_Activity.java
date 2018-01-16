package to.msn.wings.minecraft_memo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 4163104 on 2017/12/18.
 */

public class Search_Activity extends AppCompatActivity {

    EditText editText;
    Globals globals;
    ArrayList<String> search;
    ListView listView;
    ArrayList<String> base_member = new ArrayList<>();
    ArrayList<String> block_member = new ArrayList<>();
    ArrayList<String> tool_member = new ArrayList<>();
    ArrayList<String> armor_member = new ArrayList<>();
    ArrayList<String> truck_member = new ArrayList<>();
    ArrayList<String> machine_member = new ArrayList<>();
    ArrayList<String> food_member = new ArrayList<>();
    ArrayList<String> brewing_member = new ArrayList<>();
    ArrayList<String> dye_member = new ArrayList<>();
    ArrayList<String> other_member = new ArrayList<>();
    ArrayList<String> search_hit= new ArrayList<>();
    ArrayList<Integer> number_hit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        globals = (Globals) this.getApplication();
        globals.GlobalsInit();
        search = new ArrayList<>();

        for (String str : globals.base_member){
            base_member.add(str);
            search.add(str);
        }

        for (String str : globals.block_member){
            block_member.add(str);
            search.add(str);
        }

        for (String str : globals.tool_member){
            tool_member.add(str);
            search.add(str);
        }

        for (String str : globals.armor_member){
            armor_member.add(str);
            search.add(str);
        }

        for (String str : globals.truck_member){
            truck_member.add(str);
            search.add(str);
        }

        for (String str : globals.machine_member){
            machine_member.add(str);
            search.add(str);
        }

        for (String str : globals.food_member){
            food_member.add(str);
            search.add(str);
        }

        for (String str : globals.brewing_member){
            brewing_member.add(str);
            search.add(str);
        }

        for (String str : globals.dye_member){
            dye_member.add(str);
            search.add(str);
        }

        for (String str : globals.other_member){
            other_member.add(str);
            search.add(str);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                        //新しいアクティビティで全部base,tool,foodで(if)区別、アイテムの種類ごとにアイテムを検索,アイテムの番号と種類でアイテム詳細にアクセス
                    default:
                        Intent intent = new Intent(Search_Activity.this,Search_Hit_Activity.class);
                        String str = search_hit.get(position);
                        int strid = number_hit.get(position);
                        intent.putExtra("name",str);
                        intent.putExtra("nameid",strid);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public void onClick(View v){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.base);
        adapter.clear();
        String str = editText.getText().toString();
        search_hit.clear();
        number_hit.clear();
        for (int i = 0; i < search.size();i++){
            if (search.get(i).matches(".*" + str + ".*")){
                adapter.add(search.get(i));
                if (i <= 6){
                    search_hit.add("base");
                    number_hit.add(i);
                }else if (i <= 50){
                    search_hit.add("block");
                    number_hit.add(i-7);
                }else if (i <= 73){
                    search_hit.add("tool" );
                    number_hit.add(i-51);
                }else if (i <= 78){
                    search_hit.add("armor");
                    number_hit.add(i-74);
                }else if (i <= 88){
                    search_hit.add("vehicle");
                    number_hit.add(i-79);
                }else if (i <= 113){
                    search_hit.add("machine");
                    number_hit.add(i-89);
                }else if (i <= 123){
                    search_hit.add("food");
                    number_hit.add(i-114);
                }else if (i <= 131){
                    search_hit.add("brewing");
                    number_hit.add(i-124);
                }else if (i <= 142){
                    search_hit.add("dye");
                    number_hit.add(i-132);
                }else{
                    search_hit.add("other");
                    number_hit.add(i-143);
                }
            }
        }
        listView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(Search_Activity.this,home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
        return true;
    }
}
