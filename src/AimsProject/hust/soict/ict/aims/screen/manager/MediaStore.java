package aims.screen.manager;

import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel{
    private Media media;
    private JButton playButton = new JButton("Play");
    public MediaStore(Media media) {
        this.media = media;
        // gán bố cục theo chiều dọc
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // hiện thị tiêu đề + giá cả
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        // taok mot nut bam
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        if (media instanceof Playable) {
            container.add(playButton);
}
        // xu li su kien khi nut bam Play dc nhan
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (media instanceof DigitalVideoDisc){
                    playDVD((DigitalVideoDisc) media);
                    System.out.println("Play a DVD");
                }
                else {
                    playCD((CompactDisc) media);
                    System.out.println("Play a CD");
                }
            }
        });
        // theem cac thanh phan vao MediaStore
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
}
    //hiển thị thông tin và chiều dài của DVD.
    private void playDVD(DigitalVideoDisc media){
        JDialog dvdDialog = new JDialog();

        JPanel dvd = new JPanel();
        dvd.setLayout(new GridLayout(2, 1));

        JLabel dvdName = new JLabel("You are playing: " + media.getTitle());
        JLabel dvdLength = new JLabel("DVD length: " + media.getLength());

        dvd.add(dvdName);
        dvd.add(dvdLength);

        dvdDialog.add(dvd);

        dvdDialog.setSize(350, 200);
        dvdDialog.setLocationRelativeTo(null);

        dvdDialog.setVisible(true);
    }
    // taoj hop thoai de hien thong tin ve CD, name,...
    private void playCD(CompactDisc media){
        JDialog cdDialog = new JDialog();

        JPanel cd = new JPanel();
        cd.setLayout(new GridLayout(media.gettrackName().size() + 6, 1));

        JLabel cdName = new JLabel("You are playing: " + media.getTitle());
        JLabel cdArtist = new JLabel("Artist: " + media.getArtist());
        JLabel cdLength = new JLabel("Total length: " + media.getLength());

        cd.add(cdName);
        cd.add(cdArtist);
        cd.add(cdLength);

        for(int i = 0; i < media.gettrackName().size(); i++){
            JLabel trackName = new JLabel("Track " + (i + 1) + " name: " + media.getTracks().get(i).getTitle());
            JLabel trackLength = new JLabel("Length of track " + (i + 1) + " : " + media.getTracks().get(i).getLength());
            cd.add(trackName);
            cd.add(trackLength);
        }

        cdDialog.add(cd);

        cdDialog.setSize(512, 384);
        cdDialog.setLocationRelativeTo(null);
        cdDialog.setVisible(true);
    }
}
