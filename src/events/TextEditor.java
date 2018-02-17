package events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor implements ActionListener {

    private static String[] fontOptions = {"Serif", "Agency FB", "Arial", "Calibri", "Cambrian", "Century Gothic", "Comic Sans MS", "Courier New", "Forte", "Garamond", "Monospaced", "Segoe UI", "Times New Roman", "Trebuchet MS", "Serif"};
    private static String[] sizeOptions = {"8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28"};

    ImageIcon newIcon = new ImageIcon("res/NewIcon.png");
    ImageIcon saveIcon = new ImageIcon("res/SaveIcon.png");
    ImageIcon openIcon = new ImageIcon("res/OpenIcon.png");
    ImageIcon fontIcon = new ImageIcon("res/FontIcon.png");
    ImageIcon changeFontIcon = new ImageIcon("res/ChangeFontIcon.png");

    JButton New = new JButton(newIcon);
    JButton Save = new JButton(saveIcon);
    JButton Open = new JButton(openIcon);
    JButton changeFont = new JButton(changeFontIcon);

    JLabel fontLabel = new JLabel(fontIcon);
    JLabel fontLabelText = new JLabel("Font: ");
    JLabel fontSizeLabel = new JLabel("Size: ");

    JComboBox <String> fontName = new JComboBox<>(fontOptions);
    JComboBox <String> fontSize = new JComboBox<>(sizeOptions);

    JToolBar tool = new JToolBar();

    JTextArea texty = new JTextArea();
    JScrollPane scroll = new JScrollPane(texty);

    private static final int WIDTH = 1366;
    private static final int HEIGHT = WIDTH / 16 * 9;

    private static String name = "Text Editor";

    private static JFrame frame = new JFrame();

    public void Display() {
        frame.setTitle(name);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        New.addActionListener(this);
        New.setToolTipText("Creates a new File");
        Save.addActionListener(this);
        Save.setToolTipText("Saves the current File");
        Open.addActionListener(this);
        Open.setToolTipText("Opens a file");
        changeFont.addActionListener(this);
        changeFont.setToolTipText("Change the Font");

        fontLabel.setToolTipText("Font");

        fontLabelText.setToolTipText("Set the kind of Font");
        fontSizeLabel.setToolTipText("Set the size of the Font");

        tool.add(New);
        tool.addSeparator();
        tool.add(Save);
        tool.addSeparator();
        tool.add(Open);
        tool.addSeparator();
        tool.addSeparator();
        tool.addSeparator();
        tool.add(fontLabel);
        tool.addSeparator();
        tool.add(fontLabelText);
        tool.add(fontName);
        tool.addSeparator();
        tool.add(fontSizeLabel);
        tool.add(fontSize);
        tool.addSeparator();
        tool.add(changeFont);

        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(tool, "North");
        pane.add(scroll, "Center");
        frame.setContentPane(pane);
    }

    public static void main(String args[]) {
        TextEditor editor = new TextEditor();
        editor.Display();
    }

    public void actionPerformed(ActionEvent evt) {
        String fontNameSet;
        String fontSizeSetTemp;
        int fontSizeSet;
        Object source = evt.getSource();
        if(source == New) {
            texty.setText("");
        }
        else if(source == changeFont) {
            fontNameSet = (String) fontName.getSelectedItem();
            fontSizeSetTemp = (String) fontSize.getSelectedItem();
            fontSizeSet = Integer.parseInt(fontSizeSetTemp);
            System.out.println(fontNameSet + fontSizeSet);
            scroll.setFont(new Font(fontNameSet, fontSizeSet, Font.PLAIN));
        }

    }
}