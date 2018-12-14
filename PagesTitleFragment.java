package com.yan.redrocklevel2;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PagesTitleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pages_title_frag, container, false);
        RecyclerView pagesTitleRecyclerView = (RecyclerView) view.findViewById(R.id.pages_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        pagesTitleRecyclerView.setLayoutManager(layoutManager);
        PagesAdapter adapter = new PagesAdapter(getPages());
        pagesTitleRecyclerView.setAdapter(adapter);
        return view;
    }
    private List<Pages> getPages(){
        List<Pages> pagesList = new ArrayList<>();
        int n = 1;
        for(int i = 1;i<=8;i++){
            Pages pages = new Pages("第"+n+"个",R.drawable.img1);
            pagesList.add(pages);
            n = n+1;
            Pages pages1 = new Pages("第"+n+"个",R.drawable.img2);
            pagesList.add(pages1);
            n=n+1;
            Pages pages2 = new Pages("第"+n+"个",R.drawable.img2);
            pagesList.add(pages2);
            n=n+1;
            Pages pages3 = new Pages("第"+n+"个",R.drawable.img3);
            pagesList.add(pages3);
            n=n+1;
        }
        return pagesList;
    }

    class PagesAdapter extends RecyclerView.Adapter<PagesAdapter.ViewHolder> {
        private List<Pages> mPagesList;


        @Override
        public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pages_item, parent, false);
            final PagesAdapter.ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Pages pages = mPagesList.get(holder.getAdapterPosition());
                    PagesContentFragment pagesContentFragment = (PagesContentFragment) getFragmentManager().findFragmentById(R.id.pages_content_fragment);
                    pagesContentFragment.refresh(pages.getImageId());
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder( ViewHolder holder, int position) {
            Pages pages = mPagesList.get(position);
            holder.pagesTitleText.setText(pages.getTitle());
        }

        @Override
        public int getItemCount() {
            return mPagesList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView pagesTitleText;
            public ViewHolder(View view){
                super(view);
                pagesTitleText =(TextView)view.findViewById(R.id.pages_title);
            }
        }
        public PagesAdapter(List<Pages> pagesList) {
            mPagesList = pagesList;
        }
    }
}

