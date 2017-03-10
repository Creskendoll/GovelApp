package com.storchapp.storch.cache;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by ken on 07.03.2017.
 */
//TODO:Experimental
public class CacheHandler {

    private static final String TAG = "CacheHandler";
    public static void writeData(String data, Context context) throws IOException {
        OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(context.openFileOutput("cache.txt", Context.MODE_PRIVATE));
        outputStreamWriter.write(data);
        outputStreamWriter.close();
    }

    public static String readData(Context context){
        String ret = "";
        try{
            InputStream inputStream = context.openFileInput("cache.txt");
            if(inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                 StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }

        }catch(FileNotFoundException e){
            Log.d(TAG, "readData: " + e);
        }catch (IOException e){
            Log.d(TAG, "readData: " + e);
        }
        return ret;
    }
}
