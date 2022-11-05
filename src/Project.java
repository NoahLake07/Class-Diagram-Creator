import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import FFM.FileMaster;

public class Project {

    String projectName, projectDescription;
    Color projectColor;
    File fileLocation;
    ArrayList<String> fileData;
    ArrayList<Class> classes = new ArrayList<>();

    /**
     * Construct a new Project using an existing File
     * @param file
     */
    public void Project(File file){
        fileLocation = file;
        fileData = FileMaster.fileToList(fileLocation.getPath());

        // Fetch Project Data
        fetchProjectData();
    }

    private void fetchProjectData(){
        // check for project file validity
        if(fileData.get(0).equals("¤")) {

            // get basic project data
            projectName = fileData.get(1);
            projectDescription = fileData.get(3);

            // get project color values
            String[] colorData = convertStringToArray(fileData.get(2), '»');
            projectColor = new Color(Integer.valueOf(colorData[0]), Integer.valueOf(colorData[1]), Integer.valueOf(colorData[2]));

            // check to see if the list of classes exists
            if (fileData.get(3).startsWith("`")) {

                // check if there are existing classes
                if (fileData.get(4).startsWith("/")) {

                    // start streaming class data
                    String currentLineData = fileData.get(5);
                    int currentLine = 5;
                    int currentClass = 0;

                    // repeat until the end of the class list
                    while(!(currentLineData.startsWith("¯"))) {

                        classes.add(new Class());

                        // repeat until the end of class data
                        while (!(currentLineData.startsWith("\\"))) {

                            // filter data
                            switch (currentLineData) {

                                case "‹":
                                    // variable indication
                                    String temp = fileData.get(currentLine);
                                    temp.substring(1);
                                    String[] tempVarData = convertStringToArray(temp, '»');

                                    int aM, type;

                                    // assign literal type value
                                    switch (tempVarData[1]){
                                        case "byte" -> type = Type.BYTE;
                                        case "int" -> type = Type.INT;
                                        case "short" -> type = Type.SHORT;
                                        case "long" -> type = Type.LONG;
                                        case "float" -> type = Type.FLOAT;
                                        case "double" -> type = Type.DOUBLE;
                                        default -> {
                                            type = 0;
                                            System.out.println("VARIABLE TYPE INVALID");
                                        }
                                    }

                                    // assign literal access mod value
                                    switch (tempVarData[0]){
                                        case "public" -> aM = AccessModifier.PUBLIC;
                                        case "private" -> aM = AccessModifier.PRIVATE;
                                        case "protected" -> aM = AccessModifier.PROTECTED;
                                        default -> {
                                            aM = AccessModifier.PRIVATE;
                                            System.out.println("VARIABLE ACCESS MODIFIER INVALID");
                                        }
                                    }

                                    // add the new variable to classes list
                                    classes.get(currentClass).createVariable(aM,type,tempVarData[2]);
                                    break;

                                case "›":
                                    // method indication

                                    break;

                                default:
                                    System.out.println("INVALID CLASS DATA");
                                    break;
                            }

                            // increment to next line
                            currentLine++;
                            currentLineData = fileData.get(currentLine);
                        }
                        currentClass++;
                    }

                } else {
                    // there is no classes within the list
                    System.out.println("NO CLASSES WITHIN LOADED PROJECT COULD BE FOUND");
                }

            } else {
                // there is no class list to look in
                System.out.println("INVALID DATA: CLASS ARRAYLIST COULD NOT BE FOUND");
            }

        } else {
            // Project File Invalid
            System.out.println("PROJECT FILE INVALID");
        }


    }

    private void writeProjectData(){

    }

    private String[] convertStringToArray(String stringIn,char separators){
        // separate string into list depending on separators
        List<String> tempList = Arrays.asList(stringIn.split(String.valueOf(separators)));

        // create a new pre-populated array based on the size of the list
        String[] array = tempList.stream().toArray(String[]::new);

        return array;
    }

}
