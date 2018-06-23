package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseRecyclerViewAdapter;
import com.example.android.architecture.blueprints.todoapp.data.LifeIndex;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.architecture.blueprints.todoapp.util.CCTable.getIndexDrawable;

public class LifeIndexAdapter extends BaseRecyclerViewAdapter<LifeIndexAdapter.ViewHolder> {

    private static final String TAG = "LifeIndexAdapter";

    private Context context;
    private List<LifeIndex> lifeIndexList;

    public LifeIndexAdapter(Context context, List<LifeIndex> lifeIndexList) {
        this.context = context;
        this.lifeIndexList = lifeIndexList;
    }

    @Override
    public LifeIndexAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_life_index, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(LifeIndexAdapter.ViewHolder holder, int position) {
        LifeIndex lifeIndex = lifeIndexList.get(position);
        holder.indexIconImageView.setImageDrawable(getIndexDrawable(context, lifeIndex.getName()));
        holder.indexLevelTextView.setText(lifeIndex.getIndex());
        holder.indexNameTextView.setText(lifeIndex.getName());
    }

    @Override
    public int getItemCount() {
        return lifeIndexList == null ? 0 : lifeIndexList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.index_icon_image_view)
        ImageView indexIconImageView;
        @BindView(R.id.index_level_text_view)
        TextView indexLevelTextView;
        @BindView(R.id.index_name_text_view)
        TextView indexNameTextView;

        ViewHolder(View itemView, LifeIndexAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //itemView.setOnClickListener(v -> adapter.onItemHolderClick(LifeIndexAdapter.ViewHolder.this));
        }
    }

}