package kz.bitlab.springboot.sprint2.db;

import kz.bitlab.springboot.sprint2.db.Music;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Music> musics = new ArrayList<>();
    private static Long id = 6L;

    static {
        musics.add(new Music(1L, "Music 1", "Singer 1", 188));
        musics.add(new Music(2L, "Music 2", "Singer 2", 189));
        musics.add(new Music(3L, "Music 3", "Singer 3", 166));
        musics.add(new Music(4L, "Music 4", "Singer 4", 168));
        musics.add(new Music(5L, "Music 5", "Singer 5", 198));
        musics.add(new Music(6L, "Music 6", "Singer 6", 250));
        musics.add(new Music(7L, "Music 7", "Singer 7", 188));
        musics.add(new Music(8L, "Music 8", "Singer 8", 220));
    }

    public static ArrayList<Music> getMusics() {
        return musics;
    }


    public static void addMusic(Music music) {
        music.setId(id);
        id++;
        musics.add(music);
    }

    public static Music getMusic(int id) {
        return musics.stream().filter(music -> music.getId() == id).findFirst().orElse(null);
    }

    private static final ArrayList<ApplicationRequest> applicationRequests = new ArrayList<>();

    static {
        applicationRequests.add(new ApplicationRequest(
                1L, "Azeke", "Java", "Eksh", "87028411255",false));
        applicationRequests.add(new ApplicationRequest(
                2L, "Azeke", "Java", "Eksh", "87028411255",false));
        applicationRequests.add(new ApplicationRequest(
                3L, "Azeke", "Java", "Eksh", "87028411255",true));
        applicationRequests.add(new ApplicationRequest(
                4L, "Azeke", "Java", "Eksh", "87028411255",false));
        applicationRequests.add(new ApplicationRequest(
                5L, "Azeke", "Java", "Eksh", "87028411255",false));
        applicationRequests.add(new ApplicationRequest(
                6L, "Azeke", "Java", "Eksh", "87028411255",false));
    }

    public static ArrayList<ApplicationRequest> getApplicationRequests() {
        return applicationRequests;
    }

    public static void addApplicationRequest(ApplicationRequest applicationRequest) {
        applicationRequest.setId(++id);
        applicationRequests.add(applicationRequest);
    }

    public static void saveApplicationRequest(Long id) {
        for (int i = 0; i < applicationRequests.size(); i++) {
            System.out.println(id + " " + applicationRequests.get(i).getId());
            if (applicationRequests.get(i).getId() == id) {
                applicationRequests.get(i).setHandled(true);
                System.out.println("efahejrflkbrlkvbjaer");
            }
            System.out.println("wth");

        }
    }

    public static ApplicationRequest getApplicationRequest(int id) {
        return applicationRequests.stream()
                .filter(applicationRequest -> applicationRequest.getId() == id).
                findFirst().orElse(null);
    }


}
