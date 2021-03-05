import java.util.*;

class Solution {
    Map<String, List<String>> favoriteGenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {

        Map<String, String> songToGenre = new HashMap<>();

        songGenres.forEach((genre, songs) -> songs.forEach(song -> songToGenre.put(song, genre)));

        Map<String, List<String>> favoriteGenre = new HashMap<>();

        userSongs.forEach((user, songs) -> favoriteGenre.put(user, calculateFavoriteGenre(songs, songToGenre)));
        return favoriteGenre;
    }

    private List<String> calculateFavoriteGenre(List<String> songs, Map<String, String> songToGenre) {

        Map<String, Integer> genreFrequency = new HashMap<>();

        List<String> favGenre = new ArrayList<>();

        int maxFrequency = 0;
        for (String song : songs) {
            String genre = songToGenre.get(song);
            Integer frequency = genreFrequency.merge(genre, 1, (ov, nv) -> ov + 1);
            maxFrequency = Math.max(frequency, maxFrequency);
        }
        for (Map.Entry<String, Integer> entry : genreFrequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                favGenre.add(entry.getKey());
            }
        }
        return favGenre;

    }

    public static void main(String args[]) {

    }

}