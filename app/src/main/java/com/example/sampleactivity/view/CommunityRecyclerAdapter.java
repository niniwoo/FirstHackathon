package com.example.sampleactivity.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleactivity.R;
import com.google.android.material.snackbar.Snackbar;

public class CommunityRecyclerAdapter extends  RecyclerView.Adapter<CommunityRecyclerAdapter.ViewHolder>{

    private String[] cDate = {"Oct.7th.2022","Oct.8th.2022","Oct.10th.2022",
            "Oct.11th.2022"};
    private String[] cTitle ={"The worst day" , "Better than yesterday",
            "title2","title3","title4"};


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.community_card_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.commDate.setText(cDate[i]);
        viewHolder.commTitle.setText(cTitle[i]);
    }

    @Override
    public int getItemCount() {
        return cDate.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView commDate;
        TextView commTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commDate = itemView.findViewById(R.id.comm_date);
            commTitle = itemView.findViewById(R.id.comm_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Snackbar.make(view,"Click detected on item"+position, Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
            });
        }
    }
}
