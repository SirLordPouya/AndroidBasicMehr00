package com.pouyaheydari.training.sematec.android.basic.mehr00;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pouyaheydari.training.sematec.android.basic.mehr00.models.AladhanModel;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class TestAsyncHttpConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_http_connection);

        String url = "https://api.aladhan.com/v1/timingsByCity?city=Tehran&country=Iran&method=8";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson = new Gson();
                AladhanModel aladhan = gson.fromJson(response.toString(),AladhanModel.class);
                String maghrib = aladhan.getData().getTimings().getMaghrib();
                Log.d("TAG", "onSuccess: " + maghrib);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("TAG", "onFailure: " + errorResponse);
            }
        });
    }
}