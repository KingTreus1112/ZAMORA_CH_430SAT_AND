package com.example.excercise3;

import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewsListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int NEWS_LOADER_ID = 0;

    private NewsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize the adapter
        adapter = new NewsAdapter(getContext());
        // Initialize the loader
        LoaderManager.getInstance(this).initLoader(NEWS_LOADER_ID, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    // 1. Create a CursorLoader to query data from the ContentProvider
    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == NEWS_LOADER_ID) {
            // Load data from the ContentProvider using a CursorLoader
            return new CursorLoader(
                    requireContext(),
                    NewsProvider.CONTENT_URI,
                    new String[]{NewsDbHelper.COLUMN_ID, NewsDbHelper.COLUMN_TITLE, NewsDbHelper.COLUMN_CONTENT},
                    null,
                    null,
                    null
            );
        }
        return null;
    }

    // 2. Swap the new Cursor into the adapter when loading is complete
    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    // 3. Reset the adapter when the data is no longer available
    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}
