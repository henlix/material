package org.sopt.material;

import java.io.Serializable;
import java.util.ArrayList;

public class Track implements Serializable {

    private static long ID_COUNTER = 1;

    private final long id = ID_COUNTER++;
    public long id() { return id; }

    private String artist;
    public String artist() { return artist; }
    public void artist(String artist) { this.artist = artist; }

    private String title;
    public String title() { return title; }
    public void title(String title) { this.title = title; }

    private String label;
    public String label() { return label; }
    public void label(String label) { this.label = label; }

    private String genre;
    public String genre() { return genre; }
    public void genre(String genre) { this.genre = genre; }

    private float price;
    public float price() { return price; }
    public void price(float price) { this.price = price; }

    private int artwork;
    public int artwork() { return artwork; }
    public void artwork(int artwork) { this.artwork = artwork; }


    public Track(String artist, String title, String label, String genre, float price, int artwork) {

        artist(artist);
        title(title);
        label(label);
        genre(genre);
        price(price);
        artwork(artwork);
    }

    private static ArrayList<Track> tracks;
    public static ArrayList<Track> sample() { return tracks; }

    static {

        tracks = new ArrayList<>();

        tracks.add(new Track("Martin Garrix, Matisse & Sadko", "Dragon", "Spinnin' Records", "Progressive House", 1.49f, R.mipmap.artwork_dragon));
        tracks.add(new Track("Avicii", "The Nights", "PRMD", "Progressive House", 1.49f, R.mipmap.artwork_the_nights));
        tracks.add(new Track("Dash Berlin vs Marcus Schossow & Arston", "Steal Away The Universe (Tritonal Mashup)", "Revealed Recordings", "Progressive House", 0.00f, R.mipmap.artwork_steal_away_the_universe));
        tracks.add(new Track("Domeno, Michael Sparks", "Locked & Loaded (Hardwell Edit)", "Revealed Recordings", "Electro House", 1.99f, R.mipmap.artwork_locked_and_loaded));
        tracks.add(new Track("KSHMR, Blasterjaxx, Vassy", "Memories (Original Mix)", "Spinnin' Records", "Electro House", 1.99f, R.mipmap.artwork_memories));
        tracks.add(new Track("Galantis, Quintino", "Runaway (U & I) (Quintino Remix)", "Big Beat Records", "Progressive House", 1.49f, R.mipmap.artwork_runaway));

        tracks.add(new Track("MAKJ, M35, Showtek", "Go (Showtek Edit)", "Skink", "Electro House", 1.49f, R.mipmap.artwork_go));
    }
}
