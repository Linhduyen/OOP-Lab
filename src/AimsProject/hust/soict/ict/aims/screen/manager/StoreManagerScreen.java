package aims.screen.manager;
import javax.swing.*;

import aims.store.*;
import aims.media.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class StoreManagerScreen extends JFrame {
    private Store store;
    private JPanel north;
    private JPanel center;
    private JScrollPane scrollPane;
    
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Option");

        JMenuItem viewItem = new JMenuItem("View Store");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addBookItem.addActionListener(new ActionListener() {
            @Override // định nghĩa...
            // khi người dùng chọn mục này -> hiện ra tham số là một đối tượng AddBookToStoreScreen
            public void actionPerformed(ActionEvent e ) {
                switchAddScreen(new AddBookToStoreScreen(store));
            }
        });
            // tương tự DVC cũng vậy 
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchAddScreen(new AddDigitalVideoDiscToStoreScreen(store));
            }
        });

        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchAddScreen(new AddCompactDiscToStoreScreen(store));
            }
        });
            // khi người dùng chọn mục này -> chuyển đến màn hình xem cửa hàng
        viewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchStoreScreen();
            }
        });
            // các mục được thêm vào các mục con menu dùng smUpdateStore, cac muc o chinh la menu.add
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        menu.add(viewItem);
        menu.add(smUpdateStore);
            // duowdj them vao ben trai 
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        // co meni tra ve
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        // hồng 
        center.setBackground(new Color(255,192,203));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
       // kiểm tra trống rỗng
        if (!mediaInStore.isEmpty()) {
            // thiết lập vị trí và các thuộc tính của mục media trong bố cục
            int itemsToShow = mediaInStore.size();
            for (int i = 0; i < itemsToShow; i++) {
                GridBagConstraints mediaConstraints = new GridBagConstraints();
                // xác định cột của mục 
                mediaConstraints.gridx = i % 3;
                // xác định hàng
                mediaConstraints.gridy = i / 3;
                // khoảng lề 
                mediaConstraints.insets = new Insets(5, 5, 5, 5); 
                // chế độ thay đổi kích thước 
                mediaConstraints.fill = GridBagConstraints.BOTH; 
                mediaConstraints.weightx = 1.0; 
                mediaConstraints.weighty = 1.0; 

                MediaStore cell = new MediaStore(mediaInStore.get(i));
                cell.setPreferredSize(new Dimension(320, 120)); // Cố định kích thước cell, ví dụ: rộng 200px và cao 100px
                center.add(cell, mediaConstraints);
            }
        }
        return center;
    }

    private void switchAddScreen(JPanel panel){
        getContentPane().remove(scrollPane);
        getContentPane().remove(center);
        this.center = panel;
        getContentPane().add(center, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void switchStoreScreen(){
        getContentPane().remove(center);
        this.center = createCenter();
        scrollPane = new JScrollPane(center);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        this.north = createNorth();
        this.center = createCenter();

// thiết lập giao diện cho phép người dùng cuộn 
        scrollPane = new JScrollPane(center);
        // thiết lập chính sách thanh cuộn dọc luôn hiển thị:
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // thiết lập cuộn ngang k hiện thị 
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cp.add(north, BorderLayout.NORTH);
        cp.add(scrollPane, BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}