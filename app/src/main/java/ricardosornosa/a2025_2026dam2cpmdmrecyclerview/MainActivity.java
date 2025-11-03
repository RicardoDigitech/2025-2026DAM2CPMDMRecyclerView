package ricardosornosa.a2025_2026dam2cpmdmrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

import ricardosornosa.a2025_2026dam2cpmdmrecyclerview.adapters.ToDoAdapter;
import ricardosornosa.a2025_2026dam2cpmdmrecyclerview.databinding.ActivityMainBinding;
import ricardosornosa.a2025_2026dam2cpmdmrecyclerview.models.ToDoModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<ToDoModel> toDoList;
    private ToDoAdapter adapter;
    private RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        toDoList = new ArrayList<>();
        crearTareas();
        adapter = new ToDoAdapter(
                toDoList,
                R.layout.to_do_view_model,
                MainActivity.this
        );
        lm = new LinearLayoutManager(MainActivity.this);

        binding.contentMain.contenedorMain.setAdapter(adapter);
        binding.contentMain.contenedorMain.setLayoutManager(lm);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void crearTareas() {
        for (int i = 0; i < 1000000; i++) {
            ToDoModel td = new ToDoModel(
                    "Título " + i,
                    "Contenido " + i
            );
            toDoList.add(td);
        }
    }
}