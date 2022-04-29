package br.edu.uniritter.mobile.nossaprimeiraapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Albums;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Comments;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>{

    private List<Albums> listaAlbums;

    public AlbumsAdapter(List<Albums> listaAlbums) {
        this.listaAlbums = listaAlbums;
    }

    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_albums_viewholder, parent, false);

        return new AlbumsViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaAlbums.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, int position) {
        ((TextView) holder.layout.findViewById(R.id.rvUserIda)).setText(listaAlbums.get(position).getUserIda());
        ((TextView) holder.layout.findViewById(R.id.rvIda)).setText(listaAlbums.get(position).getIda());
        ((TextView) holder.layout.findViewById(R.id.rvtittlea)).setText(listaAlbums.get(position).getTittlea());

    }

    class AlbumsViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public AlbumsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}