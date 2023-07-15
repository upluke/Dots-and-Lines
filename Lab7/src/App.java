import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    private WorkArea workArea;

    public App() {
        super("Lab 7");

        // west panel
        setLayout(new BorderLayout());
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(12, 1));
        westPanel.setBackground(new Color(230, 230, 230));
        JCheckBox checkBoxCluster = new JCheckBox("Cluster - K-means");
        JCheckBox checkBoxLine = new JCheckBox("Line - Nearest Neighbor");
        JButton buttonRun = new JButton("Run");
        checkBoxCluster.addActionListener(this);
        checkBoxLine.addActionListener(this);
        buttonRun.addActionListener(this);

        westPanel.add(checkBoxCluster);
        westPanel.add(checkBoxLine);
        westPanel.add(buttonRun);
        add(westPanel, BorderLayout.WEST);


        // WorkArea
        workArea = new WorkArea();
        add(workArea, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        App win = new App();

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(1000, 600);
        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("javax.swing.JCheckBox")) {
            if (e.getActionCommand().equals("Cluster - K-means")) {
                System.out.println(e.getActionCommand() + " " + ((JCheckBox) e.getSource()).isSelected());
                workArea.setClusterEnabled(((JCheckBox) e.getSource()).isSelected());

            } else {
                System.out.println(e.getActionCommand() + " " + ((JCheckBox) e.getSource()).isSelected());
                workArea.setLineEnabled(((JCheckBox) e.getSource()).isSelected());
            }

        } else {
            System.out.println(e.getSource().getClass().getName() + " button here");
//            workArea.run();
            workArea.setRunBtnClicked(true);
        }
    }

}
