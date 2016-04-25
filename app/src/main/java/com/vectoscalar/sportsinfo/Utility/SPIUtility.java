package com.vectoscalar.sportsinfo.Utility;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Manoj on 4/18/2016.
 */
public class SPIUtility {
    public static String readFileFromAssets(Context context, String fileName) {
        StringBuilder fileData = new StringBuilder();
        String currentLine;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open(fileName));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            while ((currentLine = reader.readLine()) != null) {
                fileData.append(currentLine);
            }
            return fileData.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getDeviceScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    public static int getDeviceScreenHeight(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public static void setLayoutParams(View view, int width, int height) {

        android.view.ViewGroup.LayoutParams imageViewCrossParams = view.getLayoutParams();

        if (height != 0) {
            imageViewCrossParams.height = height;
        }

        if (width != 0) {
            imageViewCrossParams.width = width;
        }
        view.setLayoutParams(imageViewCrossParams);
    }

    public static void setRelativeLayoutMargins(View view, int width, int height, int left, int top, int right, int bottom,
                                                Boolean alignParentLeft, Boolean alignParentTop, Boolean alignParentRight,
                                                Boolean alignParentBottom, Boolean centerVertical, Boolean centerHorizontal, View above,
                                                View below, View rightOf, View leftOf) {

        RelativeLayout.LayoutParams layoutContactDetailsParams = new RelativeLayout.LayoutParams(width, height);
        layoutContactDetailsParams.setMargins(left, top, right, bottom);
        if (alignParentLeft) {
            layoutContactDetailsParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        }

        if (alignParentTop) {
            layoutContactDetailsParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        }

        if (alignParentRight) {
            layoutContactDetailsParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        }

        if (alignParentBottom) {
            layoutContactDetailsParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        }

        if (centerVertical) {
            layoutContactDetailsParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        }

        if (centerHorizontal) {
            layoutContactDetailsParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        }

        if (above != null) {
            layoutContactDetailsParams.addRule(RelativeLayout.ABOVE, above.getId());
        }

        if (below != null) {
            layoutContactDetailsParams.addRule(RelativeLayout.BELOW, below.getId());
        }

        if (rightOf != null) {
            layoutContactDetailsParams.addRule(RelativeLayout.RIGHT_OF, rightOf.getId());
        }

        if (leftOf != null) {
            layoutContactDetailsParams.addRule(RelativeLayout.LEFT_OF, leftOf.getId());
        }

        view.setLayoutParams(layoutContactDetailsParams);
    }
}
