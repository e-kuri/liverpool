package mx.com.liverpool.liverpool;

import java.util.List;

import mx.com.liverpool.liverpool.model.Item;
import mx.com.liverpool.liverpool.model.ItemSearchResponse;
import mx.com.liverpool.liverpool.model.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ekur0001 on 4/4/17.
 */

public interface ILiverpoolService {

    @GET("/tienda?d3106047a194921c01969dfdec083925=json")
    Call<SearchResult> searchItems(@Query("s") String query);

}
