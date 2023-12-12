import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyBoardControls implements KeyListener {
    GUI gui;

    public keyBoardControls(GUI gui){
        this.gui = gui;
    }

//    creates keyboard ShortCuts
    @Override
    public void keyPressed(KeyEvent e) {
//        CTRL+S -> save
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.saveFile();
        }
//        CTRL+Shift+S -> saveAs
        if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.saveAsFile();
        }
//        CTRL+O -> Open
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O){
            gui.file.openFile();
        }
//        CTRL+Z -> Undo
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){
            gui.um.undo();
        }
//        CTRL+Y -> Redo
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y){
            gui.um.redo();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
