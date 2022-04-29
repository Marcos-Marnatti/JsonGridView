package br.edu.uniritter.mobile.nossaprimeiraapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Photos;


public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    private List<Photos> listaPhotos;

    public PhotosAdapter(List<Photos> listaPhotos) {
        this.listaPhotos = listaPhotos;
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_photos_viewholder, parent, false);

        return new PhotosViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaPhotos.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosViewHolder holder, int position) {
        ((TextView) holder.layout.findViewById(R.id.rvAlbumph)).setText("Album Id: " + listaPhotos.get(position).getAlbumIdph());
        ((TextView) holder.layout.findViewById(R.id.rvIdph)).setText(" id: " + listaPhotos.get(position).getIdph());
        ((TextView) holder.layout.findViewById(R.id.rvTitleph)).setText(" Title: " + listaPhotos.get(position).getTittleph());
        ((TextView) holder.layout.findViewById(R.id.rvUrlph)).setText(" Url: " +listaPhotos.get(position).getUrlph()+"");
        ((TextView) holder.layout.findViewById(R.id.rvThumbnailph)).setText(" Thumbnail URL: " +listaPhotos.get(position).getThumbnailph()+"\n");
    }


    class PhotosViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
