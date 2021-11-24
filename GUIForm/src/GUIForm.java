import javax.swing.*;
import java.awt.*;

public class GUIForm extends JFrame {
    private String response = "";

    GUIForm(String response, String color){
        super("Response from server");
        this.setResponse(response);
        JLabel label = new JLabel(getResponse());
        if(color.equals("Red"))
            label.setForeground(Color.RED);
        else if(color.equals("Blue"))
            label.setForeground(Color.BLUE);
        else
            label.setForeground(Color.GREEN);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(new GridLayout(2,2,2,2));

        getContentPane().add(label); // add new component

        setVisible(true);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
