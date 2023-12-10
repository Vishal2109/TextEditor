
//edit menu functionality
public class FunctionEdit {
    GUI gui;
    public FunctionEdit(GUI gui){
        this.gui = gui;
    }

    public void Undo(){
        gui.um.undo();
    }
    public void Redo(){
        gui.um.redo();
    }
}
