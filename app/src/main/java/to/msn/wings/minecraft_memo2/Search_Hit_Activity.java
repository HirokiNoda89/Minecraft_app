package to.msn.wings.minecraft_memo2;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by 4163104 on 2017/12/19.
 */

public class Search_Hit_Activity extends AppCompatActivity {

    int viewId;
    int strId;
    int draId;
    int imgviewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("詳細");

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        int strid = intent.getIntExtra("nameid",-1);

        Resources res = getResources();
        strId = res.getIdentifier(""+ str + strid,"string",getPackageName());
        viewId = res.getIdentifier("textView","id",getPackageName());
        draId = res.getIdentifier("" + str + "Item" + strid,"drawable",getPackageName());
        imgviewId = res.getIdentifier("gif1","id",getPackageName());

        setContentView(R.layout.base_wood);
        TextView textView = (TextView)findViewById(viewId);
        textView.setText(res.getString(strId));
//        ImageView imageView1 = (ImageView)findViewById(imgviewId);
//        imageView1.setImageDrawable(res.getDrawable(draId));
        ImageView imageView = (ImageView) findViewById(R.id.gif1);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(draId).into(target);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
