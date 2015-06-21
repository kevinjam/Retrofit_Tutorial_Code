package com.kevinjanvier.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {

    private static final String API_URL = "http://freemusicarchive.org/api";
    private static final String API_KEY = "N99UYYW16Q0K1ICT";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            textView = (TextView) findViewById(R.id.textview);
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .build();

        ApiMethods methods = restAdapter.create(ApiMethods.class);
        Callback callback = new Callback() {
            @Override
            public void success(Object o, Response response) {
                Curator curators = (Curator) o;
                textView.setText(curators.title + "\n\n");
                for (Curator.Dataset dataset : curators.dataset) {
                    textView.setText(textView.getText() + dataset.curator_title +
                            " - " + dataset.curator_tagline + "\n");
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        };
        methods.getCurators(API_KEY, callback);
    }
}
