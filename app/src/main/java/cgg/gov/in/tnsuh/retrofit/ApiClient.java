package cgg.gov.in.tnsuh.retrofit;

import java.util.concurrent.TimeUnit;

import cgg.gov.in.tnsuh.WMSConstants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(WMSConstants.url).client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
           /* retrofit = new Retrofit.Builder()
                    .baseUrl("http://"+WMSConstants.url).client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();*/

        }
        return retrofit;
    }

}
//Reviewd by swapna