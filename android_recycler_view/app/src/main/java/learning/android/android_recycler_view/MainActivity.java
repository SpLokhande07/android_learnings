package learning.android.android_recycler_view;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    // 1. Create RecyclerView object
    RecyclerView recyclerView;

    //2. Data source
    VaccineModel[] vaccineModel;


    //3. Create Adapter object
    VaccineAdapter vaccineAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 4. Find RecyclerView by id

        recyclerView = findViewById(R.id.recycler_view);
        vaccineModel = new VaccineModel[]{
                // Create 9 objects of VaccineModel with unique name

                new VaccineModel("Covaxin"),
                new VaccineModel("Pfizer"),
                new VaccineModel("Covishield"),

                new VaccineModel("Covaxin"),
                new VaccineModel("Pfizer"),
                new VaccineModel("Covishield"),

                new VaccineModel("Covaxin"),
                new VaccineModel("Pfizer"),
                new VaccineModel("Covishield"),
        };


        vaccineAdapter = new VaccineAdapter(vaccineModel);
        vaccineAdapter.setClickListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(vaccineAdapter);


    }


    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        Toast.makeText(this, "Clicked on "+vaccineModel[position].getName(), Toast.LENGTH_SHORT).show();
    }
}
