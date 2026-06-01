package com.example.galeriestars;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {

    private List<Star> stars;
    private int lastPosition = -1;

    public StarAdapter(List<Star> stars) {
        this.stars = stars;
    }

    public void updateList(List<Star> newList) {
        this.stars = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_star, parent, false);
        return new StarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = stars.get(position);
        holder.tvName.setText(star.getName());
        holder.tvCategory.setText(star.getCategory());
        holder.ratingBar.setRating(star.getRating());
        holder.imgStar.setImageResource(star.getImageRes());

        // Animation d'entrée
        if (position > lastPosition) {
            android.view.animation.Animation anim =
                AnimationUtils.loadAnimation(holder.itemView.getContext(),
                    android.R.anim.slide_in_left);
            holder.itemView.startAnimation(anim);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return stars.size();
    }

    static class StarViewHolder extends RecyclerView.ViewHolder {
        ImageView imgStar;
        TextView tvName, tvCategory;
        RatingBar ratingBar;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            imgStar = itemView.findViewById(R.id.imgStar);
            tvName = itemView.findViewById(R.id.tvName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
