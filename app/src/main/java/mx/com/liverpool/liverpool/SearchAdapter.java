package mx.com.liverpool.liverpool;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.internal.LinkedTreeMap;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mx.com.liverpool.liverpool.model.Item;
import mx.com.liverpool.liverpool.model.ItemSearchResponse;
import mx.com.liverpool.liverpool.model.MainContent;
import mx.com.liverpool.liverpool.model.MainContentContents;
import mx.com.liverpool.liverpool.model.Record;
import mx.com.liverpool.liverpool.model.ResultMainInfo;
import mx.com.liverpool.liverpool.model.SearchResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Item> mItems;
    private ILiverpoolService liverpoolService;
    private final Context mContext;

    public SearchAdapter(Context context){
        liverpoolService = ApiUtils.getLiverpoolService();
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_layout, parent, false);
        return new ViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mPrice.setText(String.valueOf(mItems.get(position).getPrice()));
        holder.mTitle.setText(mItems.get(position).getTitle());
        holder.mLocation.setText(mItems.get(position).getLocation());
        Picasso.with(mContext).load(mItems.get(position).getThumbnail()).into(holder.mThumbnail);
    }

    @Override
    public int getItemCount() {
        if(mItems == null){
            return 0;
        }else {
            return mItems.size();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mThumbnail;
        public TextView mTitle;
        public TextView mLocation;
        public TextView mPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            mThumbnail = (ImageView)itemView.findViewById(R.id.thumbnail);
            mTitle = (TextView)itemView.findViewById(R.id.title);
            mLocation = (TextView)itemView.findViewById(R.id.location);
            mPrice = (TextView)itemView.findViewById(R.id.price);
        }
    }

    public void searchItems(String query){
        liverpoolService.searchItems(query).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if(response.isSuccessful()){
                    if(mItems == null){
                        mItems = new ArrayList<Item>();
                    }else{
                        mItems.clear();
                    }
                    for(ResultMainInfo rmi : response.body().getContents()){
                        for(MainContent c : rmi.getMainContent()){
                            if(c != null && c.getContents() != null){
                                for(Object mcc : c.getContents()){
                                    if(mcc != null){
                                        if(mcc instanceof LinkedTreeMap && ((LinkedTreeMap) mcc).get("records") != null){
                                            Object record;
                                            if(( record = ((LinkedTreeMap) mcc).get("records")) instanceof List ){
                                                for(Object rec : (List<LinkedTreeMap>)record){
                                                    LinkedTreeMap attrs = (LinkedTreeMap) ((LinkedTreeMap) rec).get("attributes");
                                                    if(attrs != null){
                                                        Item item = new Item();
                                                        String location = attrs.get("common.id").toString();
                                                        item.setLocation(location.substring(1, location.length()-1));

                                                        String price = attrs.get("sku.list_Price").toString();
                                                        item.setPrice("$ "+price.substring(1, price.length()-1));

                                                        String title = attrs.get("product.displayName").toString();
                                                        item.setTitle(title.substring(1, title.length()-1));

                                                        String thumbnail = attrs.get("sku.smallImage").toString();
                                                        item.setThumbnail(thumbnail.substring(1, thumbnail.length()-1));
                                                        mItems.add(item);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    notifyDataSetChanged();
                    Log.d("KURI", "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.d("KURI", "onFailure: ");
            }
        });
    }
}
