import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    private WorkArea workArea;
    private JCheckBox checkBoxCluster;
    private JCheckBox checkBoxLine;
    public App() {
        super("Dots and Lines");

        // west panel
        setLayout(new BorderLayout());
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(12, 1));
        westPanel.setBackground(new Color(230, 230, 230));
        checkBoxCluster = new JCheckBox("Cluster - K-means");
        checkBoxLine = new JCheckBox("Line - Nearest Neighbor");
        JButton buttonRun = new JButton("Run");
        JButton buttonReset = new JButton("Reset");
        JButton colorButton = new JButton("Dot Color");
        checkBoxCluster.addActionListener(this);
        checkBoxLine.addActionListener(this);
        buttonRun.addActionListener(this);
        buttonReset.addActionListener(this);
        colorButton.addActionListener(this);

        westPanel.add(checkBoxCluster);
        westPanel.add(checkBoxLine);
        westPanel.add(buttonRun);
        westPanel.add(buttonReset);
        westPanel.add(colorButton);

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
                workArea.setClusterEnabled(((JCheckBox) e.getSource()).isSelected());
                workArea.setIsEditable(false);
            } else {
                workArea.setLineEnabled(((JCheckBox) e.getSource()).isSelected());
                workArea.setIsEditable(false);
            }

        } else {
            if(e.getActionCommand().equals("Run")){
                workArea.setRunBtnClicked(true);
                workArea.setIsEditable(true);
            }else if(e.getActionCommand().equals("Dot Color")){
                JColorChooser colorChooser = new JColorChooser();

                JDialog dialog = JColorChooser.createDialog(null, "Select a Color", true, colorChooser, null, null);
                dialog.setVisible(true);
                Color selectedColor = colorChooser.getColor();
                workArea.setDotColor(selectedColor);

            }else{
                workArea.resetWorkArea();
                checkBoxCluster.setSelected(false);
                checkBoxLine.setSelected(false);
            }


        }
    }

}
