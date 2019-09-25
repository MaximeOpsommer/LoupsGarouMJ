package maximeopsommer.android.loupsgaroumj.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import maximeopsommer.android.loupsgaroumj.R;

import java.util.List;

public class PlayerListAdapter extends BaseAdapter implements ListAdapter {

    private final List<String> list;
    private final Context context;

    public PlayerListAdapter(final List<String> list, final Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(final int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater == null) return null;
            view = inflater.inflate(R.layout.player_list, null);
        }

        //Handle TextView and display string from your list
        final TextView listItemText = view.findViewById(R.id.playerName);
        listItemText.setText(list.get(position));

        //Handle buttons and add onClickListeners
        final ImageButton deleteBtn = view.findViewById(R.id.playerRemove);

        deleteBtn.setOnClickListener(v -> {
            //do something
            list.remove(position); //or some other task
            notifyDataSetChanged();
        });

        return view;
    }
}
