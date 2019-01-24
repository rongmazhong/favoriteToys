package com.example.favoritetoys;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private FragmentTabHost mTabHost;
    private Class[] fragments = new Class[]{
            HomeFragment.class, CertifacateFragment.class, NoticeFragment.class, ProfileFragment.class
    };
    private int[] imagesIds = new int[]{R.drawable.home_tab, R.drawable.certifacate_tab, R.drawable.notice_tab, R.drawable.profile_tab};
    private String[] tags = new String[]{"home","certifacate","notice","profile"};
    private String[] titles = new String[]{"首页","凭证","公示","我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        mTabHost = findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (int i = 0; i < fragments.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(tags[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec,fragments[i],null);
        }
    }

    private View getTabItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
        ImageView imageView = view.findViewById(R.id.tab_image);
        TextView textView = view.findViewById(R.id.tab_text);
        imageView.setImageResource(imagesIds[i]);
        textView.setText(titles[i]);
        return view;
    }
}
