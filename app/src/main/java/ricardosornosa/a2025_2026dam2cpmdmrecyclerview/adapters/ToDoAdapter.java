package ricardosornosa.a2025_2026dam2cpmdmrecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ricardosornosa.a2025_2026dam2cpmdmrecyclerview.R;
import ricardosornosa.a2025_2026dam2cpmdmrecyclerview.models.ToDoModel;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoVH> {
    private List<ToDoModel> objects;
    private int resource;
    private Context context;

    public ToDoAdapter(List<ToDoModel> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public ToDoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View toDoView = LayoutInflater.from(context).inflate(resource, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        toDoView.setLayoutParams(lp);
        return new ToDoVH(toDoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoVH holder, int position) {
        ToDoModel td = objects.get(position);
        holder.lblTitulo.setText(td.getTitulo());
        holder.lblContenido.setText(td.getContenido());
        holder.lblFecha.setText(td.getFecha().toString());
        if (td.isCompletado()) {
            holder.btnCompletado.setImageResource(
                    android.R.drawable.checkbox_on_background
            );
        } else {
            holder.btnCompletado.setImageResource(
                    android.R.drawable.checkbox_off_background
            );
        }

        holder.btnCompletado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                td.setCompletado(!td.isCompletado());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ToDoVH extends RecyclerView.ViewHolder {
        TextView lblTitulo, lblContenido, lblFecha;
        ImageButton btnCompletado;

        public ToDoVH(@NonNull View itemView) {
            super(itemView);
            lblTitulo = itemView.findViewById(R.id.lblTituloToDoViewModel);
            lblContenido = itemView.findViewById(R.id.lblContenidoToDoViewModel);
            lblFecha = itemView.findViewById(R.id.lblFechaToDoViewModel);
            btnCompletado = itemView.findViewById(R.id.btnCompletadoToDoViewModel);
        }
    }
}
