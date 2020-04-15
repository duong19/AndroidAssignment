package com.example.gmailexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<GmailModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        items = new ArrayList<>();
        Faker faker = new Faker();

        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"1:30AM",false, "#5E97F6"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"12:34PM",false,"#FF8867"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"12:24PM",false,"#9BCA64"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"9:34AM",false,"#94A5AD"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"4:34PM",false, "#5E97F6"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"7:44PM",false,"#B1D482"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"5:54PM",false,"#FF8867"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"1:34PM",false,"#9BCA64"));
        items.add(new GmailModel(faker.name.firstName(),faker.lorem.paragraph(),"2:34PM",false,"#9BCA64"));


        GmailAdapter gmailAdapter = new GmailAdapter(items);
        listView.setAdapter(gmailAdapter);
    }
}
