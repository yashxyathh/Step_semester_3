import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maximumSongs) {
        songs = new String[maximumSongs];
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");

        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";

        System.out.println(Arrays.toString(playlist.getSongs()));
        System.out.println(playlist.getSongCount());
    }
}
