package mx.com.liverpool.liverpool;

/**
 * Created by ekur0001 on 4/4/17.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://www.liverpool.com.mx";

    public static ILiverpoolService getLiverpoolService(){
        return RetrofitClient.getClient(BASE_URL).create(ILiverpoolService.class);
    }

}
