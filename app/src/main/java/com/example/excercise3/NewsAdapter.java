package com.example.excercise3;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Cursor cursor;
    private Context context;

    // Constructor
    public NewsAdapter(Context context) {
        this.context = context;
    }

    // Inner ViewHolder class
    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public NewsViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
        }
    }

    // Create ViewHolder
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    // Bind data to ViewHolder
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            holder.title.setText(cursor.getString(cursor.getColumnIndexOrThrow(NewsDbHelper.COLUMN_TITLE)));

            // Handle click to open details in a new activity
            holder.itemView.setOnClickListener(v -> {
                if (context instanceof MainActivity) {
                    ((MainActivity) context).openDetailActivity(
                            cursor.getLong(cursor.getColumnIndexOrThrow(NewsDbHelper.COLUMN_ID))
                    );
                }
            });
        }
    }

    // Get item count
    @Override
    public int getItemCount() {
        return (cursor != null) ? cursor.getCount() : 0;
    }

    // Swap cursor and notify adapter
    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        notifyDataSetChanged(); // Or notifyItemRangeChanged(0, getItemCount()) for better performance
    }
}
