
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
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
    JMenu menuFile, menuEdit, menuColor;

//    Tool Bar
    JToolBar toolBar;
    JComboBox fontSize, fontOption;
    JButton wordWarp;

//    File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
//    Edit Menu
    JMenuItem iUndo, iRedo;
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
        createToolBar();
        createFileMenu();
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

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

//    creates tool bar
    public void createToolBar(){
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        Container container = window.getContentPane();
        container.add(toolBar, BorderLayout.NORTH);

        toolBar.add(new JLabel("Font Size  "));
        fontSize = new JComboBox(new String[] {"8", "12", "16", "20", "24", "28"});
        fontSize.addActionListener(this::actionPerformed);
        toolBar.add(fontSize);

        toolBar.addSeparator();

        toolBar.add(new JLabel("Font  "));
        fontOption = new JComboBox(new String[] {"Arial", "Comic Sans MS", "Times New Roman"});
        fontOption.addActionListener(this::actionPerformed);
        toolBar.add(fontOption);

        toolBar.addSeparator();

        wordWarp = new JButton("Word Warp: ON");
        wordWarp.setFocusable(false);
        wordWarp.addActionListener(this::actionPerformed);
        toolBar.add(wordWarp);
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

        if(e.getSource()==fontSize){
//            Get the action command associated with the event
            String command = String.valueOf(fontSize.getSelectedItem());
//            Use a switch statement to determine the action based on the command
            switch (command){
                case "8": format.createFont(8); break;
                case "12": format.createFont(12); break;
                case "16": format.createFont(16); break;
                case "20": format.createFont(20); break;
                case "24": format.createFont(24); break;
                case "28": format.createFont(28); break;
            }
        }

        if(e.getSource()==fontOption){
//             Get the action command associated with the event
            String command = String.valueOf(fontOption.getSelectedItem());
//            Use a switch statement to determine the action based on the command
            switch (command){
                case "Arial": format.setFont(command); break;
                case "Comic Sans MS": format.setFont(command); break;
                case "Times New Roman": format.setFont(command); break;
            }
        }

        if(e.getSource()==wordWarp){
            format.wordWrap();
        }
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
            case "White": color.ChangeColor(command); break;
            case "Black": color.ChangeColor(command); break;
            case "Blue": color.ChangeColor(command); break;

        }
    }
}
