package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.pokedex.databinding.ActivityP001Binding;

public class p001 extends AppCompatActivity {

    ActivityP001Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //binding
        binding = ActivityP001Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repFragment(new homefrag());

        //newcode
        // Check if extra indicating default fragment is present
        if (getIntent().hasExtra("defaultFragment")) {
            String defaultFragment = getIntent().getStringExtra("defaultFragment");
            // Display bvinfo fragment by default
            if (defaultFragment.equals("bvinfo")) {
                repFragment(new bvinfo());
            } else if (defaultFragment.equals("bvmoves")) {
                // Display bvmoves fragment by default if needed
                repFragment(new bvmoves());
            } else if (defaultFragment.equals("bvplus")) {
                // Display bvplus fragment by default if needed
                repFragment(new bvplus());
            }
        }


        binding.bottomNavView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.info){
                repFragment(new bvinfo());
            } else if (item.getItemId() == R.id.moves) {
                repFragment(new bvmoves());
            } else if (item.getItemId() == R.id.more) {
                repFragment(new bvplus());
            }

            return true;

        });

    }

    private void repFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_out,fragment);
        fragmentTransaction.commit();
    }
}