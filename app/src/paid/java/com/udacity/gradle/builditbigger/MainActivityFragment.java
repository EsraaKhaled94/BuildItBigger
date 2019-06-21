package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esraakhaled.android.jokereciverlibrary.JokeDisplayerActivity;
import com.esraakhaled.android.joketellerlibrary.JokeTeller;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        return root;
    }

    @OnClick(R.id.button_tell_joke)
    void tellJoke() {
        JokeTeller jokeTeller = new JokeTeller();

        /*Toast.makeText(getContext(), jokeTeller.tellJoke(), Toast.LENGTH_SHORT).show();*/

        startActivity(JokeDisplayerActivity.getStartIntent(this.getContext(), jokeTeller.tellJoke()));
    }
}
