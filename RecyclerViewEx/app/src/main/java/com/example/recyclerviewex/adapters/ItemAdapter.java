package com.example.recyclerviewex.adapters;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewex.R;
import com.example.recyclerviewex.models.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  implements Filterable {
    List<ItemModel> items;
    List<ItemModel> itemsFiltered;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
        this.itemsFiltered = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmailViewHolder viewHolder = (EmailViewHolder) holder;
        ItemModel item = itemsFiltered.get(position);

        viewHolder.textRound.setText(item.getTitle().substring(0, 1));
        Drawable background = viewHolder.textRound.getBackground();
        background.setColorFilter(new PorterDuffColorFilter(item.getColor(), PorterDuff.Mode.SRC_ATOP));

        viewHolder.title.setText(item.getTitle());
        viewHolder.time.setText(item.getTime());
        viewHolder.description.setText(item.getDescription());
        if (item.isFavorite()) {
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_fav);
        }else
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_normal);
    }

    @Override
    public int getItemCount() {
        return itemsFiltered.size();
    }

    @Override
    public Filter getFilter(){
        return filterEmail;
    }
    public Filter getFilterFav(){
        return  filterFav;
    }
    private Filter filterEmail = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<ItemModel> filteredList = new ArrayList<>();
                String charString = constraint.toString();
                if (charString.isEmpty())
                        filteredList = items;
                else{
                    for (ItemModel mail : items){
                        if (mail.getTitle().toLowerCase().contains(charString.toLowerCase()) || mail.getDescription().toLowerCase().contains(charString.toLowerCase()))
                        {
                            filteredList.add(mail);
                        }
                    }


                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return  filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemsFiltered = (ArrayList<ItemModel>) results.values;
                notifyDataSetChanged();
            }
        };

    private Filter filterFav = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ItemModel> filteredList = new ArrayList<>();
            String charString = constraint.toString();
            if (charString.isEmpty())
                filteredList = items;
            else{
                for (ItemModel mail : items){
                    if (mail.isFavorite())
                    {
                        filteredList.add(mail);
                    }
                }


            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return  filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            itemsFiltered = (ArrayList<ItemModel>) results.values;
            notifyDataSetChanged();
        }
    };
    public void setItems(List<ItemModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView textRound;
        TextView title;
        TextView description;
        TextView time;
        ImageView imageFavorite;

        public EmailViewHolder(@NonNull View itemView){
            super(itemView);
            textRound = itemView.findViewById(R.id.text_round);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            time = itemView.findViewById(R.id.time);
            imageFavorite = itemView.findViewById(R.id.img_favorite);

            imageFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isFavorite = itemsFiltered.get(getAdapterPosition()).isFavorite();
                    itemsFiltered.get(getAdapterPosition()).setFavorite(!isFavorite);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
