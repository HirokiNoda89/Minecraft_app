package to.msn.wings.minecraft_memo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import to.msn.wings.minecraft_memo2.recipe.RecipeActivity;

/**
 * Created by 4163104 on 2017/09/07.
 */

public class home extends AppCompatActivity {
    ListView listview;
    String[] members = {"ワールド","レシピ","レシピ検索","精錬とは"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.base);
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
                        Intent i1 = new Intent(home.this,ListActivity.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2 = new Intent(home.this,RecipeActivity.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(home.this,Search_Activity.class);
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4 = new Intent(home.this,Web_Activity.class);
                        startActivity(i4);
                        break;

                }
            }
        });
    }


}
