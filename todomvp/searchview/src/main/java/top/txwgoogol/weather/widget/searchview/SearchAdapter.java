package top.txwgoogol.weather.widget.searchview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.txwgoogol.top.weather.widget.searchview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suggestions Adapter.
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class SearchAdapter extends BaseAdapter implements Filterable {

    private static final String TAG = "SearchAdapter";

    private ArrayList<String> data;
    private String[] suggestions;
    private Drawable suggestionIcon;
    private LayoutInflater inflater;
    private boolean ellipsize;

    public SearchAdapter(Context context, String[] suggestions) {
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        this.suggestions = suggestions;
    }

    public SearchAdapter(Context context, String[] suggestions, Drawable suggestionIcon, boolean ellipsize) {
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        this.suggestions = suggestions;
        this.suggestionIcon = suggestionIcon;
        this.ellipsize = ellipsize;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (!TextUtils.isEmpty(constraint)) {

                    /*
                    // Retrieve the autocomplete results.
                    List<String> searchData = new ArrayList<>();
                    for (String string : suggestions) {
                        //startsWith用法   https://www.yiibai.com/java/java_string_startswith.html
                        if (string.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                            searchData.add(string);
                        }
                    }
                     */

                    //过滤数据  https://github.com/MiguelCatalan/MaterialSearchView/issues/94
                    List searchData = new ArrayList<>();
                    searchData.addAll(Arrays.asList(suggestions));

                    // Assign the data to the FilterResults
                    filterResults.values = searchData;
                    filterResults.count = searchData.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.values != null) {
                    data = (ArrayList<String>) results.values;
                    notifyDataSetChanged();
                }
            }
        };
        return filter;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SuggestionsViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.suggest_item, parent, false);
            viewHolder = new SuggestionsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (SuggestionsViewHolder) convertView.getTag();
        }

        String currentListData = (String) getItem(position);

        viewHolder.textView.setText(currentListData);
        if (ellipsize) {
            viewHolder.textView.setSingleLine();
            viewHolder.textView.setEllipsize(TextUtils.TruncateAt.END);
        }

        return convertView;
    }

    private class SuggestionsViewHolder {

        TextView textView;
        ImageView imageView;

        public SuggestionsViewHolder(View convertView) {
            textView = (TextView) convertView.findViewById(R.id.suggestion_text);
            if (suggestionIcon != null) {
                imageView = (ImageView) convertView.findViewById(R.id.suggestion_icon);
                imageView.setImageDrawable(suggestionIcon);
            }
        }
    }

}