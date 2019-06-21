package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esraakhaled.android.jokereciverlibrary.JokeDisplayerActivity;
import com.esraakhaled.android.joketellerlibrary.JokeTeller;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.adView)
    AdView mAdView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @OnClick(R.id.button_tell_joke)
    void tellJoke() {
        JokeTeller jokeTeller = new JokeTeller();

        /*Toast.makeText(getContext(), jokeTeller.tellJoke(), Toast.LENGTH_SHORT).show();*/

        startActivity(JokeDisplayerActivity.getStartIntent(this.getContext(), jokeTeller.tellJoke()));
    }
}
