package com.hanynemr.yat730cloudapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    ListView lvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        lvMovies = findViewById(R.id.lvMovies);

        DataQueryBuilder builder = DataQueryBuilder.create();
//        builder.setWhereClause("genre ='horror'");
        builder.setSortBy("title");
        Backendless.Data.of(Movie.class).find(builder, new AsyncCallback<List<Movie>>() {
            @Override
            public void handleResponse(List<Movie> response) {
                ArrayList<String> names = new ArrayList<>();
                for (Movie movie : response) {
                    names.add(movie.getTitle());
                }

                ArrayAdapter adapter = new ArrayAdapter(MovieActivity.this, android.R.layout.simple_list_item_1
                        , names);
                lvMovies.setAdapter(adapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(MovieActivity.this, "movies loading problem", Toast.LENGTH_SHORT).show();

            }
        });
    }
}