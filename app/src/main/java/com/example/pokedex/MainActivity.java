package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        findViewById(R.id.sbmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { drawerLayout.openDrawer(GravityCompat.START);}
        });

        //custom Icons
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        //side drawer
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        //button
        button = (Button) findViewById(R.id.searchIcon);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {openSearch();}
        });
    }
    public void openSearch(){
        Intent i = new Intent(this, searchpoke.class);
        startActivity(i);
    }

}