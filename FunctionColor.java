import java.awt.*;

public class FunctionColor {
    GUI gui;
    public FunctionColor(GUI gui){
        this.gui = gui;
    }

//    change background color
    public void ChangeColor(String Color){
        switch (Color){
            case "White":
                gui.window.getContentPane().setBackground(java.awt.Color.WHITE);
                gui.textArea.setBackground(java.awt.Color.WHITE);
                gui.textArea.setForeground(java.awt.Color.BLACK);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(java.awt.Color.BLACK);
                gui.textArea.setBackground(java.awt.Color.BLACK);
                gui.textArea.setForeground(java.awt.Color.WHITE);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(java.awt.Color.BLUE);
                gui.textArea.setBackground(java.awt.Color.BLUE);
                gui.textArea.setForeground(java.awt.Color.WHITE);
                break;
        }
    }
}
