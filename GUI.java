
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {

//    Text Area
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

//    Top Menu Bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

//    File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
//    Edit Menu
    JMenuItem iUndo, iRedo;
//    Format Menu
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16,
    iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;
//    Color menu
    JMenuItem iColor1, iColor2, iColor3;

    FunctionFile file = new FunctionFile(this);
    FunctionFormat format = new FunctionFormat(this);
    FunctionColor color = new FunctionColor(this);
    FunctionEdit edit = new FunctionEdit(this);
    keyBoardControls keyBoardControls = new keyBoardControls(this);
    UndoManager um = new UndoManager();


    public static void main(String[] args) {
        new GUI();
    }
    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

//        set selectedFont in FuntionFormat class to Arial
        format.selectedFont = "Arial";
//        set default font size
        format.createFont(16);
//        set word wrap to ON
        format.wordWrap();
//        set default background color to white
        color.ChangeColor("White");

        window.setVisible(true);
    }

//    create window
    public void createWindow(){
        window = new JFrame("NotePad");
        window.setSize(800, 600);
//        opens window in middle of the screen irrespective of size of screen
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    creates text area
    public void createTextArea() {
        textArea = new JTextArea();
//        set font to arial while creating text area;
        textArea.setFont(format.arial);
        textArea.addKeyListener(keyBoardControls);

//        Undo Redo
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

//    creates menu bar
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

//        add menus in menubar
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

//    creates file menu
    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this::actionPerformed);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this::actionPerformed);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this::actionPerformed);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("SaveAs");
        iSaveAs.addActionListener(this::actionPerformed);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this::actionPerformed);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);


    }

//    create format menu
    public void createFormatMenu(){
        iWrap = new JMenuItem("Word Wrap: OFF");
        iWrap.addActionListener(this::actionPerformed);
        iWrap.setActionCommand("Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this::actionPerformed);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this::actionPerformed);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this::actionPerformed);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this::actionPerformed);
        iFontSize8.setActionCommand("fontSize8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this::actionPerformed);
        iFontSize12.setActionCommand("fontSize12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this::actionPerformed);
        iFontSize16.setActionCommand("fontSize16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this::actionPerformed);
        iFontSize20.setActionCommand("fontSize20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this::actionPerformed);
        iFontSize24.setActionCommand("fontSize24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this::actionPerformed);
        iFontSize28.setActionCommand("fontSize28");
        menuFontSize.add(iFontSize28);
    }

//    create color menu
    public void createColorMenu(){

        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this::actionPerformed);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this::actionPerformed);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this::actionPerformed);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }

//    create edit menu
    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this::actionPerformed);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this::actionPerformed);
        iRedo.setActionCommand("Undo");
        menuEdit.add(iRedo);

    }

//
    @Override
    public void actionPerformed(ActionEvent e) {
//        Get the action command associated with the event
        String command = e.getActionCommand();

//        Use a switch statement to determine the action based on the command
        switch (command){
            case "New": file.newFile(); break;
            case "Open": file.openFile(); break;
            case "Save": file.saveFile(); break;
            case "SaveAs": file.saveAsFile(); break;
            case "Exit": file.exitFile(); break;
            case "Undo": edit.Undo(); break;
            case "Redo": edit.Redo(); break;
            case "Wrap": format.wordWrap(); break;
            case "Arial": format.setFont(command); break;
            case "Comic Sans MS": format.setFont(command); break;
            case "Times New Roman": format.setFont(command); break;
            case "fontSize8": format.createFont(8); break;
            case "fontSize12": format.createFont(12); break;
            case "fontSize16": format.createFont(16); break;
            case "fontSize20": format.createFont(20); break;
            case "fontSize24": format.createFont(24); break;
            case "fontSize28": format.createFont(28); break;
            case "White": color.ChangeColor(command); break;
            case "Black": color.ChangeColor(command); break;
            case "Blue": color.ChangeColor(command); break;

        }
    }
}
