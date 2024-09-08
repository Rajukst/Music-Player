package com.example.musicplayer.views.panels;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.example.musicplayer.R;
import com.realgear.multislidinguppanel.BasePanelView;
import com.realgear.multislidinguppanel.MultiSlidingUpPanelLayout;

public class RootMediaPlayerPanel extends BasePanelView {
    public RootMediaPlayerPanel(@NonNull Context context, MultiSlidingUpPanelLayout panelLayout) {
        super(context, panelLayout);
        getContext().setTheme(R.style.Theme_MusicPlayer);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_root_mediaplayer, this, true);
    }

    @Override
    public void onCreateView() {
        this.setPanelState(MultiSlidingUpPanelLayout.COLLAPSED);
        this.setSlideDirection(MultiSlidingUpPanelLayout.SLIDE_VERTICAL);
        this.setPeakHeight(getResources().getDimensionPixelSize(R.dimen.mediaplayerbar_height));
    }

    @Override
    public void onBindView() {

    }

    @Override
    public void onPanelStateChanged(int panelSate) {

    }
}
