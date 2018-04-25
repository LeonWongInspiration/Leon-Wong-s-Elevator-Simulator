import javax.swing.*;

public class View {
    public JFrame mainFrame;
    public View(){
        // Make the frame look better
        JFrame.setDefaultLookAndFeelDecorated(true);
        // Create frame
        this.mainFrame = new JFrame();
        // Set title
        this.mainFrame.setTitle("Elevator Simulator");
        // Set close behaviors
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel label = new JLabel("Hello World");
        this.mainFrame.getContentPane().add(label);

        // Show the frame
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
    }
}
