package br.edu.uniritter.mobile.nossaprimeiraapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Todos;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder> {

    private List<Todos> listaTodos;

    public TodosAdapter(List<Todos> listaTodos) {
        this.listaTodos = listaTodos;
    }

    @NonNull
    @Override
    public TodosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_todos_viewholder, parent, false);

        return new TodosViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaTodos.size();
    }

    @Override
    public void onBindViewHolder(@NonNull TodosViewHolder holder, int position) {
        ((TextView) holder.layout.findViewById(R.id.tvUserid)).setText("UserId: " + listaTodos.get(position).getUserId());
        ((TextView) holder.layout.findViewById(R.id.tvId)).setText(" id: " + listaTodos.get(position).getId());
        ((TextView) holder.layout.findViewById(R.id.tvTitle)).setText(" Title: " +listaTodos.get(position).getTitle()+"");
        ((TextView) holder.layout.findViewById(R.id.tvCompleted)).setText(" Completed: " +listaTodos.get(position).isCompleted()+"");
    }


    class TodosViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public TodosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
