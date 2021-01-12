package sample;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.View.*;
import javafx.scene.layout.Pane;
import sample.baseCode.ElectronicStore;

public class ElectronicStoreView extends Pane{
    private PopularItem popularItem;
    private StoreStock storeStock;
    private CurrentCart currentCart;
    private Summary summaryStore;
    private ElectronicStore model;


    private Button resetButton;
    private Button addButton;
    private Button removeButton;
    private Button completeButton;
    private ListView<String> popularList;
    private ListView<String> stockList;
    private ListView<String> cartList;

    public ElectronicStoreView(ElectronicStore initModel){
        popularItem = new PopularItem("Most popular items",160,140,40,50,"Reset Store");

        storeStock = new StoreStock("Store Stock: ",280,300,10,50,"Add to Card");

        currentCart = new CurrentCart("Current Cart ($ 0.00)",280,300,10,50,"Remove from Cart");
        summaryStore = new Summary();
        model = initModel;
        getChildren().addAll(popularItem.drawPane(0,160),storeStock.drawPane(200,0),currentCart.drawPane(500,0),summaryStore);
        resetButton = popularItem.getButton();
        addButton = storeStock.getButton();
        addButton.relocate(storeStock.getXLocation()+80 ,storeStock.getYLocation()+storeStock.getYSize()+10);
        removeButton = currentCart.getButton();
        completeButton = currentCart.getSalesButton();
        popularList = popularItem.getContentList();
        stockList = storeStock.getContentList();
        cartList = currentCart.getContentList();
        update();
    }
    public void update(){
        summaryStore.getNumberField().setText(String.valueOf(model.getNumberOfSale()));
        summaryStore.getRevenueField().setText(String.valueOf(model.getRevenue()));
        if (model.getNumberOfSale() == 0){
            summaryStore.getAverageSaleField().setText("N/A");
        }else{
            summaryStore.getAverageSaleField().setText(String.valueOf(model.getRevenue()/model.getNumberOfSale()));
        }
        // update most  popular list
        popularItem.getContentList().setItems(FXCollections.observableArrayList(model.getPopularItem()));
        storeStock.getContentList().setItems(FXCollections.observableArrayList(model.getStock()));
        currentCart.getContentList().setItems(FXCollections.observableArrayList(model.getCurrentCart()));
        currentCart.getLabelTitle().setText(String.format("Current Cart ($ %.2f)",model.getCurrentCartValue()));
        if(model.getCurrentCart().length ==0){
            completeButton.setDisable(true);
            removeButton.setDisable(true);
        }
        int index =stockList.getSelectionModel().getSelectedIndex();
        if(index >= 0){
            addButton.setDisable(false);
        }else{
            addButton.setDisable(true);
        }
    }
    public Button getResetButton(){
        return resetButton;
    }
    public Button getAddButton(){
        return addButton;
    }
    public Button getRemoveButton(){
        return removeButton;
    }
    public Button getCompleteButton(){
        return completeButton;
    }

    public ListView<String> getStockList(){return stockList;}

    public ListView<String> getCartList(){return cartList;}

}
