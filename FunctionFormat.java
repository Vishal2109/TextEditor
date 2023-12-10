import java.awt.*;

//functionality of Format Menu
public class FunctionFormat {

    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    public FunctionFormat(GUI gui){
        this.gui = gui ;
    }


    public void wordWrap(){
        if(gui.wordWrapOn==false){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: ON");
        }
        else if(gui.wordWrapOn==true){
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: OFF");
        }
    }

//    set font size
    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

//    set font
    public void setFont(String font){
        selectedFont = font;
        switch (selectedFont){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
        }
    }
}
