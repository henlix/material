package org.sopt.material;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrackAdapter extends BaseAdapter {

    private ArrayList<Track> source;
    public void setSource(ArrayList<Track> source) {

        this.source = source;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() { return source != null ? source.size() : 0; }

    @Override
    public Object getItem(int position) { return (source != null && (0 <= position && position < getCount())) ? source.get(position) : null; }

    @Override
    public long getItemId(int position) {

        Object obj = getItem(position);

        if (!(obj instanceof Track))
            return -1;

        Track track = (Track) obj;
        return track.id();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {

            view = View.inflate(parent.getContext(), R.layout.layout_item, null);
        }

        Track track = (Track) getItem(position);

        ImageView imageViewArtwork = (ImageView) view.findViewById(R.id.image_view_artwork);
        Picasso.with(parent.getContext()).load(track.artwork()).into(imageViewArtwork);


        TextView textViewArtist = (TextView) view.findViewById(R.id.text_view_artist);
        textViewArtist.setText(track.artist());

        TextView textViewTitle = (TextView) view.findViewById(R.id.text_view_title);
        textViewTitle.setText(track.title());

        TextView textViewGenre = (TextView) view.findViewById(R.id.text_view_genre);
        textViewGenre.setText(track.genre());


        return view;
    }
}
