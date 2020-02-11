package ba.unsa.etf;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class TimetableController {
    protected String timetableName=new String();
    protected String username = new String();
    private SubjectDAO subjectDAO=SubjectDAO.getInstance();
    private TimetableDAO timetableDAO=TimetableDAO.getInstance();
    private Timetable timetable;
    private ArrayList<Button> buttons=new ArrayList<>();

    public Button MON1,MON2,MON3,MON4,MON5,MON6,MON7,TUE1,TUE2,TUE3,TUE4,TUE5,TUE6,TUE7,WED1,WED2,WED3,WED4,WED5,WED6,WED7,
                    THU1,THU2,THU3,THU4,THU5,THU6,THU7,FRI1,FRI2,FRI3,FRI4,FRI5,FRI6,FRI7;


    public TimetableController(Timetable timetable, String username){
        this.timetable=timetable;
        this.username=username;
        this.timetableName=timetable.getTimetableName();
    }

    public void initialize() throws SQLException {
        ArrayList<TimetableField> timetableFields=timetableDAO.getFields(timetable);
        for(TimetableField t : timetableFields){
            if(t.getUser().getUsername().equals(username)) {
                Day day = t.getDay();
                String btnID = t.getDay().toString() + t.getOrdinalNumber();

                switch (btnID) {
                    case "MON1":
                        MON1.setText(t.getSubject().getSubjectName());
                        break;
                    case "MON2":
                        MON2.setText(t.getSubject().getSubjectName());
                        break;
                    case "MON3":
                        MON3.setText(t.getSubject().getSubjectName());
                        break;
                    case "MON4":
                        MON4.setText(t.getSubject().getSubjectName());
                        break;
                    case "MON5":
                        MON5.setText(t.getSubject().getSubjectName());
                        break;
                    case "MON6":
                        MON6.setText(t.getSubject().getSubjectName());
                        break;
                    case "MON7":
                        MON7.setText(t.getSubject().getSubjectName());
                        break;
                    case "TUE1":
                        TUE1.setText(t.getSubject().getSubjectName());
                        break;
                    case "TUE2":
                        TUE2.setText(t.getSubject().getSubjectName());
                        break;
                    case "TUE3":
                        TUE3.setText(t.getSubject().getSubjectName());
                        break;
                    case "TUE4":
                        TUE4.setText(t.getSubject().getSubjectName());
                        break;
                    case "TUE5":
                        TUE5.setText(t.getSubject().getSubjectName());
                        break;
                    case "TUE6":
                        TUE6.setText(t.getSubject().getSubjectName());
                        break;
                    case "TUE7":
                        TUE7.setText(t.getSubject().getSubjectName());
                        break;
                    case "WED1":
                        WED1.setText(t.getSubject().getSubjectName());
                        break;
                    case "WED2":
                        WED2.setText(t.getSubject().getSubjectName());
                        break;
                    case "WED3":
                        WED3.setText(t.getSubject().getSubjectName());
                        break;
                    case "WED4":
                        WED4.setText(t.getSubject().getSubjectName());
                        break;
                    case "WED5":
                        WED5.setText(t.getSubject().getSubjectName());
                        break;
                    case "WED6":
                        WED6.setText(t.getSubject().getSubjectName());
                        break;
                    case "WED7":
                        WED7.setText(t.getSubject().getSubjectName());
                        break;
                    case "THU1":
                        THU1.setText(t.getSubject().getSubjectName());
                        break;
                    case "THU2":
                        THU2.setText(t.getSubject().getSubjectName());
                        break;
                    case "THU3":
                        THU3.setText(t.getSubject().getSubjectName());
                        break;
                    case "THU4":
                        THU4.setText(t.getSubject().getSubjectName());
                        break;
                    case "THU5":
                        THU5.setText(t.getSubject().getSubjectName());
                        break;
                    case "THU6":
                        THU6.setText(t.getSubject().getSubjectName());
                        break;
                    case "THU7":
                        THU7.setText(t.getSubject().getSubjectName());
                        break;
                    case "FRI1":
                        FRI1.setText(t.getSubject().getSubjectName());
                        break;
                    case "FRI2":
                        FRI2.setText(t.getSubject().getSubjectName());
                        break;
                    case "FRI3":
                        FRI3.setText(t.getSubject().getSubjectName());
                        break;
                    case "FRI4":
                        FRI4.setText(t.getSubject().getSubjectName());
                        break;
                    case "FRI5":
                        FRI5.setText(t.getSubject().getSubjectName());
                        break;
                    case "FRI6":
                        FRI6.setText(t.getSubject().getSubjectName());
                        break;
                    case "FRI7":
                        FRI7.setText(t.getSubject().getSubjectName());
                        break;
                }
            }
        }
    }

    public void moreInfoAction(ActionEvent actionEvent) throws IOException, SQLException {
        Button btn = (Button) actionEvent.getSource();
        String id = btn.getId();
        String nameOfTheDay= id.substring(0,3);
        int ordinalNum = Integer.parseInt(id.substring(3));
        Day day=Day.MON;
        switch (nameOfTheDay){
            case "MON":
                day=Day.MON;
                break;
            case "TUE":
                day=Day.TUE;
                break;
            case "WED":
                day=Day.WED;
                break;
            case "THU":
                day=Day.THU;
                break;
            case "FRI":
                day=Day.FRI;
                break;
        }
        if(btn.getText().equals("")){
            Stage addFieldStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addFieldInTimetable.fxml"));
            AddFieldInTimetableController ctrl = new AddFieldInTimetableController(subjectDAO.getAllSubjects(username),day,ordinalNum);
            loader.setController(ctrl);
            Parent root = loader.load();
            addFieldStage.setTitle("Add Field");
            addFieldStage.setScene(new Scene(root,320,180));
            addFieldStage.setOnHiding(event -> {
                if(ctrl.getTimetableField()!=null){
                    btn.setText(ctrl.getTimetableField().getSubject().getSubjectName());
                    TimetableField timetableField=ctrl.getTimetableField();
                    try {
                        User user=subjectDAO.getUser(username);
                        timetableField.setUser(user);
                        timetableField.setTimetable(timetable);

                        timetableDAO.addField(timetableField);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            addFieldStage.show();
        }

    }
}
