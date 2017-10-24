package to.msn.wings.minecraft_memo2.recipe;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import to.msn.wings.minecraft_memo2.R;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class Other_EnchantmentTable_Activity extends Activity {

    int viewId;
    int strId;
    int draId;
    int imgviewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int key = intent.getIntExtra("key",0);

        Resources res = getResources();
        strId = res.getIdentifier("text" + key,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        draId = res.getIdentifier("item" + key,"drawable",getPackageName());
        imgviewId = res.getIdentifier("imageview","id",getPackageName());




        switch (key){
            case 0:
                setContentView(R.layout.other_enchantmenttable);
                break;
            case 1:
                setContentView(R.layout.other_anvil);
                break;
            case 2:
                setContentView(R.layout.other_beacon);
                break;
            case 3:
                setContentView(R.layout.other_ore);
                ImageView imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(R.drawable.ore_iloveimg_resized).into(target);
                break;
            case 4:
                setContentView(R.layout.other_gold_ingot);
                break;
            case 5:
                setContentView(R.layout.other_goldnugget);
                break;
            case 6:
                setContentView(R.layout.other_iron_ingot);
                break;
            case 7:
                setContentView(R.layout.other_ironnugget);
                break;
            case 8:
                setContentView(R.layout.other_redstone);
                break;
            case 9:
                setContentView(R.layout.other_painting);
                break;
            case 10:
                setContentView(R.layout.other_item_frame);
                break;
            case 11:
                setContentView(R.layout.other_flowerpot);
                break;
            case 12:
                setContentView(R.layout.other_sign);
                break;
            case 13:
                setContentView(R.layout.other_ladder);
                break;
            case 14:
                setContentView(R.layout.other_paper);
                TextView textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                ImageView imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
                break;
            case 15:
                setContentView(R.layout.other_paper);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
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
                setContentView(R.layout.block_stainedglass);
                break;
            case 24:
                setContentView(R.layout.block_slimeblock);
                break;
            case 25:
                setContentView(R.layout.block_granite);
                break;
            case 26:
                setContentView(R.layout.block_andesite);
                break;
            case 27:
                setContentView(R.layout.block_diorite);
                break;
            case 28:
                setContentView(R.layout.block_polishedgranite);
                break;
            case 29:
                setContentView(R.layout.block_polishedandesite);
                break;
            case 30:
                setContentView(R.layout.block_polisheddiorite);
                break;
            case 31:
                setContentView(R.layout.block_mossstone);
                break;
            case 32:
                setContentView(R.layout.block_coarsedirt);
                break;
            case 33:
                setContentView(R.layout.block_prismarine);
                break;
            case 34:
                setContentView(R.layout.block_prismarinebricks);
                break;
            case 35:
                setContentView(R.layout.block_darkprismarine);
                break;
            case 36:
                setContentView(R.layout.base_chest);
                break;
        }
    }
}
