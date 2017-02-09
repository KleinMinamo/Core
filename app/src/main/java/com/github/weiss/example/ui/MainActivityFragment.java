package com.github.weiss.example.ui;

import android.support.v7.widget.StaggeredGridLayoutManager;

import com.github.weiss.core.BaseRxFragment;
import com.github.weiss.example.R;
import com.github.weiss.example.adapter.GankViewProvider;
import com.github.weiss.example.entity.Gank;
import com.github.weiss.example.view.PtrRecyclerView;

import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseRxFragment {
    @BindView(R.id.baseRecyclerView)
    PtrRecyclerView<Gank> baseRecyclerView;

    private MultiTypeAdapter adapter;

    public MainActivityFragment() {
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        baseRecyclerView.setParam("gank","Android");
        baseRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MultiTypeAdapter();
        adapter.register(Gank.class,new GankViewProvider());
        baseRecyclerView.setAdapter(adapter,new Gank());
    }
}
