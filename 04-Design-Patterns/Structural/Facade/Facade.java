package CommonlyUsedDesignPatterns.StructuralDesignPatterns.FacadeDesignPattern;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.FacadeDesignPattern.Subsystems.MusicPlayer;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.FacadeDesignPattern.Subsystems.VideoPlayer;

public class Facade {
    private MusicPlayer musicPlayer;
    private VideoPlayer videoPlayer;
    public Facade(){
        musicPlayer = new MusicPlayer();
        videoPlayer = new VideoPlayer();
    }

    public void play(String action){
        switch (action){
            case "music":
                musicPlayer.setUpMusicPlayer();
                musicPlayer.playMusic();
                break;
            case "video":
                videoPlayer.setUpVideoPlayer();
                videoPlayer.playVideo();
                break;
            default:
                System.out.println("Not a valid action selected");
                break;
        }
    }
}
