import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.geometry.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import java.text.DecimalFormat;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.lang.Math;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.effect.GaussianBlur;
import java.io.*;
import java.util.*;
import java.sql.*;

public class App extends Application {
    int randNum = 0;
    FileInputStream fi = null;
    DataInputStream di = null;
    FileOutputStream fo = null;
    Writer wr = null;
    int OTP = 0;
    Scanner scnr = null;

    public void start(Stage stage) throws Exception {
        FlowPane parent = new FlowPane(Orientation.VERTICAL, 10, 10);
        FlowPane[] fp = new FlowPane[12];
        for (int i = 0; i < 12; i++) {
            fp[i] = new FlowPane(Orientation.HORIZONTAL);
            fp[i].setPrefWrapLength(800);
            fp[i].setAlignment(Pos.CENTER);
            fp[i].setColumnHalignment(HPos.CENTER);
            fp[i].setRowValignment(VPos.CENTER);
        }
        Text stars[] = new Text[10];
        for (int i = 0; i < 10; i++) {
            stars[i] = new Text("*");
            stars[i].setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
            stars[i].setFill(Color.RED);
        }
        ToggleGroup groupID = new ToggleGroup();
        RadioButton envID = new RadioButton("Enrollment ID");
        envID.setToggleGroup(groupID);
        RadioButton aadharID = new RadioButton("Aadhar No.");
        aadharID.setToggleGroup(groupID);
        // 1
        Text hasID = new Text("I have ");
        hasID.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        // 2
        Text whichID = new Text("Enrollment ID/Aadhar No. ");
        whichID.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        TextField ifEnv = new TextField();
        TextField ifAdr = new TextField();
        // ifAdr.setEditable(false);
        ifEnv.setDisable(true);
        ifAdr.setDisable(true);
        // 3
        Text fullName = new Text("Full Name : ");
        fullName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        TextField fullNameText = new TextField();
        // 4
        Text pinCode = new Text("Pincode");
        pinCode.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        TextField pinCodeText = new TextField();
        // 5
        Text image = new Text("Image :");
        image.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Text hash = new Text("#");
        hash.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        hash.setFill(Color.RED);
        Text t2 = new Text();
        t2.setCache(true);
        randNum = getRandomNumber(100000, 999999);
        t2.setText(Integer.toString(randNum));
        t2.setFill(Color.RED);
        t2.setFont(Font.font(null, FontWeight.BOLD, 36));
        t2.setEffect(new GaussianBlur());
        // 6
        Text imageText = new Text("Enter above Image Text");
        imageText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        TextField imageText_ = new TextField();
        // 7
        Text phoneNum = new Text("Phone Number : ");
        phoneNum.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        TextField phoneNumText = new TextField();
        // 8
        Button getOTP = new Button("Get One Time Password");
        getOTP.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
        // 9
        Text warn = new Text("");
        warn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        warn.setFill(Color.RED);
        // Scene 2
        FlowPane parent2 = new FlowPane(Orientation.VERTICAL, 10, 10);
        Text enterOTP = new Text("Enter OTP : ");
        TextField enterOTPText = new TextField();
        Button validate = new Button("Validate & Download");
        Text reply = new Text("");
        fp[9].getChildren().add(enterOTP);
        fp[9].getChildren().add(stars[6]);
        fp[9].getChildren().add(enterOTPText);
        fp[10].getChildren().add(validate);
        fp[11].getChildren().add(reply);
        parent2.getChildren().add(fp[9]);
        parent2.getChildren().add(fp[10]);
        parent2.getChildren().add(fp[11]);
        Scene scene2 = new Scene(parent2, 800, 800);
        envID.setOnAction((event) -> {
            try {
                ifEnv.setDisable(false);
                ifAdr.setDisable(true);
            } catch (Exception e) {
            }
        });
        aadharID.setOnAction((event) -> {
            try {
                ifEnv.setDisable(true);
                ifAdr.setDisable(false);
            } catch (Exception e) {
            }
        });
        getOTP.setOnAction((event) -> {
            boolean flag = false;
            int btn = -1;
            try {
                if (envID.isSelected()) {
                    ifEnv.setDisable(false);
                    btn = 0;
                    flag = true;
                } else if (aadharID.isSelected()) {
                    aadharID.setDisable(false);
                    btn = 1;
                    flag = true;
                } else {
                    warn.setText("Choose ID reference");
                }
                if (flag == true) {
                    if (btn == 0 && ifEnv.getText().isEmpty()) {
                        warn.setText("Enter E_ID");
                        flag = false;
                    } else if (btn == 1 && ifAdr.getText().isEmpty()) {
                        warn.setText("Enter Adhar_No");
                        flag = false;
                    }
                }
                if (flag == true) {
                    if (fullNameText.getText().isEmpty() == true) {
                        warn.setText("Enter your name!");
                        flag = false;
                    }
                }
                if (flag == true) {
                    if (pinCodeText.getText().isEmpty() == true) {
                        warn.setText("Enter pincode");
                        flag = false;
                    }
                }
                if (flag == true) {
                    if (imageText_.getText().isEmpty() == true) {
                        warn.setText("Enter the capcha!");
                        flag = false;
                    }
                }
                if (flag == true) {
                    if (phoneNumText.getText().isEmpty() == true) {
                        warn.setText("Enter phone number.");
                        flag = false;
                    }
                }
                di = new DataInputStream(new FileInputStream("otp.dat"));
                int b = (int) (Math.random() * (5000));
                while (di.available() > 0 && b >= 0) {
                    OTP = di.readInt();
                    b--;
                }
                di.close();
                wr = new FileWriter(new File("AadharOTP.txt"));
                wr.write(Integer.toString(OTP));
                wr.close();
                if (flag == true)
                    stage.setScene(scene2);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        validate.setOnAction((event) -> {
            if (enterOTPText.getText().equals(Integer.toString(OTP))) {
                reply.setText("Your Aadhar Card Update is noted and will be processed soon");
            } else {
                reply.setText("Invalid OTP!");
            }
        });
        fp[0].getChildren().add(hasID);
        fp[0].getChildren().add(stars[0]);
        fp[0].getChildren().add(envID);
        fp[0].getChildren().add(aadharID);
        fp[1].getChildren().add(whichID);
        fp[1].getChildren().add(stars[1]);
        fp[1].getChildren().add(ifEnv);
        fp[1].getChildren().add(ifAdr);
        fp[2].getChildren().add(fullName);
        fp[2].getChildren().add(stars[2]);
        fp[2].getChildren().add(fullNameText);
        fp[3].getChildren().add(pinCode);
        fp[3].getChildren().add(stars[3]);
        fp[3].getChildren().add(pinCodeText);
        fp[4].getChildren().add(image);
        fp[4].getChildren().add(hash);
        fp[4].getChildren().add(t2);
        fp[5].getChildren().add(imageText);
        fp[5].getChildren().add(stars[4]);
        fp[5].getChildren().add(imageText_);
        fp[6].getChildren().add(phoneNum);
        fp[6].getChildren().add(stars[5]);
        fp[6].getChildren().add(phoneNumText);
        fp[7].getChildren().add(getOTP);
        fp[8].getChildren().add(warn);
        for (int i = 0; i < 9; i++) {
            parent.getChildren().add(fp[i]);
        }
        Scene scene1 = new Scene(parent, 800, 800);
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

    // Creating Random Number
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}