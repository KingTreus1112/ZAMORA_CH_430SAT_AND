package com.example.excercise3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.loader.content.CursorLoader;

public class NewsLoader extends CursorLoader {

    public static final String[] PROJECTION = {
            NewsDbHelper.COLUMN_ID,
            NewsDbHelper.COLUMN_TITLE,
            NewsDbHelper.COLUMN_CONTENT
    };

    public NewsLoader(Context context) {
        super(context, NewsProvider.CONTENT_URI, PROJECTION, null, null, null);
    }
}
