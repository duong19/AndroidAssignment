package com.example.gmailexample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GmailAdapter extends BaseAdapter {
    List<GmailModel> items;

    public GmailAdapter(List<GmailModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mail, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textRound = convertView.findViewById(R.id.text_round);
            viewHolder.description = convertView.findViewById(R.id.description);
            viewHolder.title = convertView.findViewById(R.id.title);
            viewHolder.time = convertView.findViewById(R.id.time);
            viewHolder.imgFavorite = convertView.findViewById(R.id.img_favorite);
            convertView.setTag(viewHolder);

        }else
            viewHolder = (ViewHolder) convertView.getTag();

        final GmailModel item = items.get(position);
        viewHolder.title.setText(item.getTitle());
        viewHolder.textRound.setText(item.getTitle().substring(0,1));
        viewHolder.time.setText(item.getTime());
        viewHolder.description.setText(item.getDescription());
        viewHolder.textRound.getBackground().setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_ATOP);
        if (item.isFavorite()){
            viewHolder.imgFavorite.setImageResource(R.drawable.ic_star_yellow);
        }else
            viewHolder.imgFavorite.setImageResource(R.drawable.ic_star_normal);
        viewHolder.imgFavorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                boolean isChecked = items.get(position).isFavorite();
                items.get(position).setFavorite(!isChecked);
                notifyDataSetChanged();

            }
        });
        return convertView;
    }
    class  ViewHolder{
        TextView textRound;
        TextView title;
        TextView description;
        TextView time;
        ImageView imgFavorite;
    }
}
