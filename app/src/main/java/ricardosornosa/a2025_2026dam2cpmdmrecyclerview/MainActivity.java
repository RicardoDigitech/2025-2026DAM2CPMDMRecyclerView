package ricardosornosa.a2025_2026dam2cpmdmrecyclerview;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

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
        //crearTareas();
        adapter = new ToDoAdapter(
                toDoList,
                R.layout.to_do_view_model,
                MainActivity.this
        );
        lm = new GridLayoutManager(MainActivity.this, 1);

        binding.contentMain.contenedorMain.setAdapter(adapter);
        binding.contentMain.contenedorMain.setLayoutManager(lm);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearTarea().show();
            }
        });
    }

    private AlertDialog crearTarea() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CREAR TAREA");
        builder.setCancelable(false);

        View toDoAlert = LayoutInflater.from(this).inflate(
                R.layout.to_do_model_alert, null
        );
        EditText txtTitulo = toDoAlert
                .findViewById(R.id.txtTituloToDoModelAlert);
        EditText txtContenido = toDoAlert
                .findViewById(R.id.txtContenidoToDoModelAlert);
        builder.setView(toDoAlert);

        builder.setNegativeButton("CANCELAR", null);
        builder.setPositiveButton("CREAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String titulo = txtTitulo.getText().toString();
                String contenido = txtContenido.getText().toString();

                if (!titulo.isEmpty() && !contenido.isEmpty()) {
                    ToDoModel td = new ToDoModel(titulo, contenido);
                    toDoList.add(td);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        return builder.create();
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