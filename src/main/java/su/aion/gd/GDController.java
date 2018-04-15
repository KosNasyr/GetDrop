package su.aion.gd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class GDController {
    GetDrop gd = new GetDrop();
    @FXML private TextField fPath;
    @FXML private TextArea result;

    @FXML
    protected void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    protected void myKinara(ActionEvent event) throws Exception {
        String filePath = fPath.getText() != null ? fPath.getText() : "" ;
        result.setText("");
        ArrayList<String> drop1 = gd.getInfo(filePath);
        long kinara = gd.getKinara(drop1);
        result.appendText("Количество полученной кинары = \n"+kinara);
    }

    @FXML
    protected void myDrop(ActionEvent event) throws Exception {
        String filePath = fPath.getText() != null ? fPath.getText() : "" ;
        result.setText("");
        ArrayList<String> drop1 = gd.getInfo(filePath);
        String myDrop = gd.getMyDrop(drop1);
        result.appendText("ID полученных предметов  = \n"+myDrop);
    }

    @FXML
    protected void matesDrop(ActionEvent event) throws Exception {
        String filePath = fPath.getText() != null ? fPath.getText() : "" ;
        result.setText("");
        ArrayList<String> drop1 = gd.getInfo(filePath);
        String mateDrop = gd.getMatesDrop(drop1);
        result.appendText("ID полученных сопартийцами предметов  = \n"+mateDrop);
    }



}
