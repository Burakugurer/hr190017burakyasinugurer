package com.hr190017.burak_yasin_ugurer_final.Utility;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hr190017.burak_yasin_ugurer_final.R;

public class GlideUtil {
    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }
}
