package edu.cmu.qatar._15121.musicmanager;

public class Song implements Comparable<Song>{
    private String artist;
    private String title;
    private String album;
    private String genre;

    public Song(String artist, String title, String album, String genre) {
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        String str = String.format("Song [artist=%s, title=%s, album=%s, genre=%s]", artist,title,album,genre);
        return str;
    }

    @Override
    public int hashCode() {
        return artist.hashCode() * title.hashCode() * album.hashCode() * genre.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Song s = (Song) o;
        if(artist.equals(s.artist) && title.equals(s.title) && album.equals(s.album) && genre.equals(s.genre)) {
            return true;
        }
        return false;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Song o) {
        int ret;
        ret = title.compareTo(o.getTitle());
        if(ret != 0)
            return ret;
        ret = artist.compareTo(o.getArtist());
        if(ret != 0)
            return ret;
        ret = genre.compareTo(o.getGenre());
        if(ret != 0)
            return ret;
        ret=album.compareTo(o.getAlbum());
        if(ret != 0)
            return ret;
        return ret;
    }
}
