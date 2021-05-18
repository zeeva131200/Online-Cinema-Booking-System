/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Sangeetha
 * this is a controller class that has all the methods used 
 * all the buttons, labels , GUI stuff are initialized here
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    public Label successLabel,XsuccessLabel,locationLabel,MovieLabel,DateLabel,movieInfoLabel,durationLabel,languageLabel,genreLabel,summaryLabel,summaryLabel1,summaryLabel2,summaryLabel3,sc4MovieLabel,sc5MovieLabel,sc5SeatLabel,sc5TimeLabel,sc7Total,sc7Bank,sc8MovieLabel,sc8CinemaLabel,sc8DateLabel,sc8SeatLabel,sc8TicketLabel,sc9Movie,sc9Cinema,sc9Hall,sc9Date,sc9Time,sc9Info,sc9Seat,sc9Adult,sc9Children,sc9OKU,sc9Payment,sc9noOfTicket;
    public Label hallNo,sc5Count1,sc5Count2,sc5Count3,sc5Count4,sc5Count5,sc5Total1,sc5Total2,sc5Total3,sc5Total4,sc5Total5,sc5SubTotal,sc6Movie,sc6Cinema,sc6Date,sc6Time,sc6Hall,sc6Seats,TransDate,TransID,sc6Total,noOfTickets;
    public TextField input,input1;
    public PasswordField pswdinput,pswdinput1;
    public ChoiceBox cinemaBox,moviesBox,dateBox,sampleBox,bankListBox;
    public Button btn1,btn2,startBooking,ok,checkbtn,filterbtn,backToSelection,proceed,back,sc4Btn1,sc4Btn2,sc4Btn3,sc4Btn4,sc4Btn5,confirmSeats,cancel,sc5Plus1,sc5Plus2,sc5Plus3,sc5Plus4,sc5Plus5,sc5Minus1,sc5Minus2,sc5Minus3,sc5Minus4,sc5Minus5,sc5NextBtn,sc6BackBtn,sc6ProceedBtn,detail,sc7Cancel,sc7ConfirmBtn,sc8Close,printTickets;
    public RadioButton rb1,rb2,rb3,rb4;
    public ToggleGroup TG;
    public ImageView poster,postersc8,QRcode,bank;
    public AnchorPane popup,mainSc8;
    public WebView webView;
    public String url;
    public final Pattern pattern = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*");
    
    //scene 4 seating buttons
    @FXML
    public Button A01,A02,A03,A04,A05,A06,A07,A08,A09,A10,B01,B02,B03,B04,B05,B06,B07,B08,B09,B10,C01,C02,C03,C04,C05,C06,C07,C08,C09,C10,D01,D02,D03,D04,D05,D06,D07,D08,D09,D10,E01,E02,E03,E04,E05,E06,E07,E08,E09,E10,F01,F02,F03,F04,F05,F06,F07,F08,F09,F10,G01,G02,G03,G04,G05,G06,G07,G08,G09,G10,H01,H02,H03,H04,H05,H06,H07,H08,H09,H10;
    //scene 4 locked icons
    @FXML
    public ImageView lockA1,lockA2,lockA3,lockA4,lockA5,lockA6,lockA7,lockA8,lockA9,lockA10,lockB1,lockB2,lockB3,lockB4,lockB5,lockB6,lockB7,lockB8,lockB9,lockB10,lockC1,lockC2,lockC3,lockC4,lockC5,lockC6,lockC7,lockC8,lockC9,lockC10,lockD1,lockD2,lockD3,lockD4,lockD5,lockD6,lockD7,lockD8,lockD9,lockD10,lockE1,lockE2,lockE3,lockE4,lockE5,lockE6,lockE7,lockE8,lockE9,lockE10,lockF1,lockF2,lockF3,lockF4,lockF5,lockF6,lockF7,lockF8,lockF9,lockF10,lockG1,lockG2,lockG3,lockG4,lockG5,lockG6,lockG7,lockG8,lockG9,lockG10,lockH1,lockH2,lockH3,lockH4,lockH5,lockH6,lockH7,lockH8,lockH9,lockH10; 
    
    @FXML
    String location ,movie,date,movieInfo,posterPath,r1,r2,r3,r4,duration,language,genre,summary,summary1,summary2,summary3,link,selectedTime,hallNum,adult,children,OKU,combo1,combo2,subtotal,Bank,noOfTicket,Transdate,TransId,bankLogo;
    
    
    //SCENE 1
    
    
    //alert box
    @FXML
    public void Success(){      
        XsuccessLabel.setText("Login Successful!\nPress 'OK' to continue ");
        ok.setVisible(true);   
    } 
    @FXML
    public void Xsuccess(){  
        XsuccessLabel.setText("Login Unsuccessful!\nPlease try again");
        ok.setVisible(false);
    }
    @FXML
    public void register(){      
        XsuccessLabel.setText("Register Successful!\nPress 'OK' to continue ");
        ok.setVisible(true);   
    }
    
    
    //SCENE 2
    
    
    //set contents for location box
    LinkedList temp = new LinkedList();
    @FXML
    public void cinemaList(){
        temp.insertAtBack("SELECT CINEMA");
        temp.insertAtBack("Mid Valley");
        temp.insertAtBack("NU Sentral");
        temp.insertAtBack("Pavillion");
        temp.insertAtBack("1 Utama");
        Queue cinemaA = new Queue(5);
        cinemaA.enqueueMany(temp.display());
        cinemaBox.setValue("SELECT CINEMA");
        cinemaBox.getItems().add("SELECT CINEMA");
        cinemaBox.getItems().add(cinemaA.display(1));
        cinemaBox.getItems().add(cinemaA.display(2));
        cinemaBox.getItems().add(cinemaA.display(3));
        cinemaBox.getItems().add(cinemaA.display(4));
    }
    
     //set contents for date box
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);
    LocalDate nxtDay = today.plusDays(2);
    String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
    String formattedDate1 = tomorrow.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
    String formattedDate2 = nxtDay.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

    String day = LocalDate.now().getDayOfWeek().name();
    String day1 = LocalDate.now().plusDays(1).getDayOfWeek().name();
    String day2 = LocalDate.now().plusDays(2).getDayOfWeek().name();
    @FXML
    public void dateList(){   
        Queue dateA = new Queue(1);
        dateA.enqueueMany("SELECT DATE");
       dateBox.setValue("SELECT DATE");
       dateBox.getItems().add(dateA.display(0));
       dateBox.getItems().add(day+"   "+formattedDate);
       dateBox.getItems().add(day1+"   "+formattedDate1);
       dateBox.getItems().add(day2+"   "+formattedDate2);
  }
    
    //displays contents of choicebox
    @FXML
    public void showAction(ActionEvent event){
        cinemaBox.setVisible(true);
        dateBox.setVisible(true);
        filterbtn.setVisible(true);
        cinemaList();
        dateList();
    }
    
    //filters & displays movie list according to location and date
    @FXML
    public void filter(ActionEvent event){
        moviesBox.setVisible(true);
        checkbtn.setVisible(true);
        moviesBox.getItems().clear();
        moviesBox.setValue("SELECT MOVIE");
        
        if(cinemaBox.getValue().equals("Mid Valley")&&dateBox.getValue().equals(day+"   "+formattedDate)){
            moviesBox.getItems().addAll("SELECT MOVIE","Harry Potter","Ratsasan","Jumanji","Divergent","Forensic","Sarkar","Ejen Ali The Movie");
        }
        else if(cinemaBox.getValue().equals("NU Sentral")&&dateBox.getValue().equals(day+"   "+formattedDate)){
            moviesBox.getItems().addAll("SELECT MOVIE","Predator","Munafik","Divergent","Forensic","Ejen Ali The Movie");
        }
        else if(cinemaBox.getValue().equals("Pavillion")&&dateBox.getValue().equals(day+"   "+formattedDate)){
            moviesBox.getItems().addAll("SELECT MOVIE","Godzilla","Divergent","Sarkar","Ejen Ali The Movie","Anna","Aquaman");
        }
        else if(cinemaBox.getValue().equals("1 Utama")&&dateBox.getValue().equals(day+"   "+formattedDate)){
            moviesBox.getItems().addAll("SELECT MOVIE","Aquaman","Godzilla","Divergent","Sarkar","Ejen Ali The Movie","Anna");
        }
        
        
        
        else if(cinemaBox.getValue().equals("Mid Valley")&&dateBox.getValue().equals(day1+"   "+formattedDate1)){
            moviesBox.getItems().addAll("SELECT MOVIE","Train to Busan","Mr Local","6 Underground","Fractured","Fantasy Island","Frozen","Joker","Fast & Furious 6");
        }
        else if(cinemaBox.getValue().equals("NU Sentral")&&dateBox.getValue().equals(day1+"   "+formattedDate1)){
            moviesBox.getItems().addAll("SELECT MOVIE","Soorarai Potru","Joker","Fractured","Frozen","Fast & Furious 6");
        }
        else if(cinemaBox.getValue().equals("Pavillion")&&dateBox.getValue().equals(day1+"   "+formattedDate1)){
            moviesBox.getItems().addAll("SELECT MOVIE","Kahaani","Train to Busan","Fractured","Joker","Fast & Furious 6","Frozen");
        }
        else if(cinemaBox.getValue().equals("1 Utama")&&dateBox.getValue().equals(day1+"   "+formattedDate1)){
            moviesBox.getItems().addAll("SELECT MOVIE","Mulan","Frozen","Joker","Fast & Furious 6","6 Underground","Fractured");
        }
        
        
        
        else if(cinemaBox.getValue().equals("Mid Valley")&&dateBox.getValue().equals(day2+"   "+formattedDate2)){
            moviesBox.getItems().addAll("No movies available!");
        }
        else if(cinemaBox.getValue().equals("Nu Sentral")&&dateBox.getValue().equals(day2+"   "+formattedDate2)){
            moviesBox.getItems().addAll("No movies available!");
        }
        else if(cinemaBox.getValue().equals("Pavillion")&&dateBox.getValue().equals(day2+"   "+formattedDate2)){
            moviesBox.getItems().addAll("No movies available!");
        }
        else if(cinemaBox.getValue().equals("1 Utama")&&dateBox.getValue().equals(day2+"   "+formattedDate2)){
            moviesBox.getItems().addAll("No movies available!");
        }
        else
            moviesBox.getItems().addAll("Please select valid info!");
        
    }
    
    
    //SCENE 3
    
    
    
    //radiobutton..toggle grp allows selection of only one button at a time
    public void rBToggleGrp(){
        TG = new  ToggleGroup();
        this.rb1.setToggleGroup(TG);
        this.rb2.setToggleGroup(TG);
        this.rb3.setToggleGroup(TG);
        this.rb4.setToggleGroup(TG);
    }
    
    //get selected location & movie & date
    public void getLocation(){  
        printLocation();
        DateLabel.setText(date);
        locationLabel.setText(location);
        MovieLabel.setText(movie);
    }
    
    //write selected location , date & movie in text file from scene 2
    public void writeSelectedLocation()throws FileNotFoundException{
        try{
    PrintWriter write = new PrintWriter(new FileOutputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Selected Location.txt",true));
    Object loc = cinemaBox.getValue();
    Object dat = dateBox.getValue();
    Object mov = moviesBox.getValue();
    System.out.println("");
    write.println(loc);
    write.println(dat);
    write.println(mov);
    write.close();
    }catch(FileNotFoundException e){
            System.out.println("error - at writeSelectedLocation method");
    }
    }
    
    //read & assign selected movie,location & date  from txt file
    public void printLocation(){ 
         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Selected Location.txt"));
    while(read.hasNextLine()){
            location = read.nextLine();
            date = read.nextLine();
            movie = read.nextLine();
      }
    
    read.close();
    }catch(Exception e){
        System.out.println("file not found - at printLocation method");
    }
} 
  
