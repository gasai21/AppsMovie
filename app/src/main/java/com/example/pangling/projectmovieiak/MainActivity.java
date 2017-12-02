package com.example.pangling.projectmovieiak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.pangling.projectmovieiak.fragmentmovie.movieFragment;
import com.example.pangling.projectmovieiak.fragmentmovie.newmovieFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    BottomBar bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = (BottomBar) findViewById(R.id.bottombarmovie);
        setBottomBarttombar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    private void setBottomBarttombar(){
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            android.support.v4.app.Fragment fragment = null;
            @Override
            public void onTabSelected(int tabId) {
                if(tabId == R.id.tab_new){
                    fragment = new movieFragment();
                }else if(tabId == R.id.tab_video){
                    fragment = new newmovieFragment();
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMovie,fragment)
                        .commit();
            }
        });
    }
}
