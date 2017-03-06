package com.storchapp.storch.restclient;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.storchapp.storch.MainActivity;
import com.storchapp.storch.jsonparser.CategoryParser;
import com.storchapp.storch.jsonparser.StoreParser;
import com.storchapp.storch.models.Category;
import com.storchapp.storch.models.Store;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RestClient {
    public static final String TAG = "RestClient";

    CategoryParser cp = new CategoryParser();
    StoreParser sp = new StoreParser();


    String asd = "[\n" +
            "    {\n" +
            "        \"id\": 1,\n" +
            "        \"is_active\": true,\n" +
            "        \"store_code\": 1234,\n" +
            "        \"store_name\": \"Teknosa\",\n" +
            "        \"latitude\": \"40.324000\",\n" +
            "        \"longitude\": \"41.456000\",\n" +
            "        \"creation_time\": \"2017-03-03\",\n" +
            "        \"address\": \"asd mahallesi, z sokak\",\n" +
            "        \"primary_phone_number\": \"\",\n" +
            "        \"secondary_phone_number\": \"\",\n" +
            "        \"email_address\": \"\",\n" +
            "        \"website_address\": \"\",\n" +
            "        \"contact_name\": \"kenan\",\n" +
            "        \"contact_phone_number\": \"054238465\",\n" +
            "        \"contact_email_address\": \"\",\n" +
            "        \"hours_monday_open\": null,\n" +
            "        \"hours_monday_close\": null,\n" +
            "        \"hours_tuesday_open\": null,\n" +
            "        \"hours_tuesday_close\": null,\n" +
            "        \"hours_wednesday_open\": null,\n" +
            "        \"hours_wednesday_close\": null,\n" +
            "        \"hours_thursday_open\": null,\n" +
            "        \"hours_thursday_close\": null,\n" +
            "        \"hours_friday_open\": null,\n" +
            "        \"hours_friday_close\": null,\n" +
            "        \"hours_saturday_open\": null,\n" +
            "        \"hours_saturday_close\": null,\n" +
            "        \"hours_sunday_open\": null,\n" +
            "        \"hours_sunday_close\": null\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 2,\n" +
            "        \"is_active\": false,\n" +
            "        \"store_code\": 3541,\n" +
            "        \"store_name\": \"H&M\",\n" +
            "        \"latitude\": \"41.354100\",\n" +
            "        \"longitude\": \"40.541500\",\n" +
            "        \"creation_time\": \"2017-03-04\",\n" +
            "        \"address\": \"beşiktaş, yıldız, asariye\",\n" +
            "        \"primary_phone_number\": \"02546123465\",\n" +
            "        \"secondary_phone_number\": \"\",\n" +
            "        \"email_address\": \"\",\n" +
            "        \"website_address\": \"\",\n" +
            "        \"contact_name\": \"Alev\",\n" +
            "        \"contact_phone_number\": \"05324568921\",\n" +
            "        \"contact_email_address\": \"\",\n" +
            "        \"hours_monday_open\": null,\n" +
            "        \"hours_monday_close\": null,\n" +
            "        \"hours_tuesday_open\": null,\n" +
            "        \"hours_tuesday_close\": null,\n" +
            "        \"hours_wednesday_open\": null,\n" +
            "        \"hours_wednesday_close\": null,\n" +
            "        \"hours_thursday_open\": null,\n" +
            "        \"hours_thursday_close\": null,\n" +
            "        \"hours_friday_open\": null,\n" +
            "        \"hours_friday_close\": null,\n" +
            "        \"hours_saturday_open\": null,\n" +
            "        \"hours_saturday_close\": null,\n" +
            "        \"hours_sunday_open\": null,\n" +
            "        \"hours_sunday_close\": null\n" +
            "    }\n" +
            "]";

    public void updateCategories(){
        try{
            cp.parseCategoryList(httpsGetRawString("https://95.85.27.32/categories/"));
        }catch (Exception e){
            Log.d(TAG, e.toString());
        }
    }

    public Category getCategoryByID(int categoryID) {
        String mURL = "https://95.85.27.32/categories/" + categoryID + "/";
        try{
            return cp.parseCategory(new JSONObject(httpsGetRawString(mURL)));
        }catch (Exception e){
            Log.d(TAG, e.toString());
        }
        return null;
    }

    public void updateStores(){
        //
        try{
            sp.parseStoreList(httpsGetRawString("https://95.85.27.32/stores/"));
        }catch(Exception e){
            Log.d(TAG, e.toString());
        }
    }

    public Store getStoreByID(int storeID){
        String mURL = "https://95.85.27.32/stores/" + storeID + "/";
        try{
           return sp.parseStore(new JSONObject(httpsGetRawString(mURL)));
        }catch (Exception e){
            Log.d(TAG, e.toString());
        }
        return null;
    }

    private String httpsGetRawString(String url){
        try{
            URL mUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) mUrl.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();

            String inputStr;

            while((inputStr=bufferedReader.readLine()) != null) {
                stringBuilder.append(inputStr);
            }
            Log.d(TAG, "httpsGetRawString: " + inputStr);

            return inputStr;
        }catch (Exception e){
            Log.d(TAG, e.toString());

            //TODO: if string null smt is wrong
            return null;
        }
    }


}