//to display chosen poster & other info    
    public void setImage(ActionEvent event) throws Exception{
        getLocation();
        getPoster(MovieLabel.getText());
    Path imageFile = Paths.get(posterPath);
    poster.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));
    movieInfoLabel.setText(movieInfo);
    rb1.setText(r1);
    rb2.setText(r2);
    rb3.setText(r3);
    rb4.setText(r4);
    durationLabel.setText(duration);
    languageLabel.setText(language);
    genreLabel.setText(genre);
    summaryLabel.setText(summary);
    summaryLabel1.setText(summary1);
    
   }

//to select poster & information from file
    public void getPoster(String name){
         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\PosterInfo.txt"));
        while(read.hasNextLine()){
            if(name.equals(read.nextLine())){
                posterPath = read.nextLine();
                movieInfo = read.nextLine();
                r1 = read.nextLine();
                r2 = read.nextLine();
                r3 = read.nextLine();
                r4 = read.nextLine();
                duration = read.nextLine();
                language = read.nextLine();
                genre = read.nextLine();
                summary = read.nextLine();
                summary1 = read.nextLine();
                link = read.nextLine();
                }
            }
    
    read.close();
    }catch(Exception e){
        System.out.println("file not found- at getPoster method");
    }
}
    
    //convert link in txt file to embedded format and plays the video from youtube
       @FXML
    public void play() {
        getPoster(MovieLabel.getText());
        poster.setVisible(false);
        webView.setVisible(true);
           Matcher matcher = pattern.matcher(link);
            if(matcher.find()){
                this.url ="https://www.youtube.com/embed/"+matcher.group(0);
                webView.getEngine().load(this.url);
                System.out.println(this.url);
            }else{
                System.out.println("Invalid Url!");
            }
        }
    
    
    
    //SCENE 4
    
    
    
    //load necessary data/info as soon as scene displayed
    public void sc4GetMovie() throws FileNotFoundException{
        printLocation();
        sc4MovieLabel.setText(movie);
        sc4GetTime();      
        sc4GetDate();
        lockedSeat();
    }
    public void sc4GetTime(){
        getPoster(sc4MovieLabel.getText());
        sc4Btn1.setText(r1);
        sc4Btn2.setText(r2);
        sc4Btn3.setText(r3);
        sc4Btn4.setText(r4);
    }
    public void sc4GetDate(){
        sc4Btn5.setText(date);
    } 
    
    
     LinkedList a = new LinkedList();
    //change color of button
    public void changeBtnColor(ActionEvent event) throws FileNotFoundException{
        Button btn = (Button) event.getSource();
        String color = btn.getStyle();
        System.out.println("ORI : "+color);
            
        if(color.equals("-fx-background-color: #3388ff;")){
            System.out.println("change green");
            btn.setStyle("-fx-background-color: #84FF33;");
          a.insertAtBack(btn.getId());
        }
        else if(color.equals("-fx-background-color: #84FF33;")) {
            System.out.println("chaneg to blue");
            btn.setStyle("-fx-background-color: #3388ff;");   
            a.deleteAtData(btn.getId());
            System.out.println("delete - linked list :"+a.display());
            
        }          
    }
    
    //store the latest content of linked list after deleting activity etc
    public void writeToUPDATEDLinkedList(){ 
       try{
    PrintWriter write = new PrintWriter(new FileOutputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Updated List content.txt"));
    for(int i=0;i<a.length();i++){ 
        write.println(a.getData(i));
    }
    write.close();
    }catch(FileNotFoundException e){
            System.out.println("error - at confirmbtnClicked method");
    }
} 
    
    //to be used in upcoming scenes to retrieve seat data
    LinkedList accurateData = new LinkedList();
    public void readFromUpdatedLinkedList(){        
         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Updated List content.txt"));
    while(read.hasNextLine()){
        String all = read.nextLine();
            accurateData.insertAtBack(all);
      }
            
    read.close();
    }catch(Exception e){
        System.out.println("file not found - at deleteUnselectedSeat method");
    }
} 
    
    public void confirmBtnClicked(){
        //transfer seats from linked list to confirm seats file if payment is done
        //if delete button clicked, ignores chosen seat (does not lock seat)
        System.out.println("confirm btn clicked");
         try{
    PrintWriter write = new PrintWriter(new FileOutputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\confirmSeat.txt",true));
    for(int i=0;i<accurateData.length();i++){ 
        write.println(accurateData.getData(i));
    }
    write.close();
    }catch(FileNotFoundException e){
            System.out.println("error - at confirmbtnClicked method");
    }
    }
    
       //check all the seats in confirm seat file and change color to yellow and put the icon if seat booked
    public void lockedSeat() throws FileNotFoundException{      
        try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\confirmSeat.txt"));
    while(read.hasNextLine()){
        String x = read.nextLine();
        if(A01.getId().equals(x)){
        lockA1.setVisible(true);
        A01.setDisable(true); 
        }
        if(A02.getId().equals(x)){
        lockA2.setVisible(true);
        A02.setDisable(true);
        }
        if(A03.getId().equals(x)){
        lockA3.setVisible(true);
        A03.setDisable(true);
        }
        if(A04.getId().equals(x)){
        lockA4.setVisible(true);
        A04.setDisable(true);
        }
        if(A05.getId().equals(x)){
        lockA5.setVisible(true);
        A05.setDisable(true);
        }
        if(A06.getId().equals(x)){
        lockA6.setVisible(true);
        A06.setDisable(true);
        }
        if(A07.getId().equals(x)){
        lockA7.setVisible(true);
        A07.setDisable(true);
        }
        if(A08.getId().equals(x)){
        lockA8.setVisible(true);
        A08.setDisable(true);
        }
        if(A09.getId().equals(x)){
        lockA9.setVisible(true);
        A09.setDisable(true);
        }
        if(A10.getId().equals(x)){
        lockA10.setVisible(true);
        A10.setDisable(true);
        }
        if(B01.getId().equals(x)){
        lockB1.setVisible(true);
        B01.setDisable(true);
        }
        if(B02.getId().equals(x)){
        lockB2.setVisible(true);
        B02.setDisable(true);
        }
        if(B03.getId().equals(x)){
        lockB3.setVisible(true);
        B03.setDisable(true);
        }
        if(B04.getId().equals(x)){
        lockB4.setVisible(true);
        B04.setDisable(true);
        }
        if(B05.getId().equals(x)){
        lockB5.setVisible(true);
        B05.setDisable(true);
        }
        if(B06.getId().equals(x)){
        lockB6.setVisible(true);
        B06.setDisable(true);
        }
        if(B07.getId().equals(x)){
        lockB7.setVisible(true);
        B07.setDisable(true);
        }
        if(B08.getId().equals(x)){
        lockB8.setVisible(true);
        B08.setDisable(true);
        }
        if(B09.getId().equals(x)){
        lockB9.setVisible(true);
        B09.setDisable(true);
        }
        if(B10.getId().equals(x)){
        lockB10.setVisible(true);
        B10.setDisable(true);
        }
        if(C01.getId().equals(x)){
        lockC1.setVisible(true);
        C01.setDisable(true);
        }
        if(C02.getId().equals(x)){
        lockC2.setVisible(true);
        C02.setDisable(true);
        }
        if(C03.getId().equals(x)){
        lockC3.setVisible(true);
        C03.setDisable(true);
        }
        if(C04.getId().equals(x)){
        lockC4.setVisible(true);
        C04.setDisable(true);
        }
        if(C05.getId().equals(x)){
        lockC5.setVisible(true);
        C05.setDisable(true);
        }
        if(C06.getId().equals(x)){
        lockC6.setVisible(true);
        C06.setDisable(true);
        }
        if(C07.getId().equals(x)){
        lockC7.setVisible(true);
        C07.setDisable(true);
        }
        if(C08.getId().equals(x)){
        lockC8.setVisible(true);
        C08.setDisable(true);
        }
        if(C09.getId().equals(x)){
        lockC9.setVisible(true);
        C09.setDisable(true);
        }
        if(C10.getId().equals(x)){
        lockC10.setVisible(true);
        C10.setDisable(true);
        }
        if(D01.getId().equals(x)){
        lockD1.setVisible(true);
        D01.setDisable(true);
        }
        if(D02.getId().equals(x)){
        lockD2.setVisible(true);
        D02.setDisable(true);
        }
        if(D03.getId().equals(x)){
        lockD3.setVisible(true);
        D03.setDisable(true);
        }
        if(D04.getId().equals(x)){
        lockD4.setVisible(true);
        D04.setDisable(true);
        }
        if(D05.getId().equals(x)){
        lockD5.setVisible(true);
        D05.setDisable(true);
        }
        if(D06.getId().equals(x)){
        lockD6.setVisible(true);
        D06.setDisable(true);
        }
        if(D07.getId().equals(x)){
        lockD7.setVisible(true);
        D07.setDisable(true);
        }
        if(D08.getId().equals(x)){
        lockD8.setVisible(true);
        D08.setDisable(true);
        }
        if(D09.getId().equals(x)){
        lockD9.setVisible(true);
        D09.setDisable(true);
        }
        if(D10.getId().equals(x)){
        lockD10.setVisible(true);
        D10.setDisable(true);
        }
        if(E01.getId().equals(x)){
        lockE1.setVisible(true);
        E01.setDisable(true);
        }
        if(E02.getId().equals(x)){
        lockE2.setVisible(true);
        E02.setDisable(true);
        }
        if(E03.getId().equals(x)){
        lockE3.setVisible(true);
        E03.setDisable(true);
        }
        if(E04.getId().equals(x)){
        lockE4.setVisible(true);
        E04.setDisable(true);
        }
        if(E05.getId().equals(x)){
        lockE5.setVisible(true);
        E05.setDisable(true);
        }
        if(E06.getId().equals(x)){
        lockE6.setVisible(true);
        E06.setDisable(true);
        }
        if(E07.getId().equals(x)){
        lockE7.setVisible(true);
        E07.setDisable(true);
        }
        if(E08.getId().equals(x)){
        lockE8.setVisible(true);
        E08.setDisable(true);
        }
        if(E09.getId().equals(x)){
        lockE9.setVisible(true);
        E09.setDisable(true);
        }
        if(E10.getId().equals(x)){
        lockE10.setVisible(true);
        E10.setDisable(true);
        }
        if(F01.getId().equals(x)){
        lockF1.setVisible(true);
        F01.setDisable(true);
        }
        if(F02.getId().equals(x)){
        lockF2.setVisible(true);
        F02.setDisable(true);
        }
        if(F03.getId().equals(x)){
        lockF3.setVisible(true);
        F03.setDisable(true);
        }
        if(F04.getId().equals(x)){
        lockF4.setVisible(true);
        F04.setDisable(true);
        }
        if(F05.getId().equals(x)){
        lockF5.setVisible(true);
        F05.setDisable(true);
        }
        if(F06.getId().equals(x)){
        lockF6.setVisible(true);
        F06.setDisable(true);
        }
        if(F07.getId().equals(x)){
        lockF7.setVisible(true);
        F07.setDisable(true);
        }
        if(F08.getId().equals(x)){
        lockF8.setVisible(true);
        F08.setDisable(true);
        }
        if(F09.getId().equals(x)){
        lockF9.setVisible(true);
        F09.setDisable(true);
        }
        if(F10.getId().equals(x)){
        lockF10.setVisible(true);
        F10.setDisable(true);
        }
        if(G01.getId().equals(x)){
        lockG1.setVisible(true);
        G01.setDisable(true);
        }
        if(G02.getId().equals(x)){
        lockG2.setVisible(true);
        G02.setDisable(true);
        }
        if(G03.getId().equals(x)){
        lockG3.setVisible(true);
        G03.setDisable(true);
        }
        if(G04.getId().equals(x)){
        lockG4.setVisible(true);
        G04.setDisable(true);
        }
        if(G05.getId().equals(x)){
        lockG5.setVisible(true);
        G05.setDisable(true);
        }
        if(G06.getId().equals(x)){
        lockG6.setVisible(true);
        G06.setDisable(true);
        }
        if(G07.getId().equals(x)){
        lockG7.setVisible(true);
        G07.setDisable(true);
        }
        if(G08.getId().equals(x)){
        lockG8.setVisible(true);
        G08.setDisable(true);
        }
        if(G09.getId().equals(x)){
        lockG9.setVisible(true);
        G09.setDisable(true);
        }
        if(G10.getId().equals(x)){
        lockG10.setVisible(true);
        G10.setDisable(true);
        }
        if(H01.getId().equals(x)){
        lockH1.setVisible(true);
        H01.setDisable(true);
        }
        if(H02.getId().equals(x)){
        lockH2.setVisible(true);
        H02.setDisable(true);
        }
        if(H03.getId().equals(x)){
        lockH3.setVisible(true);
        H03.setDisable(true);
        }
        if(H04.getId().equals(x)){
        lockH4.setVisible(true);
        H04.setDisable(true);
        }
        if(H05.getId().equals(x)){
        lockH5.setVisible(true);
        H05.setDisable(true);
        }
        if(H06.getId().equals(x)){
        lockH6.setVisible(true);
        H06.setDisable(true);
        }
        if(H07.getId().equals(x)){
        lockH7.setVisible(true);
        H07.setDisable(true);
        }
        if(H08.getId().equals(x)){
        lockH8.setVisible(true);
        H08.setDisable(true);
        }
        if(H09.getId().equals(x)){
        lockH9.setVisible(true);
        H09.setDisable(true);
        }
        if(H10.getId().equals(x)){
        lockH10.setVisible(true);
        H10.setDisable(true);
        }
      }
            
    read.close();
    }catch(Exception e){
        System.out.println("file not found - at lockedSeat method");
    }
     }

    //to change seat layout for each hall
    public void Hall1() throws FileNotFoundException{
        writeToSelectedTimeFile(sc4Btn1,"2");
        hallNo.setText("2");
        A01.setVisible(true);
        B01.setVisible(true);
        C01.setVisible(true);
        D01.setVisible(true);
        E01.setVisible(true);
        F01.setVisible(true);
        G01.setVisible(true);
        H01.setVisible(true);
        
        A02.setVisible(true);
        B02.setVisible(true);
        C02.setVisible(true);
        D02.setVisible(true);
        E02.setVisible(true);
        F02.setVisible(true);
        G02.setVisible(true);
        H02.setVisible(true);
        
        A03.setVisible(true);
        B03.setVisible(true);
        C03.setVisible(true);
        D03.setVisible(true);
        E03.setVisible(true);
        F03.setVisible(true);
        G03.setVisible(true);
        H03.setVisible(true);
        
        
        A04.setVisible(true);
        B04.setVisible(true);
        C04.setVisible(true);
        D04.setVisible(true);
        E04.setVisible(true);
        F04.setVisible(true);
        G04.setVisible(true);
        H04.setVisible(true);
        
        A05.setVisible(true);
        B05.setVisible(true);
        C05.setVisible(true);
        D05.setVisible(true);
        E05.setVisible(true);
        F05.setVisible(true);
        G05.setVisible(true);
        H05.setVisible(true);
        
        A06.setVisible(true);
        B06.setVisible(true);
        C06.setVisible(true);
        D06.setVisible(true);
        E06.setVisible(true);
        F06.setVisible(true);
        G06.setVisible(true);
        H06.setVisible(true);
        
        A07.setVisible(true);
        B07.setVisible(true);
        C07.setVisible(true);
        D07.setVisible(true);
        E07.setVisible(true);
        F07.setVisible(true);
        G07.setVisible(true);
        H07.setVisible(true);
        
        A08.setVisible(true);
        B08.setVisible(true);
        C08.setVisible(true);
        D08.setVisible(true);
        E08.setVisible(true);
        F08.setVisible(true);
        G08.setVisible(true);
        H08.setVisible(true);
        
        A09.setVisible(true);
        B09.setVisible(true);
        C09.setVisible(true);
        D09.setVisible(true);
        E09.setVisible(true);
        F09.setVisible(true);
        G09.setVisible(true);
        H09.setVisible(true);
        
        A10.setVisible(true);
        B10.setVisible(true);
        C10.setVisible(true);
        D10.setVisible(true);
        E10.setVisible(true);
        F10.setVisible(true);
        G10.setVisible(true);
        H10.setVisible(true);     
    }
    public void Hall2() throws FileNotFoundException{
        writeToSelectedTimeFile(sc4Btn3,"4");
        hallNo.setText("4");
        A01.setVisible(false);
        B01.setVisible(false);
        C01.setVisible(false);
        D01.setVisible(false);
        E01.setVisible(false);
        F01.setVisible(false);
        G01.setVisible(false);
        H01.setVisible(false);
        lockA1.setVisible(false);
        lockB1.setVisible(false);
        lockC1.setVisible(false);
        lockD1.setVisible(false);
        lockE1.setVisible(false);
        lockF1.setVisible(false);
        lockG1.setVisible(false);
        lockH1.setVisible(false);
        
        
        A02.setVisible(true);
        B02.setVisible(true);
        C02.setVisible(true);
        D02.setVisible(true);
        E02.setVisible(true);
        F02.setVisible(true);
        G02.setVisible(true);
        H02.setVisible(true);
        
        A09.setVisible(true);
        B09.setVisible(true);
        C09.setVisible(true);
        D09.setVisible(true);
        E09.setVisible(true);
        F09.setVisible(true);
        G09.setVisible(true);
        H09.setVisible(true);
        
        A10.setVisible(false);
        B10.setVisible(false);
        C10.setVisible(false);
        D10.setVisible(false);
        E10.setVisible(false);
        F10.setVisible(false);
        G10.setVisible(false);
        H10.setVisible(false);  
        lockA10.setVisible(false);
        lockB10.setVisible(false);
        lockC10.setVisible(false);
        lockD10.setVisible(false);
        lockE10.setVisible(false);
        lockF10.setVisible(false);
        lockG10.setVisible(false);
        lockH10.setVisible(false);
    }
    public void Hall3() throws FileNotFoundException{
        writeToSelectedTimeFile(sc4Btn2,"6");
        hallNo.setText("6");
        A01.setVisible(false);
        B01.setVisible(false);
        C01.setVisible(false);
        D01.setVisible(false);
        E01.setVisible(false);
        F01.setVisible(false);
        G01.setVisible(false);
        H01.setVisible(false);
        lockA1.setVisible(false);
        lockB1.setVisible(false);
        lockC1.setVisible(false);
        lockD1.setVisible(false);
        lockE1.setVisible(false);
        lockF1.setVisible(false);
        lockG1.setVisible(false);
        lockH1.setVisible(false);
        
        A02.setVisible(false);
        B02.setVisible(false);
        C02.setVisible(false);
        D02.setVisible(false);
        E02.setVisible(false);
        F02.setVisible(false);
        G02.setVisible(false);
        H02.setVisible(false);
        lockA2.setVisible(false);
        lockB2.setVisible(false);
        lockC2.setVisible(false);
        lockD2.setVisible(false);
        lockE2.setVisible(false);
        lockF2.setVisible(false);
        lockG2.setVisible(false);
        lockH2.setVisible(false);
        
        A09.setVisible(false);
        B09.setVisible(false);
        C09.setVisible(false);
        D09.setVisible(false);
        E09.setVisible(false);
        F09.setVisible(false);
        G09.setVisible(false);
        H09.setVisible(false);
        lockA9.setVisible(false);
        lockB9.setVisible(false);
        lockC9.setVisible(false);
        lockD9.setVisible(false);
        lockE9.setVisible(false);
        lockF9.setVisible(false);
        lockG9.setVisible(false);
        lockH9.setVisible(false);
        
        A10.setVisible(false);
        B10.setVisible(false);
        C10.setVisible(false);
        D10.setVisible(false);
        E10.setVisible(false);
        F10.setVisible(false);
        G10.setVisible(false);
        H10.setVisible(false); 

    }
    public void Hall4() throws FileNotFoundException{
        writeToSelectedTimeFile(sc4Btn4,"7");
        hallNo.setText("7");
        A01.setVisible(true);
        B01.setVisible(true);
        C01.setVisible(true);
        D01.setVisible(true);
        E01.setVisible(true);
        F01.setVisible(true);
        G01.setVisible(true);
        H01.setVisible(true);
        
        
        A02.setVisible(true);
        B02.setVisible(true);
        C02.setVisible(true);
        D02.setVisible(true);
        E02.setVisible(true);
        F02.setVisible(true);
        G02.setVisible(true);
        H02.setVisible(true);
        
        A09.setVisible(false);
        B09.setVisible(false);
        C09.setVisible(false);
        D09.setVisible(false);
        E09.setVisible(false);
        F09.setVisible(false);
        G09.setVisible(false);
        H09.setVisible(false);
        lockA9.setVisible(false);
        lockB9.setVisible(false);
        lockC9.setVisible(false);
        lockD9.setVisible(false);
        lockE9.setVisible(false);
        lockF9.setVisible(false);
        lockG9.setVisible(false);
        lockH9.setVisible(false);
        
        A10.setVisible(false);
        B10.setVisible(false);
        C10.setVisible(false);
        D10.setVisible(false);
        E10.setVisible(false);
        F10.setVisible(false);
        G10.setVisible(false);
        H10.setVisible(false); 
        lockA10.setVisible(false);
        lockB10.setVisible(false);
        lockC10.setVisible(false);
        lockD10.setVisible(false);
        lockE10.setVisible(false);
        lockF10.setVisible(false);
        lockG10.setVisible(false);
        lockH10.setVisible(false);
    }
    
    
    //SCENE 5
    
    //load all methods/info into scene 5 as soon as display
    public void load() throws FileNotFoundException{
        String timeData = null;
        printLocation();
        sc5MovieLabel.setText(movie);
        readFromUpdatedLinkedList();
        //accurate Data is linked List
        sc5SeatLabel.setText(accurateData.display());  
        readFromSelectedTimeFile();
        sc5TimeLabel.setText(selectedTime);
    }
    
    //write selected time to a file
    public void writeToSelectedTimeFile(Button btn,String hallNo)throws FileNotFoundException{
        try{
    PrintWriter write = new PrintWriter(new FileOutputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\SelectedTime.txt"));
    write.println(btn.getText());
    write.println(hallNo);
    write.close();
    }catch(FileNotFoundException e){
            System.out.println("error - at writeToSelectedTimeFile method");
    }
    }
    
    //read the selected time file
    public void readFromSelectedTimeFile(){ 
         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\SelectedTime.txt"));
        selectedTime = read.nextLine(); 
        hallNum = read.nextLine()  ; 
    read.close(); 
    }catch(Exception e){
        System.out.println("file not found - at readfromselectedTime method");
    }
} 
    
    // to increment&decrement quantity accordingly & calculate subtotal according to qty
    public void setCount(ActionEvent event) throws Exception{
        Button btn = (Button) event.getSource();
        String symbol = btn.getId();
        int count;
        double calculate;
        String convert,convert1;
        
        if(symbol.equals("sc5Plus1")){
            count = Integer.parseInt(sc5Count1.getText());
            count++;
            convert = Integer.toString(count);
            sc5Count1.setText(convert);
            calculate = 10.00*count;
            convert1 = Double.toString(calculate);
            sc5Total1.setText(convert1+"0");
        }
        if(symbol.equals("sc5Plus2")){
            count = Integer.parseInt(sc5Count2.getText());
            count++;
            convert = Integer.toString(count);
            sc5Count2.setText(convert);
            calculate = 7.00*count;
            convert1 = Double.toString(calculate);
            sc5Total2.setText(convert1+"0");
        }
        if(symbol.equals("sc5Plus3")){
            count = Integer.parseInt(sc5Count3.getText());
            count++;
            convert = Integer.toString(count);
            sc5Count3.setText(convert);
            calculate = 5.00*count;
            convert1 = Double.toString(calculate);
            sc5Total3.setText(convert1+"0");
        }
        if(symbol.equals("sc5Plus4")){
            count = Integer.parseInt(sc5Count4.getText());
            count++;
            convert = Integer.toString(count);
            sc5Count4.setText(convert);
            calculate = 10.00*count;
            convert1 = Double.toString(calculate);
            sc5Total4.setText(convert1+"0");
        }
        if(symbol.equals("sc5Plus5")){
            count = Integer.parseInt(sc5Count5.getText());
            count++;
            convert = Integer.toString(count);
            sc5Count5.setText(convert);
            calculate = 8.00*count;
            convert1 = Double.toString(calculate);
            sc5Total5.setText(convert1+"0");
        }
        if(symbol.equals("sc5Minus1")){
            count = Integer.parseInt(sc5Count1.getText());
            count--;
            convert = Integer.toString(count);
            sc5Count1.setText(convert);
            calculate = 10.00*count;
            convert1 = Double.toString(calculate);
            sc5Total1.setText(convert1+"0");
        }
        if(symbol.equals("sc5Minus2")){
            count = Integer.parseInt(sc5Count2.getText());
            count--;
            convert = Integer.toString(count);
            sc5Count2.setText(convert);
            calculate = 7.00*count;
            convert1 = Double.toString(calculate);
            sc5Total2.setText(convert1+"0");
        }
        if(symbol.equals("sc5Minus3")){
            count = Integer.parseInt(sc5Count3.getText());
            count--;
            convert = Integer.toString(count);
            sc5Count3.setText(convert);
            calculate = 5.00*count;
            convert1 = Double.toString(calculate);
            sc5Total3.setText(convert1+"0");
        }
        if(symbol.equals("sc5Minus4")){
            count = Integer.parseInt(sc5Count4.getText());
            count--;
            convert = Integer.toString(count);
            sc5Count4.setText(convert);
            calculate = 10.00*count;
            convert1 = Double.toString(calculate);
            sc5Total4.setText(convert1+"0");
        }
        if(symbol.equals("sc5Minus5")){
            count = Integer.parseInt(sc5Count5.getText());
            count--;
            convert = Integer.toString(count);
            sc5Count5.setText(convert);
            calculate = 8.00*count;
            convert1 = Double.toString(calculate);
            sc5Total5.setText(convert1+"0");
        }
        subtotal();
    }
    
    public void subtotal(){
       String total1 = sc5Total1.getText();
       Double tot1 = Double.parseDouble(total1);
       String total2 = sc5Total2.getText();
       Double tot2 = Double.parseDouble(total2);
       String total3 = sc5Total3.getText();
       Double tot3 = Double.parseDouble(total3);
       String total4 = sc5Total4.getText();
       Double tot4 = Double.parseDouble(total4);
       String total5 = sc5Total5.getText();
       Double tot5 = Double.parseDouble(total5);;
       
       Double subtotal = tot1 + tot2 + tot3 + tot4 + tot5;
       String sub = Double.toString(subtotal);
       sc5SubTotal.setText(sub+"0");
    }
    
        //write selected tickets and total money to a file
    public void writeToSelectedTicketsFile()throws FileNotFoundException{
        try{
    PrintWriter write = new PrintWriter(new FileOutputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Selected Tickets.txt"));
    write.println(sc5Count1.getText());
    write.println(sc5Count2.getText());
    write.println(sc5Count3.getText());
    write.println(sc5Count4.getText()); 
    write.println(sc5Count5.getText());
    write.println(sc5SubTotal.getText());
    write.close();
    }catch(FileNotFoundException e){
            System.out.println("error - at writeToSelectedTicketsFile method");
    }
    }
    
    //read the selected tickets file
    public void readFromSelectedTicketsFile(){ 
         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Selected Tickets.txt"));
        adult = read.nextLine(); 
        children = read.nextLine();
        OKU = read.nextLine();
        combo1 = read.nextLine();
        combo2 = read.nextLine();
        subtotal = read.nextLine();
    read.close(); 
    }catch(Exception e){
        System.out.println("file not found - at readfromselectedTickets method");
    }
} 
    
    //SCENE 6
    
    
    @FXML
    public void BankName(){
        bankListBox.setValue("Please select an option");
        bankListBox.getItems().addAll("Please select an option","Credit/Debit card","CIMB Clicks","Maybank2U","PayPal","Public eBank","RHB Now");
    }
    
    public void setLabel(){
        BankName();
        Random r = new Random();
        int i = r.nextInt(100000)+10000;
        String id = Integer.toString(i);
        printLocation();
        readFromUpdatedLinkedList();
        readFromSelectedTicketsFile();
        readFromSelectedTimeFile();
        
        
        sc6Movie.setText(movie);
        sc6Cinema.setText(location);
        sc6Date.setText(date + " "+selectedTime);
        sc6Hall.setText(hallNum);
        sc6Seats.setText(accurateData.display());
        
        String x = children + adult + OKU ;
        int c = Integer.parseInt(children);
        int a = Integer.parseInt(adult);
        int o = Integer.parseInt(OKU);
        int total = c+a+o;
        String numOfTickets = Integer.toString(total);
        noOfTickets.setText(numOfTickets);
        
//        Date today = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
//        String strDate = dateFormat.format(today);
LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);
    String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
    System.out.println(formattedDate);
        TransDate.setText(formattedDate);
        
        TransID.setText(id);
        sc6Total.setText(subtotal);
        
    }
    
    
    //SCENE 7
    
    
    public void loadSc7() throws Exception{
        readFromSelectedTicketsFile();
        sc7Total.setText(subtotal);
        readFromSelectedBankFile();
        sc7Bank.setText(Bank);
        setLogo();
    }
    
    //to show chosen bank logo  
    public void setLogo() throws Exception{
        getBankLogo(sc7Bank.getText());
    Path imageFile = Paths.get(bankLogo);
    bank.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));

   }

