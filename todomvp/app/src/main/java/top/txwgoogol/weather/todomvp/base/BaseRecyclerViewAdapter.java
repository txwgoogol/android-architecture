package top.txwgoogol.weather.todomvp.base;

import androidx.recyclerview.widget.RecyclerView;

import android.widget.AdapterView;

/**
 * RecyclerView.ViewHolder 基类 做一些适配工作
 *
 * @param <T> 范型 根据传入的类决定和谁适配
 * @author txw
 * @// TODO: 04/12/18
 */
public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    //点击事件
    private AdapterView.OnItemClickListener onItemClickListener;
    //长按事件
    private AdapterView.OnItemLongClickListener onItemLongClickListener;

    /**
     * item 单击事件
     *
     * @param onItemClickListener 单机事件监听器
     */
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * item长按事件
     *
     * @param onItemLongClickListener 长按事件监听器
     */
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    //设置点击事件
    protected void onItemHolderClick(RecyclerView.ViewHolder itemHolder) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(null, itemHolder.itemView, itemHolder.getAdapterPosition(), itemHolder.getItemId());
        } else {
            throw new IllegalStateException("Please call setOnItemClickListener method set the click event listeners");
        }
    }

    //设置长按事件
    protected void onItemHolderLongClick(RecyclerView.ViewHolder itemHolder) {
        if (onItemLongClickListener != null) {
            onItemLongClickListener.onItemLongClick(null, itemHolder.itemView, itemHolder.getAdapterPosition(), itemHolder.getItemId());
        } else {
            throw new IllegalStateException("Please call setOnItemLongClickListener method set the click event listeners");
        }
    }

}
