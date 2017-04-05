package mx.com.liverpool.liverpool;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

public class ItemsListActivity extends ActionBarActivity implements SearchView.OnQueryTextListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchView mSearchView;
    private SearchAdapter mSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mSearchAdapter = new SearchAdapter(this);
        mRecyclerView.setAdapter(mSearchAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_list_menu, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.product_searchView);
        mSearchView = (SearchView) searchMenuItem.getActionView();
        customizeSearchView();
        return true;
    }

    private void customizeSearchView(){
        if(mSearchView != null){
            mSearchView.setOnQueryTextListener(this);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mSearchAdapter.searchItems(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
