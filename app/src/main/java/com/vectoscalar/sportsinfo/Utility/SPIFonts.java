package com.vectoscalar.sportsinfo.Utility;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.vectoscalar.sportsinfo.Common.SPIApplication;

public class SPIFonts {

    public static void setFontAwesome(View view) {
        //Typeface typeface = Typeface.createFromAsset(assetManager, TLConstants.fontGoBold);
        Typeface typeface = TypefaceCache.get(SPIApplication.spiAssetManager, SPIConstants.fontAwesome);
        ((TextView) view).setTypeface(typeface);

    }



    public static void setFontCronusRound(View view) {
        //Typeface typeface = Typeface.createFromAsset(assetManager, TLConstants.fontGoBold);
        Typeface typeface = TypefaceCache.get(SPIApplication.spiAssetManager, SPIConstants.fontCronusRound);
        ((TextView) view).setTypeface(typeface);

    }

    public static void setFontCronusItalic(View view) {
        //Typeface typeface = Typeface.createFromAsset(assetManager, TLConstants.fontGoBold);
        Typeface typeface = TypefaceCache.get(SPIApplication.spiAssetManager, SPIConstants.fontCronusItalic);
        ((TextView) view).setTypeface(typeface);

    }

}
