package com.example.parsingjsonexemple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionBarPolicy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ItemModel> arrayList = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(readJSON());

            JSONArray array = object.getJSONArray("contacts");
            for (int i = 0; i < array.length(); i++) {

                JSONObject jsonObject = array.getJSONObject(i);
                String id = jsonObject.getString("id");
                String first_name = jsonObject.getString("first_name");
                String last_name = jsonObject.getString("last_name");

                final ItemModel model = new ItemModel();
                model.setId(id);
                model.setPrenom(first_name);
                model.setNom(last_name);
                arrayList.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter adapter = new CustomAdapter(this, arrayList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Hi",Toast.LENGTH_LONG).show();

            }
        });
    }

    public String readJSON() {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }

    public class CustomAdapter extends BaseAdapter {

        Context context;
        ArrayList<ItemModel> arrayList;

        public CustomAdapter(Context context, ArrayList<ItemModel> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @SuppressLint("RestrictedApi")
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            }
            TextView prenom, nom;
            prenom = (TextView) convertView.findViewById(R.id.textView_prenom);
            nom = (TextView) convertView.findViewById(R.id.textView_nom);
            ImageView call = (ImageView) convertView.findViewById(R.id.image_appel);
            prenom.setText(arrayList.get(position).getPrenom());
            nom.setText(arrayList.get(position).getNom());

            final ItemModel temp = arrayList.get(position);


            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri telephone = Uri.parse("tel:" + temp.getPhone());
                    Intent secondeActivite = new Intent(Intent.ACTION_DIAL, telephone);
                    startActivity(secondeActivite);

                }
            });

            return convertView;
        }
    }

}