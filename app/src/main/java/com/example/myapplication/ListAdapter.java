package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Team> values;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView iconTeam;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            iconTeam = (ImageView) v.findViewById(R.id.icon);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);

        }

    }

    public void add(int position, Team item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Team> myDataset, Context ct) {
        values = myDataset;
        context = ct;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Team currentTeam = values.get(position);
        holder.txtHeader.setText(currentTeam.getName());
        holder.txtFooter.setText(String.valueOf(currentTeam.getPosition()));
        Glide.with(holder.itemView.getContext()).load(currentTeam.getIcon()).into(holder.iconTeam);

        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openNewActivity();
                Intent intent = new Intent(context, InfoTeams.class);
                intent.putExtra("name", currentTeam.getName());
                intent.putExtra("position", currentTeam.getPosition());
                intent.putExtra("points", currentTeam.getPoints());
                intent.putExtra("won", currentTeam.getWon());
                intent.putExtra("draw", currentTeam.getDrawn());
                intent.putExtra("lost", currentTeam.getLost());
                //intent.putExtra("icon", currentTeam.getIcon());

                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }
}