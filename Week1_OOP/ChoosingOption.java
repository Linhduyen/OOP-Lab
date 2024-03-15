

import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String[] args){
        String[] options = {"I do","I don't"};
        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?","confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options, options[0] );
        if (option == JOptionPane.YES_OPTION) {
            System.out.println("User selected 'Yes'");
            // Do something if user selects 'Yes'
        } else if (option == JOptionPane.NO_OPTION) {
            System.out.println("User selected 'No'");
            // Do something if user selects 'No'
        } else {
            System.out.println("User closed the dialog without making a  option");
            // Do something else if user closes the dialog without making a  option
        }
    System.exit(0);
    }
}

