package to.msn.wings.minecraft_memo2.recipe;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import to.msn.wings.minecraft_memo2.R;
import to.msn.wings.minecraft_memo2.home;

/**
 * Created by 4163104 on 2017/10/17.
 */

public class Armor_HelmetsActivity extends AppCompatActivity {

    int viewId;
    int strId;
    int draId;
    int imgviewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("レシピ詳細");

        Intent intent = getIntent();
        int key = intent.getIntExtra("key",0);

        Resources res = getResources();
        strId = res.getIdentifier("armor" + key,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        draId = res.getIdentifier("armorItem" + key,"drawable",getPackageName());
        imgviewId = res.getIdentifier("gif1","id",getPackageName());

        switch (key){
            case 0:
            case 1:
            case 2:
            case 3:
                setContentView(R.layout.base_wood);
                ImageView imageView = (ImageView) findViewById(R.id.gif1);
                GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
                Glide.with(this).load(draId).into(target);
                TextView textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                ImageView imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
                break;
            case 4:
                setContentView(R.layout.base_wood);
                textView = (TextView)findViewById(viewId);
                textView.setText(res.getString(strId));
                imageView1 = (ImageView)findViewById(imgviewId);
                imageView1.setImageDrawable(res.getDrawable(draId));
                break;

        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main2,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(Armor_HelmetsActivity.this,home.class);
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
