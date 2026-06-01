import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MedicineReminder extends Application {

    @Override
    public void start(Stage stage) {

        
        Label titleLabel = new Label("Medicine Reminder");
        titleLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        
        Label nameLabel = new Label("Name");
        TextField medicineField = new TextField();
        medicineField.setPrefWidth(250);

        HBox nameBox = new HBox(15);
        nameBox.getChildren().addAll(nameLabel, medicineField);

        
        RadioButton afterBtn = new RadioButton("After");
        RadioButton beforeBtn = new RadioButton("Before");

        ToggleGroup mealGroup = new ToggleGroup();
        afterBtn.setToggleGroup(mealGroup);
        beforeBtn.setToggleGroup(mealGroup);

        HBox mealBox = new HBox(40);
        mealBox.getChildren().addAll(afterBtn, beforeBtn);

        
        CheckBox morningCheck = new CheckBox();
        TextField morningField = new TextField("M");
        morningField.setPrefWidth(50);

        HBox morningBox = new HBox(5);
        morningBox.getChildren().addAll(morningCheck, morningField);

        
        CheckBox eveningCheck = new CheckBox();
        TextField eveningField = new TextField("E");
        eveningField.setPrefWidth(50);

        HBox eveningBox = new HBox(5);
        eveningBox.getChildren().addAll(eveningCheck, eveningField);

        
        CheckBox nightCheck = new CheckBox();
        TextField nightField = new TextField("N");
        nightField.setPrefWidth(50);

        HBox nightBox = new HBox(5);
        nightBox.getChildren().addAll(nightCheck, nightField);

        HBox timeBox = new HBox(40);
        timeBox.getChildren().addAll(morningBox, eveningBox, nightBox);

        
        Button submitBtn = new Button("Submit");
        Button clearBtn = new Button("Clear");

        submitBtn.setPrefWidth(100);
        clearBtn.setPrefWidth(100);

        submitBtn.setOnAction(e -> {

            String medicineName = medicineField.getText();

            String mealTime = "";

            if (beforeBtn.isSelected()) {
                mealTime = "Before Meal";
            }

            if (afterBtn.isSelected()) {
                mealTime = "After Meal";
            }

            String schedule = "";

            if (morningCheck.isSelected()) {
                schedule += "Morning ";
            }

            if (eveningCheck.isSelected()) {
                schedule += "Evening ";
            }

            if (nightCheck.isSelected()) {
                schedule += "Night ";
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Medicine Reminder");
            alert.setHeaderText("Medicine Saved");
            alert.setContentText(
                    "Medicine: " + medicineName +
                    "\nMeal Time: " + mealTime +
                    "\nSchedule: " + schedule);

            alert.showAndWait();
        });

        clearBtn.setOnAction(e -> {
            medicineField.clear();

            beforeBtn.setSelected(false);
            afterBtn.setSelected(false);

            morningCheck.setSelected(false);
            eveningCheck.setSelected(false);
            nightCheck.setSelected(false);
        });

        HBox buttonBox = new HBox(30);
        buttonBox.getChildren().addAll(submitBtn, clearBtn);

        VBox root = new VBox(20);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                titleLabel,
                nameBox,
                mealBox,
                timeBox,
                buttonBox
        );

        Scene scene = new Scene(root, 500, 300);

        stage.setTitle("Medicine Reminder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}