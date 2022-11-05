import FFM.FileMaster;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class ClassDiagramCreator extends GraphicsProgram {

    // constants for file data
    final String PROJECT_FILE_LOCATION = FileMaster.DOCUMENTS_FOLDER+"/Class Diagram Creator/ProjectData/";

    // page variables
    final int HOME_PAGE = 0;
    final int PROJECT_PAGE = 1;
    final int CLASS_EDITOR = 2;
    int currentPage = HOME_PAGE;
    ArrayList<File> visibleProjects = new ArrayList<>();

    // UI Assets
    MouseAdapter loadProjectMA = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            loadProject();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            loadProjectBtn.setImage("buttonImages/Project Management/LoadProjectBtn-Hover.png");
            loadProjectBtn.scale(0.2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            loadProjectBtn.setImage("buttonImages/Project Management/LoadProjectBtn.png");
            loadProjectBtn.scale(0.2);
        }
    };
    MouseAdapter newProjectMA = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            newProject("Dialog");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            newProjectBtn.setImage("buttonImages/Project Management/NewProjectBtn-Hover.png");
            newProjectBtn.scale(0.2);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            newProjectBtn.setImage("buttonImages/Project Management/NewProjectBtn.png");
            newProjectBtn.scale(0.2);
        }
    };
    GRect header;
    JLabel pageHeaderLabel;
    GImage newProjectBtn, loadProjectBtn;

    public void init(){
        visibleProjects.clear();
        setupDirectory();
        setupWindow();
        setupPages();
        goToPage(HOME_PAGE);

        lookForProjects();
    }

    private void goToPage(int index){
        currentPage = index;
        switch(index){

            case HOME_PAGE -> {
                print("Home Page");
                this.setBackground(new Color(199, 199, 199));
            }

            case PROJECT_PAGE -> {
                print("Project Page");
                this.setBackground(new Color(199, 199, 199));
            }

            case CLASS_EDITOR -> {
                print("ClassEditor Page");
                this.setBackground(new Color(180, 144, 118));
            }

        }
    }

    private void loadProject(){

    }

    private void setupDirectory(){
        if(!FileMaster.fileExists(FileMaster.DOCUMENTS_FOLDER+"/Class Diagram Creator/ProjectData/")){
            FileMaster.createDirectory(FileMaster.DOCUMENTS_FOLDER,"/Class Diagram Creator/ProjectData/");
        }
    }

    private void lookForProjects(){
        File projectFolder = new File(PROJECT_FILE_LOCATION);
        File[] visibleFiles = projectFolder.listFiles();
        visibleProjects.clear();

        File temp;

        for (int i = 0; i < visibleFiles.length; i++) {
            temp = new File(String.valueOf(visibleFiles[i]));
            visibleProjects.add(temp);
        }

        //FileMaster.printList(visibleProjects);
    }

    private void newProject(String projectName){
        File newProject = new File(FileMaster.DOCUMENTS_FOLDER+"/Class Diagram Creator/ProjectData/" + projectName);

        // check for directory exist
        if(!FileMaster.fileExists(FileMaster.DOCUMENTS_FOLDER+"/Class Diagram Creator/ProjectData/")){
            FileMaster.createDirectory(FileMaster.DOCUMENTS_FOLDER,"/Class Diagram Creator/ProjectData/");
        }

        // check for name taken
        if(newProject.exists()){
            // Tell the user to pick a different name
        } else {
            // create the new project
            FileMaster.createFile(FileMaster.DOCUMENTS_FOLDER + "/Class Diagram Creator/ProjectData/" + projectName);
        }
    }

    private void setupWindow(){
        this.setSize(460,600);
        this.getMenuBar().setVisible(false);
        this.setTitle("Class Diagram Creator");
    }

    private void setupPages(){
        // setup project open project button
        loadProjectBtn = new GImage("buttonImages/Project Management/LoadProjectBtn.png");
        newProjectBtn = new GImage("buttonImages/Project Management/NewProjectBtn.png");
        loadProjectBtn.scale(0.2);
        newProjectBtn.scale(0.2);
        add(loadProjectBtn, getWidth()/3 - loadProjectBtn.getWidth()/2,getHeight() - getHeight()/10);
        add(newProjectBtn, (getWidth()/3)*2 - newProjectBtn.getWidth()/2,getHeight() - getHeight()/10);
        loadProjectBtn.addMouseListener(loadProjectMA);
        newProjectBtn.addMouseListener(newProjectMA);

        // setup page header
        header = new GRect(this.getWidth()+2,this.getHeight()/6);
        add(header, -1,-1);
        header.setFilled(true);
        header.setFillColor(new Color(130, 153, 175));
        pageHeaderLabel = new JLabel("Projects");
        pageHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(pageHeaderLabel,0,0);
        pageHeaderLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        pageHeaderLabel.setSize(getWidth()/2,(int) header.getHeight()/2);
        pageHeaderLabel.setLocation(getWidth()/2 - pageHeaderLabel.getWidth()/2,(int) header.getHeight()/2 - pageHeaderLabel.getHeight()/2);
        pageHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);

    }

    public static void main(String[] args) {
        new ClassDiagramCreator().start();
    }
}