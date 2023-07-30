package learning.android.learning_listview_in_android;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import learning.android.learning_listview_in_android.CountryEx.CustomAdapter;
import learning.android.learning_listview_in_android.CountryEx2.CustomAdapter2;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter2 adapter;
    ArrayList<CountryModelClass> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // AdapterView: a ListView
        listView = findViewById(R.id.lv_mainCountryList);
        // Data source
        arrayList = new ArrayList<>();
        arrayList.add(new CountryModelClass("Brazil", "5", R.drawable.brazil));
        arrayList.add(new CountryModelClass("Germany", "4", R.drawable.germany));
        arrayList.add(new CountryModelClass("France", "2", R.drawable.france));
        // Adapter
        adapter = new CustomAdapter2(this, R.layout.item_list_layout,arrayList,arrayList);
        listView.setAdapter(adapter);

        // Handling click events on ListView items
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the data item for this position
            CountryModelClass model = arrayList.get(position);
            // Extract strings from the data item
            String countryName = model.getCountryName();
            String cupWinCount = model.getCup_win_count();
            // Display the strings in a Toast
            Toast.makeText(MainActivity.this, countryName + " has won " + cupWinCount + " World Cups", Toast.LENGTH_SHORT).show();
        });
    }
}
