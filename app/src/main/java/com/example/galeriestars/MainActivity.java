package com.example.galeriestars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StarAdapter adapter;
    private List<Star> allStars = new ArrayList<>();
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);

        // Données
        allStars.add(new Star("Scarlett Johansson", "Actrice", 4.8f, R.drawable.ic_launcher_background));
        allStars.add(new Star("Leonardo DiCaprio", "Acteur", 4.9f, R.drawable.ic_launcher_background));
        allStars.add(new Star("Beyoncé", "Chanteuse", 5.0f, R.drawable.ic_launcher_background));
        allStars.add(new Star("Cristiano Ronaldo", "Footballeur", 4.7f, R.drawable.ic_launcher_background));
        allStars.add(new Star("Rihanna", "Chanteuse", 4.8f, R.drawable.ic_launcher_background));
        allStars.add(new Star("Tom Hanks", "Acteur", 4.9f, R.drawable.ic_launcher_background));
        allStars.add(new Star("Adele", "Chanteuse", 4.7f, R.drawable.ic_launcher_background));
        allStars.add(new Star("Lionel Messi", "Footballeur", 5.0f, R.drawable.ic_launcher_background));

        // Adapter + LayoutManager
        adapter = new StarAdapter(new ArrayList<>(allStars));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Filtrage
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterStars(newText);
                return true;
            }
        });
    }

    private void filterStars(String query) {
        List<Star> filtered = new ArrayList<>();
        for (Star s : allStars) {
            if (s.getName().toLowerCase().contains(query.toLowerCase())
                    || s.getCategory().toLowerCase().contains(query.toLowerCase())) {
                filtered.add(s);
            }
        }
        adapter.updateList(filtered);
    }
}
