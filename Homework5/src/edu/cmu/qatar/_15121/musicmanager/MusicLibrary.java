package edu.cmu.qatar._15121.musicmanager;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MusicLibrary implements Iterable<Song> {

    TreeSet<Song> songSet;
    TreeMap<String, ArrayList<Song>> artistMap;
    TreeMap<String, ArrayList<Song>> genreMap;

    public MusicLibrary() {
        songSet = new TreeSet<>();
        artistMap = new TreeMap<>();
        genreMap = new TreeMap<>();
    }

    /**
     * Add a song to the music library.
     * Throws the SongAlreadyExistsException if the song to be added already exists in the library.
     * This method has no specific efficiency requirements,
     * but you should avoid doing any linear searches through potentially large data structures.
     * If you don’t, your program may be too slow to pass the autograder.
     * @param artist The artist of the song
     * @param title The title of the song
     * @param album The album the song is a part of
     * @param genre The genre of the song
     * @throws SongAlreadyExistsException when the song already exists in the library.
     */
    public void addSong(String artist, String title, String album, String genre) throws SongAlreadyExistsException {
        Song s = new Song(artist,title,album,genre);
        // add to song lib
        if(songSet.contains(s))
            throw new SongAlreadyExistsException();
        songSet.add(s);
        // add to artistMap
        ArrayList<Song> songOfArtist = artistMap.get(artist);
        if(songOfArtist == null) {
            songOfArtist = new ArrayList<>();
        }
        songOfArtist.add(s);
        artistMap.put(artist,songOfArtist);
        // add to genreMap
        ArrayList<Song> songOfGenre = genreMap.get(genre);
        if(songOfGenre == null) {
            songOfGenre = new ArrayList<>();
        }
        songOfGenre.add(s);
        genreMap.put(genre,songOfGenre);
    }

    /**
     * Return all of the songs in the library
     * This must be O(N), where N is the number of songs in the library.
     * The order of the songs in the array does not matter.
     * @return Array of songs
     */
    public Song[] getAllSongs() {
        return (Song[]) songSet.toArray(new Song[songSet.size()]);
    }

    /**
     * Input the music database from the file specified by filename.
     * If the file does not exist, then add nothing to the library.
     * If a song in the file cannot be added to the library (for example, it already exists)
     * then just skip that song and process the rest of the file.
     * This method has no specific efficiency requirements,
     * but in order to confidently pass the autograder
     * you should be able to load 250,000 songs in 10 to 15 seconds.
     * @param filename The file to load the music from
     */
    public void loadMusicDb(String filename) {
        FileReader fr;
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        Scanner input = new Scanner(fr);
        String artist, title, album, genre;
        while(input.hasNextLine()) {
            artist = input.nextLine();
            if(input.hasNextLine()) title = input.nextLine();
            else {
                System.out.println("file not formatted, no title");
                return;
            }
            if(input.hasNextLine()) album = input.nextLine();
            else {
                System.out.println("file not formatted, no album");
                return;
            }
            if(input.hasNextLine()) genre = input.nextLine();
            else {
                System.out.println("file not formatted, no genre");
                return;
            }
            try {
                addSong(artist, title, album, genre);
            }
            catch(Exception e) {
                return;
            }
            input.nextLine(); // eat the white line
        }
        input.close();
    }

    /**
     * Return all of the artists in the library without duplicates
     * This must be O(M), where M is the number of artists.
     * @return Array of artist names
     */
    public String[] getAllArtists() {
        String[] artists = (String[]) artistMap.keySet().toArray();
        return artists;
    }

    /**
     * Retrieve all of the songs by a given artist and return them
     * This must be O(M), where M is the number of songs by that artist.
     * @param artist The artist to search for
     * @return An array of songs by the given artist. If the artist is not in the MusicLibrary, return an empty array.
     */
    public Song[] getSongsByArtist(String artist) {
        return (Song[])artistMap.get(artist).toArray();
    }

    /**
     * Retrieve all of the genres in the library without duplicates
     * This must be O(M), where M is the number of genres.
     * @return An array of strings, with each string being a genre
     */
    public String[] getGenres() {
        String[] genres = (String[]) genreMap.keySet().toArray();
        return genres;
    }

    /**
     * Retrieve all of the songs with a given genre and return them
     * This must be O(M), where M is the number of songs within the specified genre.
     * @param genre The genre
     * @return An array of songs with the given genre. If there are no songs with that genre, return an empty array.
     */
    public Song[] getSongsByGenre(String genre) {
        return (Song[])genreMap.get(genre).toArray();
    }

    private class TitleComparator implements Comparator<Song> {

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(Song o1, Song o2) {
            /**
             * “title”: Sort by title. Break ties using artist, then genre.
             * “artist”: Sort by artist. Break ties using title, then genre.
             * “genre”: Sort by genre. Break ties using artist, then title.
             */
            int ret;
            ret = o1.getTitle().compareTo(o2.getTitle());
            if(ret != 0) {
                return ret;
            }
            ret = o1.getArtist().compareTo(o2.getArtist());
            if(ret != 0) {
                return ret;
            }
            ret = o1.getGenre().compareTo(o2.getGenre());
            if(ret != 0) {
                return ret;
            }
            return ret;
        }
    }

    private class ArtistComparator implements Comparator<Song> {
        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(Song o1, Song o2) {
            /**
             * “title”: Sort by title. Break ties using artist, then genre.
             * “artist”: Sort by artist. Break ties using title, then genre.
             * “genre”: Sort by genre. Break ties using artist, then title.
             */
            int ret;
            ret = o1.getArtist().compareTo(o2.getArtist());
            if(ret != 0) {
                return ret;
            }
            ret = o1.getTitle().compareTo(o2.getTitle());
            if(ret != 0) {
                return ret;
            }
            ret = o1.getGenre().compareTo(o2.getGenre());
            if(ret != 0) {
                return ret;
            }
            return ret;
        }
    }

    private class genreComparator implements Comparator<Song> {

        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@link Integer#signum
         * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
         * all {@code x} and {@code y}.  (This implies that {@code
         * compare(x, y)} must throw an exception if and only if {@code
         * compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
         * {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x,
         * y)==0} implies that {@code signum(compare(x,
         * z))==signum(compare(y, z))} for all {@code z}.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * first argument is less than, equal to, or greater than the
         * second.
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         * @apiNote It is generally the case, but <i>not</i> strictly required that
         * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         */
        @Override
        public int compare(Song o1, Song o2) {
            /**
             * “title”: Sort by title. Break ties using artist, then genre.
             * “artist”: Sort by artist. Break ties using title, then genre.
             * “genre”: Sort by genre. Break ties using artist, then title.
             */
            int ret;
            ret = o1.getGenre().compareTo(o2.getGenre());
            if(ret != 0) {
                return ret;
            }
            ret = o1.getArtist().compareTo(o2.getArtist());
            if(ret != 0) {
                return ret;
            }
            ret = o1.getTitle().compareTo(o2.getTitle());
            if(ret != 0) {
                return ret;
            }
            return ret;
        }
    }

    /**
     * Return all songs in the library sorted in a specific way
     * If howSorted is….
     * “title”: Sort by title. Break ties using artist, then genre.
     * “artist”: Sort by artist. Break ties using title, then genre.
     * “genre”: Sort by genre. Break ties using artist, then title.
     * anything else: Return an empty array.
     * This function should be non-destructive.
     * @param howSorted How to sort the songs
     * @return Array of songs sorted as specified
     */
    public Song[] getAllSongsSorted(String howSorted) {
        Song[] songArray = getAllSongs();
        if(howSorted.compareTo("title") == 0) {
            Arrays.sort(songArray,new TitleComparator());
        }
        else if(howSorted.compareTo("artist") == 0) {
            Arrays.sort(songArray,new ArtistComparator());
        }
        else if(howSorted.compareTo("genre") == 0) {
            Arrays.sort(songArray, new genreComparator());
        }
        else {
            Song[] sLst = {};
            return sLst;
        }
        return songArray;
    }

    private class MusicIterator implements Iterator<Song> {

        Song[] songLst;
        int cur;
        int size;

        public MusicIterator() {
            songLst = getAllSongs();
            cur = 0;
            size = songLst.length;
        }

        /**
         * (In other words, returns true if next() would return an element
         * rather than throwing an exception.)
         * @return Returns true if the iteration has more elements.
         */
        public boolean hasNext() {
            return cur < size;
        }

        /**
         * Throws the NoSuchElementException if the iteration has no more elements
         * @return Returns the next element in the iteration.
         */
        public Song next() {
            return songLst[cur];
        }

        // Removes from the underlying collection the last element returned by this iterator
        // (optional operation).
        // This method can be called only once per call to next().
        // The behavior of an iterator is unspecified if the underlying collection
        // is modified while the iteration
        // is in progress in any way other than by calling this method.
        // Note: If you don't want to support remove,
        // then throw the UnsupportedOperationException instead of
        // actually removing anything.
        public void remove() {
            for(int i = cur; i < size - 1; i++) {
                songLst[i] = songLst[i+1];
            }
        }
    }

    @Override
    public Iterator<Song> iterator() {
        return new MusicIterator();
    }

}