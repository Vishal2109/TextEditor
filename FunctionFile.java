import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

//functionality in file mennu
public class FunctionFile {

    GUI gui;
    String fileName;
    String fileAddress;
    public FunctionFile(GUI gui){
        this.gui = gui;
    }

//    creates new file
    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

//    open existing file
    public void openFile(){
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);

            try{
                BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
                gui.textArea.setText("");
                String line = null;

                while ((line = br.readLine())!=null){
                    gui.textArea.append(line + '\n');
                }
                br.close();
            } catch (Exception e){
                System.out.println("File Not Opened!");
            }

        }
    }

//    save current file by overwriting previous version of same file
//    or if file is new then call saveAs method
    public void saveFile(){
        if(fileName==null){
            saveAsFile();
        }
        else{
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            }catch (Exception e){
                System.out.println("Somthing Wrong");
            }
        }
    }

//    save file in new location by new name
    public void saveAsFile(){
        FileDialog fd = new FileDialog(gui.window, "SaveAs", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e){
            System.out.println("Something Wrong");
        }
    }

    public void exitFile() {
        System.exit(0);
    }
}
