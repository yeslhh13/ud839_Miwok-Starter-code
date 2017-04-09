package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gowon on 2017-01-24.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mBackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> objects, int backgroundColor) {
        super(context, 0, objects);
        mBackgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        Word currentWord = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_image);
        TextView mTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView eTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.word_linear_layout);

        if (currentWord.hasImage())
            imageView.setImageResource(currentWord.getImageResourceId());
        else
            imageView.setVisibility(View.GONE);

        int color = ContextCompat.getColor(getContext(), mBackgroundColor);

        mTextView.setText(currentWord.getMiwokTranslation());
        eTextView.setText(currentWord.getDefaultTranslation());
        linearLayout.setBackgroundColor(color);
        return listItemView;
    }
}
