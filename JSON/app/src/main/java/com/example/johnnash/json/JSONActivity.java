package com.example.johnnash.json;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JSONActivity extends Activity {

    private String TAG = JSONActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> charList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonactivity);

        charList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        new GetCooks().execute();
    }

    private class GetCooks extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://raw.githubusercontent.com/btford/philosobot/master/quotes/cats.json";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONArray quote = new JSONArray(jsonStr);


                    // looping through All Cats
                    for (int i = 0; i < quote.length(); i++) {
                        JSONObject c = quote.getJSONObject(i);
                        String quotes = c.getString("quotes");

                        HashMap<String, String> character = new HashMap<>();

                        character.put("quotes", quotes);

                        charList.add(character);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(JSONActivity.this, charList,
                    R.layout.list_item, new String[]{"quotes"},
                    new int[]{R.id.quote});
            lv.setAdapter(adapter);
        }
    }
}