package br.edu.uniritter.mobile.nossaprimeiraapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Posts;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<Posts> listaPosts;

    public PostsAdapter(List<Posts> listaPosts) {
        this.listaPosts = listaPosts;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_posts_viewholder, parent, false);

        return new PostsViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaPosts.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        ((TextView) holder.layout.findViewById(R.id.tvUseridp)).setText("UserId: " + listaPosts.get(position).getUserId());
        ((TextView) holder.layout.findViewById(R.id.tvIdp)).setText(" id: " + listaPosts.get(position).getId());
        ((TextView) holder.layout.findViewById(R.id.tvTitlep)).setText(" Title: " +listaPosts.get(position).getTitle()+"");
        ((TextView) holder.layout.findViewById(R.id.tvBodyp)).setText(" Body: " +listaPosts.get(position).getBody()+"\n");
    }


    class PostsViewHolder extends RecyclerView.ViewHolder {
        public View layout;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
