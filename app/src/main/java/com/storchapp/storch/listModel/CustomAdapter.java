package com.storchapp.storch.listModel;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.typeface.GenericFont;
import com.storchapp.storch.R;

/**
 * Created by ken on 08.03.2017.
 */

public class CustomAdapter extends BaseAdapter{
    private String[] texts;
    private Context context;
    private int[] icons = {R.drawable.phone_icon_24x24, R.drawable.web_icon_24x24,
            R.drawable.mail_icon_24x24, R.drawable.direction_icon};

    public CustomAdapter(String[] texts, Context context){
        this.texts = texts;
        this.context = context;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View row = layoutInflater.inflate(R.layout.info_page_row, parent, false);
        TextView textView =(TextView) row.findViewById(R.id.row_text);
        ImageView imageView = (ImageView) row.findViewById(R.id.imgIcon);
      //  imageView.setImageResource((ImageView)icons[position]);
        textView.setText(texts[position]);
        imageView.setImageResource(icons[position]);
        return row;
    }
}
