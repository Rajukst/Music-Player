package com.example.musicplayer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.example.musicplayer.views.panels.RootMediaPlayerPanel;
import com.example.musicplayer.views.panels.RootNavigationBarPanel;
import com.realgear.multislidinguppanel.Adapter;
import com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout;
import com.realgear.multislidinguppanel.PanelStateListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
  protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MultiSlidingUpPanelLayout panelLayout= findViewById(R.id.root_sliding_up_panel);

        List<Class<?>> items = new ArrayList<>();
        items.add(RootMediaPlayerPanel.class);
        items.add(RootNavigationBarPanel.class);
        panelLayout.setPanelStateListener(new PanelStateListener(panelLayout));
        panelLayout.setAdapter(new Adapter(getBaseContext(), items));
    }
}
