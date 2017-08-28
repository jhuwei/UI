package com.example.jhuwei.ui_change;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mDataset;
    private MenuItem menuSearchItem;
    private SearchManager msearchManager;
    private SearchView msearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();

        mLayoutManager = new LinearLayoutManager (this,LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager (mLayoutManager);

        mRecyclerView.addItemDecoration (new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        mAdapter = new Rcy_Adapter(this,mDataset);
        mRecyclerView.setAdapter (mAdapter);


    }
    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById (R.id.RecyclerView);
    }

    private void initData() {
        mDataset = new ArrayList<String>();
        for ( int i = 0; i <= 50; i++) {
            mDataset.add("item"+i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.getMenuInflater().inflate(R.menu.menu, menu);
        menuSearchItem = menu.findItem(R.id.my_search);

        msearchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        msearchView = (SearchView) menuSearchItem.getActionView();

        msearchView.setSearchableInfo(msearchManager.getSearchableInfo(getComponentName()));

        // 這邊讓icon可以還原到搜尋的icon

        msearchView.setIconifiedByDefault(true);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_listView:
                mRecyclerView.setLayoutManager (new LinearLayoutManager(this));
                break;
            case R.id.action_gridView:
                mRecyclerView.setLayoutManager (new GridLayoutManager(this,3));
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}

