package aims.test.disc;

import aims.media.CompactDisc;
import aims.media.Track;

public class CompactDiscTest {
    public static void main(String[] args) {
        CompactDisc compactDisc = new CompactDisc();

        Track track1 = new Track("Track1", 50);
        compactDisc.addTrack(track1);
        Track track2 = new Track("Track2", 40);
        compactDisc.addTrack(track2);
        Track track3 = new Track("Track3", 20);
        compactDisc.addTrack(track3);
        System.out.println(compactDisc.getLength());
        compactDisc.addTrack(track1);

        compactDisc.play();
    }
}