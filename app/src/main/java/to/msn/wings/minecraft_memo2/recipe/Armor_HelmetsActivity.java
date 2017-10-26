package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import to.msn.wings.minecraft_memo2.R;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class Armor_HelmetsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int key = intent.getIntExtra("key",0);

        switch (key){
            case 0:
                setContentView(R.layout.base_wood);
                break;

        }
    }
}
