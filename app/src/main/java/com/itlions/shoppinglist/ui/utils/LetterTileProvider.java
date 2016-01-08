package com.itlions.shoppinglist.ui.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;

import com.itlions.shoppinglist.R;

/**
 * Used to create a {@link Bitmap} that contains a letter used in the English
 * alphabet or digit, if there is no letter or digit available, a default image
 * is shown instead
 */
public class LetterTileProvider {

    /**
     * The number of available tile colors (see R.array.letter_tile_colors)
     */
    private static final int NUM_OF_TILE_COLORS = 8;

    /**
     * The background colors of the tile
     */
    private final TypedArray mColors;

    public LetterTileProvider(Context context) {
        final Resources res = context.getResources();
        mColors = res.obtainTypedArray(R.array.letter_tile_colors);
    }

    /**
     * @param key The key used to generate the tile color
     * @return A new or previously chosen color for <code>key</code> used as the
     * tile background color
     */
    public int pickColor(String key) {
        // String.hashCode() is not supposed to change across java versions, so
        // this should guarantee the same key always maps to the same color
        final int color = Math.abs(key.hashCode()) % NUM_OF_TILE_COLORS;
        return mColors.getColor(color, Color.BLACK);
    }

}