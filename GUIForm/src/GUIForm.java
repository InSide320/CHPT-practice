import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GUIForm extends JFrame {
    private String response = "";

    GUIForm(String response, String color, String path) {
        super("Response from server");
        this.setResponse(response);
        URL imgURLLogo = GUIForm.class.getResource("resource/iconfinder_logo.png");
        ImageIcon iconLogo = new ImageIcon(imgURLLogo);
        JLabel labelNameCompany = new JLabel("CMETAHA");
        JLabel labelLogo = new JLabel(iconLogo);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("О программе");
        menuBar.add(menu);
        JMenuItem Author = new JMenuItem("О разработчике");
        menu.add(Author);
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
        labelLogo.setIcon(iconLogo);
        labelicon.setIcon(icon);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(new GridLayout(2, 2, 2, 2));
        getContentPane().add(labelNameCompany);
        getContentPane().add(labelLogo);
        getContentPane().add(label); // add new component
        getContentPane().add(labelicon);
        pack();
        setVisible(true);
        Author.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null ,"Author: Denis Kud");
            }
        });
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
