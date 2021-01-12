package sample.View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

public abstract class ItemView extends Pane {
    private String title;
    private double sizeX;
    private double sizeY;
    private String buttonName;
    private Label labelTitle;
    private int xLocation;
    private int yLocation;
    private Pane basePane;
    private Button button;
    private ListView<String> contentList;


    public ItemView(String initTitle,double initSizeX,double initSizeY,int initX,int initY, String initButtonName){
        title = initTitle;
        sizeX = initSizeX;
        sizeY = initSizeY;
        xLocation = initX;
        yLocation = initY;
        buttonName = initButtonName;
    }


    public Pane drawPane(int x,int y){
        basePane = new Pane();
        this.drawListView();
        this.drawButton();
        this.drawLabel();
        basePane.getChildren().addAll(contentList,labelTitle,button);
        basePane.relocate(x,y);
        return basePane;
    }


    private void drawListView(){
        contentList = new ListView<String>();
        // to do: populate the list with view;
        contentList.setPrefSize(sizeX,sizeY);
        contentList.relocate(xLocation,yLocation);
    }


    public void drawButton(){
        button = new Button();
        button.relocate(xLocation+10 ,yLocation+sizeY+10);
        button.setPrefSize(120,30);
        button.setText(buttonName);
        button.setWrapText(true);
    }


    private void drawLabel(){
        labelTitle = new Label(title);
        labelTitle.relocate((sizeX-80)/2,10);
        labelTitle.setPrefSize(150,30);
        labelTitle.setWrapText(true);
        labelTitle.setTextAlignment(TextAlignment.CENTER);
    }



    public Button getButton(){
        return button;
    }
    public ListView<String> getContentList(){
        return contentList;
    }
    public Label getLabelTitle(){
        return labelTitle;
    }
    public int getXLocation(){return xLocation;}
    public int getYLocation(){return yLocation;}
    public double getYSize(){return sizeY;}
    public double getXSize(){return sizeX;}
    public Pane getBasePane(){return basePane;}
}
