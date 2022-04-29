package br.edu.uniritter.mobile.nossaprimeiraapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Users;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsuarioViewHolder>{

    private List<Users> listaUsers;

    public UsersAdapter(List<Users> listaUsers) {
        this.listaUsers = listaUsers;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_usuario_viewholder, parent, false);

        return new UsuarioViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaUsers.size();
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        ((TextView) holder.layout.findViewById(R.id.tvId)).setText(listaUsers.get(position).getId());
        ((TextView) holder.layout.findViewById(R.id.tvName)).setText(listaUsers.get(position).getName());
        ((TextView) holder.layout.findViewById(R.id.tvUsername)).setText(listaUsers.get(position).getUsername()+"");
        ((TextView) holder.layout.findViewById(R.id.tvEmail)).setText(listaUsers.get(position).getEmail()+"\n");
    }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
    }