package to.msn.wings.minecraft_memo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by 4163104 on 2017/12/18.
 */

public class Search_Activity extends AppCompatActivity {

    EditText editText;
    Globals globals;
    ArrayList<String> search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        editText = (EditText) findViewById(R.id.editText);
        globals = (Globals) this.getApplication();
        globals.GlobalsInit();
        search = new ArrayList<>();

        for (String str : globals.base_member){
            search.add(str);
        }

        for (String str : globals.block_member){
            search.add(str);
        }

        for (String str : globals.tool_member){
            search.add(str);
        }

        for (String str : globals.armor_member){
            search.add(str);
        }

        for (String str : globals.truck_member){
            search.add(str);
        }

        for (String str : globals.machine_member){
            search.add(str);
        }

        for (String str : globals.food_member){
            search.add(str);
        }

        for (String str : globals.brewing_member){
            search.add(str);
        }

        for (String str : globals.dye_member){
            search.add(str);
        }

        for (String str : globals.other_member){
            search.add(str);
        }

        int id = search.indexOf("トロッコ");
        String str = search.get(id);
        Log.i("zl",str);
    }
}
