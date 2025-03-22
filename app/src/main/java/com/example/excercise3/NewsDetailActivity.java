package com.example.excercise3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailActivity extends AppCompatActivity {

    private TextView titleView;
    private TextView contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail); // Use this layout for details

        // Initialize UI components
        titleView = findViewById(R.id.detail_title);
        contentView = findViewById(R.id.detail_content);

        // Get the ID passed from MainActivity
        long newsId = getIntent().getLongExtra("news_id", -1);

        if (newsId != -1) {
            loadNewsDetails(newsId);
        }
    }

    // Load news details from the database using the ContentProvider
    private void loadNewsDetails(long id) {
        Cursor cursor = getContentResolver().query(
                NewsProvider.CONTENT_URI,
                new String[]{NewsDbHelper.COLUMN_TITLE, NewsDbHelper.COLUMN_CONTENT},
                NewsDbHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndexOrThrow(NewsDbHelper.COLUMN_TITLE));
            String content = cursor.getString(cursor.getColumnIndexOrThrow(NewsDbHelper.COLUMN_CONTENT));

            titleView.setText(title);
            contentView.setText(content);

            cursor.close();
        }
    }
}
