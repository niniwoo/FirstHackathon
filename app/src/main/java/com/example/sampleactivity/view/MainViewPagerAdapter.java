package com.example.sampleactivity.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.sampleactivity.R;

public class MainViewPagerAdapter extends PagerAdapter {
    RecyclerView jRecyclerView, cRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter jAdapter, cAdapter;

    private Context mContext = null;

    public MainViewPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;
        if (mContext != null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            switch (position) {
                case 0:
                default:
                    view = inflater.inflate(R.layout.home0, container, false);
                    break;
                case 1:
                    view = inflater.inflate(R.layout.resources1, container, false);
                    break;
                case 2:
                    view = inflater.inflate(R.layout.tracker2, container, false);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.journal3, container, false);

                    jRecyclerView = view.findViewById(R.id.journal_recycler_view);
                    layoutManager = new LinearLayoutManager(mContext);
                    jRecyclerView.setLayoutManager(layoutManager);
                    jAdapter = new JournalRecyclerAdapter();
                    jRecyclerView.setAdapter(jAdapter);
                    break;
                case 4:
                    view = inflater.inflate(R.layout.community4, container, false);

                    cRecyclerView = view.findViewById(R.id.comm_recycler_view);
                    layoutManager = new LinearLayoutManager(mContext);
                    cRecyclerView.setLayoutManager(layoutManager);
                    cAdapter = new CommunityRecyclerAdapter();
                    cRecyclerView.setAdapter(cAdapter);
                    break;
            }
        }

        container.addView(view);

        return view;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String returnString = "";
        switch (position) {
            case 0:
            default:
                returnString = mContext.getResources().getString(R.string.tab_menu_home);
                break;
            case 1:
                returnString = mContext.getResources().getString(R.string.tab_menu_resources);
                break;
            case 2:
                returnString = mContext.getResources().getString(R.string.tab_menu_tracker);
                break;
            case 3:
                returnString = mContext.getResources().getString(R.string.tab_menu_journal);
                break;
            case 4:
                returnString = mContext.getResources().getString(R.string.tab_menu_community);
                break;
        }

        return returnString;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
