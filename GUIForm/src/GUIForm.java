import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GUIForm extends JFrame {
    private String response = "";

    GUIForm(String response, String color, String path) {
        super("Response from server");
        this.setResponse(response);
        JLabel label = new JLabel(getResponse());
        URL imgURL = GUIForm.class.getResource(path);
        ImageIcon icon = new ImageIcon(imgURL);
        JLabel labelicon = new JLabel(icon);

        if (color.equals("Red")) {
            label.setForeground(Color.RED);
        } else if (color.equals("Blue")) {
            label.setForeground(Color.BLUE);
        } else
            label.setForeground(Color.BLACK);
        labelicon.setIcon(icon);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(new GridLayout(2, 2, 2, 2));
        getContentPane().add(label); // add new component
        getContentPane().add(labelicon);
        pack();
        setVisible(true);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
