package br.edu.uniritter.mobile.nossaprimeiraapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Comments;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>{

    private List<Comments> listaComments;

    public CommentsAdapter(List<Comments> listaComments) {
        this.listaComments = listaComments;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comments_viewholder, parent, false);

        return new CommentsViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaComments.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder holder, int position) {
        ((TextView) holder.layout.findViewById(R.id.rvPostIdc)).setText(listaComments.get(position).getPostIdc());
        ((TextView) holder.layout.findViewById(R.id.tvIdc)).setText(listaComments.get(position).getIdc());
        ((TextView) holder.layout.findViewById(R.id.tvNamec)).setText(listaComments.get(position).getNamec());
        ((TextView) holder.layout.findViewById(R.id.tvEmailc)).setText(listaComments.get(position).getEmailc()+"");
        ((TextView) holder.layout.findViewById(R.id.tvBodyC)).setText(listaComments.get(position).getBodyc()+"\n");
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}