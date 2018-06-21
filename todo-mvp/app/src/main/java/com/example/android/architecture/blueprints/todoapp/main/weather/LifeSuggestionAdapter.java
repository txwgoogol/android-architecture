package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseRecyclerViewAdapter;
import com.example.android.architecture.blueprints.todoapp.data.LifeIndex;
import com.example.android.architecture.blueprints.todoapp.data.life.Suggestion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LifeSuggestionAdapter extends BaseRecyclerViewAdapter<LifeSuggestionAdapter.ViewHolder> {

    private Context context;
    private List<LifeIndex> lifeIndices;

    public LifeSuggestionAdapter(Context context, Suggestion suggestion) {
        this.context = context;
        //this.lifeIndices = suggestion.getResults().get(0).getSuggestion();
    }

    @Override
    public LifeSuggestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_life_index, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(LifeSuggestionAdapter.ViewHolder holder, int position) {
        LifeIndex lifeIndex = lifeIndices.get(position);
        holder.indexIconImageView.setImageDrawable(getIndexDrawable(context, lifeIndex.getBrief()));
        holder.indexLevelTextView.setText(lifeIndex.getDetails());
        holder.indexNameTextView.setText(lifeIndex.getBrief());
    }

    @Override
    public int getItemCount() {
        return lifeIndices == null ? 0 : lifeIndices.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.index_icon_image_view)
        ImageView indexIconImageView;
        @BindView(R.id.index_level_text_view)
        TextView indexLevelTextView;
        @BindView(R.id.index_name_text_view)
        TextView indexNameTextView;

        ViewHolder(View itemView, LifeSuggestionAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> adapter.onItemHolderClick(LifeSuggestionAdapter.ViewHolder.this));
        }
    }

    private Drawable getIndexDrawable(Context context, String indexName) {
        int colorResourceId = R.drawable.ic_index_sunscreen;
        if (indexName.contains("防晒")) {
            colorResourceId = R.drawable.ic_index_sunscreen;
        } else if (indexName.contains("穿衣")) {
            colorResourceId = R.drawable.ic_index_dress;
        } else if (indexName.contains("运动")) {
            colorResourceId = R.drawable.ic_index_sport;
        } else if (indexName.contains("逛街")) {
            colorResourceId = R.drawable.ic_index_shopping;
        } else if (indexName.contains("晾晒")) {
            colorResourceId = R.drawable.ic_index_sun_cure;
        } else if (indexName.contains("洗车")) {
            colorResourceId = R.drawable.ic_index_car_wash;
        } else if (indexName.contains("感冒")) {
            colorResourceId = R.drawable.ic_index_clod;
        } else if (indexName.contains("广场舞")) {
            colorResourceId = R.drawable.ic_index_dance;
        }
        return context.getResources().getDrawable(colorResourceId);
    }
}
