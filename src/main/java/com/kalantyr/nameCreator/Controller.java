package com.kalantyr.nameCreator;

import com.kalantyr.nameCreator.core.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private TextArea taConverts;

    @FXML
    void initialize(){
        var s = new String();
        for (var key: RuToEnConverter.defaultConverts.keySet()){
            s += key + " -> " + RuToEnConverter.defaultConverts.get(key) + "\n";
        }
        taConverts.setText(s);
    }

    @FXML
    private void onStartClicked(ActionEvent event)
    {
        var converter = new RuToEnConverter(taConverts.getText());
        var nameDetector = new NameDetector(converter);
        var result = nameDetector.detect(new RuWordsCollection());
        var alert = new Alert(Alert.AlertType.INFORMATION, String.join(", ", result));
        alert.showAndWait();
    }
}
