package com.example.github;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepoViewHolder> {

    Repository[] repoarray;
    Context mContext;

    public RepositoryAdapter(Repository[] repoarray, Context context) {
        this.repoarray = repoarray;
        mContext = context;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemview=inflater.inflate(R.layout.repo_item,parent,false);
        RepoViewHolder viewHolder=new RepoViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        Repository repo=repoarray[position];
        holder.reponame.setText(repo.name);
        holder.language.setText(repo.language);
        holder.description.setText(repo.description);
    }

    @Override
    public int getItemCount() {
        return repoarray.length;
    }

    class RepoViewHolder extends RecyclerView.ViewHolder{

        TextView reponame,description,language;
        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            reponame=(TextView)itemView.findViewById(R.id.name);
            description=(TextView)itemView.findViewById(R.id.desc);
            language=(TextView)itemView.findViewById(R.id.lang);
        }
    }
}
