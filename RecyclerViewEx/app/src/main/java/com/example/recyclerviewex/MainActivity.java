package com.example.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyclerviewex.adapters.ItemAdapter;
import com.example.recyclerviewex.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> items;
    List<ItemModel> tempItems;
    EditText inputSearch;
    Button favButton;
    boolean showFavorite = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Faker faker = new Faker();

        items = new ArrayList<ItemModel>();
        tempItems = new ArrayList<ItemModel>();
        for (int i = 0; i < 10; i++) {
            items.add(new ItemModel(faker.name.firstName(), faker.lorem.paragraph(), "12:20AM"));
            tempItems.add(items.get(i));
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        inputSearch = findViewById(R.id.search);
        favButton = findViewById(R.id.show_favorite);



        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final ItemAdapter adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MainActivity.this.showFavorite) {
                    adapter.getFilterFav().filter("check");

                    MainActivity.this.showFavorite = true;

                }else{
                    adapter.getFilterFav().filter("");
                    MainActivity.this.showFavorite = false;
                }
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
