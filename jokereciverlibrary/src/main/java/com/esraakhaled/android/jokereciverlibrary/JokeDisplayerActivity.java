package com.esraakhaled.android.jokereciverlibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeDisplayerActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "EXTRA_JOKE";

    TextView joke;

    private String jokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayer);

        joke =(TextView) findViewById(R.id.tv_joke);

        if (getIntent().hasExtra(EXTRA_JOKE)) {
            jokeText = getIntent().getExtras().getString(EXTRA_JOKE);
            joke.setText(jokeText);
        } else {
            Toast.makeText(this, getString(R.string.failure_joke_delivery), Toast.LENGTH_SHORT).show();
        }
    }

    public static Intent getStartIntent(Context context, String jokeText) {
        Intent intent = new Intent(context, JokeDisplayerActivity.class);
        intent.putExtra(EXTRA_JOKE, jokeText);
        return intent;
    }
}