//to select poster from file
    public void getBankLogo(String name){
         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Bank Logo.txt"));
        while(read.hasNextLine()){
            if(name.equals(read.nextLine())){
                bankLogo = read.nextLine();
                }
            }
    
    read.close();
    }catch(Exception e){
        System.out.println("file not found- at getPoster method");
    }
}
    public void writeToSelectedBankFile()throws FileNotFoundException{
        try{
    PrintWriter write = new PrintWriter(new FileOutputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Selected Bank.txt"));
    write.println(bankListBox.getValue());
    write.println(noOfTickets.getText());
    write.println(TransDate.getText());
    write.println(TransID.getText());

    write.close();
    }catch(FileNotFoundException e){
            System.out.println("error - at writeToSelectedBankFile method");
    }
    }
    
    //read the selected bank file
    public void readFromSelectedBankFile(){ 
         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\Selected Bank.txt"));
        Bank = read.nextLine(); 
        noOfTicket = read.nextLine(); 
        Transdate = read.nextLine(); 
        TransId = read.nextLine(); 

    read.close(); 
    }catch(Exception e){
        System.out.println("file not found - at readfromselectedBank method");
    }
} 
    
    
    
    //SCENE 8
    
    
    
    public void loadSc8() throws MalformedURLException{
        popup.setVisible(false);
        printLocation();
        readFromUpdatedLinkedList();
        readFromSelectedTicketsFile();
        readFromSelectedTimeFile();
        readFromSelectedBankFile();
        sc8MovieLabel.setText(movie);
        sc8CinemaLabel.setText(location);
        sc8DateLabel.setText(date + " "+selectedTime);
        sc8SeatLabel.setText(accurateData.display());
        sc8TicketLabel.setText(noOfTicket);
        
    getPoster(sc8MovieLabel.getText());
    Path imageFile = Paths.get(posterPath);
    postersc8.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));
    summaryLabel2.setText(summary);
    summaryLabel3.setText(summary1);    
    }
   
    
    
    //SCENE 9
    
    
    public void sc9Load(){
        printLocation();
        readFromUpdatedLinkedList();
        readFromSelectedTicketsFile();
        readFromSelectedTimeFile();
        readFromSelectedBankFile();
    sc9Movie.setText(movie);
    sc9Cinema.setText(location);
    sc9Hall.setText(hallNum);
    sc9Date.setText(date); 
    sc9Time.setText(selectedTime);
    
    getPoster(sc9Movie.getText());
    sc9Info.setText(movieInfo);
    
    sc9Seat.setText(accurateData.display());
    sc9Adult.setText(adult);
    sc9Children.setText(children);
    sc9OKU.setText(OKU);
    sc9Payment.setText(Bank);
    sc9noOfTicket.setText(noOfTicket);
    
    QRcode.setVisible(true);
    }
    
    
    
    //used in all scenes..to change from 1 scene to another
    
    
    
    @FXML
    public void changeScenes(ActionEvent event)throws Exception{
        Stage stage;
        Parent root;
        
        if(event.getSource()==ok||event.getSource()==backToSelection){
            stage = (Stage) ok.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MovieSelection.fxml"));
        }
        else if(event.getSource()==checkbtn){
            stage = (Stage) checkbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Showtimes.fxml"));
        }
        else if(event.getSource()==proceed){
            stage = (Stage) checkbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Seating.fxml"));
        }
        else if(event.getSource()==back){
            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Showtimes.fxml"));
        }
        else if(event.getSource()==confirmSeats){
            stage = (Stage) confirmSeats.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Purchase.fxml"));
        }
        else if(event.getSource()==sc6BackBtn){
            stage = (Stage) sc6BackBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Purchase.fxml"));
        }
        else if(event.getSource()==cancel){
            stage = (Stage) cancel.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MovieSelection.fxml"));
        }
        else if(event.getSource()==sc5NextBtn){
            stage = (Stage) sc5NextBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
        }
        else if(event.getSource()==sc6ProceedBtn){
            stage = (Stage) sc6ProceedBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        }
        else if(event.getSource()==sc7Cancel){
            stage = (Stage)  sc7Cancel.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MovieSelection.fxml"));
        }
        else if(event.getSource()==sc7ConfirmBtn){
            stage = (Stage)  sc7ConfirmBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Summary.fxml"));
        }
        else if(event.getSource()==printTickets){
            stage = (Stage)  printTickets.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
        }
        else{
            stage = (Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        if(event.getSource()==checkbtn){
            writeSelectedLocation();
        }
        if(event.getSource()==confirmSeats){
            writeToUPDATEDLinkedList();
        }
        if(event.getSource()==sc5NextBtn){
           writeToSelectedTicketsFile();
        }       
        if(event.getSource()==sc6ProceedBtn){
            writeToSelectedBankFile();  
        }
        if(event.getSource()==sc7ConfirmBtn){
            readFromUpdatedLinkedList();
            confirmBtnClicked();
        }
    }
    
    
    //SCENE 1 - LOGiN , verify paswd&username , if not register new name & pswd
    
    @FXML
    private void loginAction(ActionEvent event){
        int ans = verify(input.getText(),pswdinput.getText());
        if(ans==1){
            Success();
        }
        else
            Xsuccess();
//            System.exit(0);
    }
    
    public void filewrite()throws FileNotFoundException{
        register();
        try{
    PrintWriter write = new PrintWriter(new FileOutputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\UserAccount.txt",true));
    String name = input1.getText();
    String p  = pswdinput1.getText();
    System.out.println("");
    write.println(name);
    write.println(p);
    write.close();
    }catch(FileNotFoundException e){
            System.out.println("error - at filewrite method");
    }
    }
    
    public int verify(String username, String pswd){
        int found = 0; //false

         try{
    Scanner read = new Scanner(new FileInputStream("C:\\Users\\Sangeetha\\Documents\\NetBeansProjects\\DS-PROJECT\\UserAccount.txt"));
        while(read.hasNextLine()){
            if(username.equals(read.nextLine())){
                if(pswd.equals(read.nextLine())){
                    found = 1;  //true
                }
            }
        }
    
    read.close();
     System.out.println(found);
    }catch(Exception e){
        System.out.println("file not found - at verify method");
    }
    return found;
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        }    
    
}

