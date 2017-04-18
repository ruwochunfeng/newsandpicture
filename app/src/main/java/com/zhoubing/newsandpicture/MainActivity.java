package com.zhoubing.newsandpicture;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.zhoubing.newsandpicture.Adater.FruitAdapter;
import com.zhoubing.newsandpicture.Adater.newsAdapter;
import com.zhoubing.newsandpicture.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
//    private Fruit  fruit =new Fruit("APPLE",R.drawable.tupian);
    private News news = new News(R.drawable.mail,"邮件","来自朋友祝福的邮件，谢谢");
//    private List<Fruit> mList = new ArrayList<>();
    private List<News> mNewsList = new ArrayList<>();
//    private FruitAdapter adapter ;
    private newsAdapter newsAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initFruit();
        initNews();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        ActionBar actionBar = getSupportActionBar();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerview);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //  GridLayoutManager grid = new GridLayoutManager(this,2);

        //  recycler.setLayoutManager(grid);

//        adapter = new FruitAdapter(mList);
        newsAdapter1 = new newsAdapter(mNewsList);
        recycler.setAdapter(newsAdapter1);

        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

    }

//    private void initFruit() {
//        mList.clear();
//        for(int i = 0;i<40;i++){
//            mList.add(fruit);
//        }
//    }

    private void initNews(){
        mNewsList.clear();
        for(int i = 0;i<20;i++){
            mNewsList.add(news);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                Toast.makeText(this,"backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return  true;
    }
}
