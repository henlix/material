package org.sopt.material;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private Track track;
    CollapsingToolbarLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        track = (Track) intent.getSerializableExtra("track");

        setContentView(R.layout.activity_detail);

        initializeToolbar();
        initializeCollapsingToolbarLayout();
        initializeTrackInformation();
        initializeFloatingActionButton();
    }

    private void initializeToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializeCollapsingToolbarLayout() {

        layout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        layout.setTitle(track.title());
    }

    private void initializeTrackInformation() {

        ImageView imageViewArtwork = (ImageView) findViewById(R.id.image_view_artwork);
        Picasso.with(this).load(track.artwork()).into(imageViewArtwork);

        TextView textViewArtist = (TextView) findViewById(R.id.text_view_artist);
        textViewArtist.setText(track.artist());

        TextView textViewLabel = (TextView) findViewById(R.id.text_view_label);
        textViewLabel.setText(track.label());

        TextView textViewGenre = (TextView) findViewById(R.id.text_view_genre);
        textViewGenre.setText(track.genre());

        TextView textViewPrice = (TextView) findViewById(R.id.text_view_price);
        textViewPrice.setText(String.valueOf(track.price()));
    }

    private void initializeFloatingActionButton() {

        FloatingActionButton actionButton = (FloatingActionButton) findViewById(R.id.action_button);
        actionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                createSnackBar();
            }
        });
    }

    private void createSnackBar() {

        Snackbar.make(layout, track.title() + " added :)", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                createUndoSnackBar();
            }

        }).show();
    }

    private void createUndoSnackBar() {

        Snackbar.make(layout, "Undo :(", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    finishAfterTransition();
                }
                else {

                    finish();
                }

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
