import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    public App(){
        super("Lab 7");

        // west panel
        setLayout(new BorderLayout());
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(12,1));
        westPanel.setBackground(new Color(230,230,230));
        JCheckBox checkBoxCluster = new JCheckBox("Cluster - K-means");
        JCheckBox checkBoxLine = new JCheckBox("Line - Nearest Neighbor");
        checkBoxCluster.addActionListener(this);
        checkBoxLine.addActionListener(this);

        westPanel.add(checkBoxCluster);
        westPanel.add(checkBoxLine);
        add(westPanel, BorderLayout.WEST);

    }

    public static void main(String[] args){
        App win = new App();

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(1000,600);
        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().getClass().getName() +" " + ((JCheckBox) e.getSource()).isSelected());
    }
}
