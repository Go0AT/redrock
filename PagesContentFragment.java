package com.yan.redrocklevel2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PagesContentFragment extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        view = inflater.inflate(R.layout.pages_content_frag,container,false);
        return view;
    }

    public void refresh(int imageId){
        ImageView pagesImage = (ImageView) view.findViewById(R.id.pages_image);
        pagesImage.setImageResource(imageId);
    }
}
