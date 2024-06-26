package aims.screen.manager;

import aims.store.Store;
import aims.media.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextArea authorArea;
    private JButton addButton;
    public AddBookToStoreScreen(Store store) {
        super(store);

        JLabel authorLabel = new JLabel("Authors:");
        authorArea = new JTextArea(5, 20);
        JScrollPane authorScrollPane = new JScrollPane(authorArea);

        addButton = new JButton("Add Book");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToStore(); 
                JOptionPane.showMessageDialog(null,"New Book has been added");
            }
        });

        center.add(authorLabel, labelConstrains);
        center.add(authorScrollPane, fieldConstrains);
        center.add(addButton,fieldConstrains);

    }
    @Override
    protected void addItemToStore() {
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String[] authorsArray = authorArea.getText().split("\n");
        List<String> authorsList = new ArrayList<>();
        for (String author : authorsArray) {
            authorsList.add(author);
        }

        Book book = new Book(id, title, category, cost, authorsList);
        store.addMedia(book);
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        authorArea.setText("");

    }

    public static void main(String[] args) {
        Store store = new Store();
        AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store);
        addBookScreen.setVisible(true);
    }
}