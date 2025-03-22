package com.example.excercise3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load NewsListFragment as default on startup
        if (savedInstanceState == null) {
            loadFragment(new NewsListFragment());
        }

        // Bottom navigation setup
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_articles) {
                loadFragment(new NewsListFragment());
                return true;
            } else if (item.getItemId() == R.id.nav_favorites) {
                loadFragment(new FavoritesFragment());
                return true;
            }
            return false;
        });
    }

    // Method to load the fragment dynamically
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // Method to open the details in a new activity
    public void openDetailActivity(long id) {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra("news_id", id);
        startActivity(intent);
    }


    // Inflate menu (for refresh/settings in Action Bar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            // Handle refresh action
            refreshList();
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            // Handle settings action
            openSettings();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Example methods:
    private void refreshList() {
        loadFragment(new NewsListFragment());
    }

    private void openSettings() {
        // Example: Start a Settings activity (create if needed)
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }



    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            // Refresh the list
            refreshList();
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            // Open settings (if you have one)
            openSettings();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Method to refresh the news list (reload fragment)
    private void refreshList() {
        loadFragment(new NewsListFragment());
    }

    // Placeholder for opening settings
    private void openSettings() {
        // Add intent to open settings activity if needed
    }
}
