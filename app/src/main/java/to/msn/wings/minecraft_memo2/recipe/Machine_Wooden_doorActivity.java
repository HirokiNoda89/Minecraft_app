package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import to.msn.wings.minecraft_memo2.R;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class Machine_Wooden_doorActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int key = intent.getIntExtra("key",0);

        switch (key){
            case 0:
                setContentView(R.layout.block_ore);
                break;
            case 1:
                setContentView(R.layout.block_ore);
                break;
            case 2:
                setContentView(R.layout.block_ore);
                break;
            case 3:
                setContentView(R.layout.block_ore);
                break;
            case 4:
                setContentView(R.layout.block_ore);
                break;
            case 5:
                setContentView(R.layout.block_ore);
                break;
            case 6:
                setContentView(R.layout.block_ore);
                break;
            case 7:
                setContentView(R.layout.block_ore);
                break;
            case 8:
                setContentView(R.layout.block_ore);
                break;
            case 9:
                setContentView(R.layout.block_ore);
                break;
            case 10:
                setContentView(R.layout.block_ore);
                break;
            case 11:
                setContentView(R.layout.block_ore);
                break;
            case 12:
                setContentView(R.layout.block_ore);
                break;
            case 13:
                setContentView(R.layout.block_ore);
                break;
            case 14:
                setContentView(R.layout.block_ore);
                break;
            case 15:
                setContentView(R.layout.block_ore);
                break;
            case 16:
                setContentView(R.layout.block_ore);
                break;
            case 17:
                setContentView(R.layout.block_ore);
                break;
            case 18:
                setContentView(R.layout.block_ore);
                break;
            case 19:
                setContentView(R.layout.block_ore);
                break;
            case 20:
                setContentView(R.layout.block_ore);
                break;
            case 21:
                setContentView(R.layout.block_ore);
                break;
            case 22:
                setContentView(R.layout.block_ore);
                break;
            case 23:
                setContentView(R.layout.block_ore);
                break;
            case 24:
                setContentView(R.layout.block_ore);
                break;
        }
    }
}
