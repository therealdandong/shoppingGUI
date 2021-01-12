//Class representing an electronic store
//Has an array of products that represent the items the store can sell

package sample.baseCode;
import java.lang.reflect.Array;
import java.util.*;

public class ElectronicStore{
  public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
  private int curProducts;
  private String name;
  private Product[] stock; //Array to hold all products
  private double revenue;
  private int numberOfSale;

  private List<String> currentCart;


  public ElectronicStore(String initName){
    revenue = 0.0;
    name = initName;
    stock = new Product[MAX_PRODUCTS];
    curProducts = 0;
    numberOfSale = 0;
    currentCart = new ArrayList<String>();
  }
  
  public String getName(){
    return name;
  }
  public int getNumberOfSale(){return numberOfSale;}
  //Adds a product and returns true if there is space in the array
  //Returns false otherwise
  public boolean addProduct(Product newProduct){
    if(curProducts < MAX_PRODUCTS){
     stock[curProducts] = newProduct;
     curProducts++;
     return true;
    }
    return false;
  }



  public String[] getPopularItem(){

    String[] bigThree = new String[3];
    int biggestSale,secondSale,thirdSale;

    ArrayList<Integer> arraying = new ArrayList<Integer>();
    for(int i =0;i<curProducts;i++){
      arraying.add(stock[i].getSoldQuantity());
    }
    Collections.sort(arraying);
    biggestSale= arraying.get(arraying.size()-1);
    secondSale = arraying.get(arraying.size()-2);
    thirdSale  = arraying.get(arraying.size()-3);

    int secondIndex = 0;
    int biggestIndex = 0;
    for(int j =0;j<3;j++){
      for (int i =0;i<curProducts;i++){
        if(stock[i].getSoldQuantity()==biggestSale && j == 0){
          biggestIndex = i;
          bigThree[0] = stock[i].toString();
          break;
        }
        if(stock[i].getSoldQuantity()==secondSale && j == 1 && i != biggestIndex){
          secondIndex = i;
          bigThree[1] = stock[i].toString();
          break;
        }
        if(stock[i].getSoldQuantity()==thirdSale && j == 2 && i != biggestIndex && i!= secondIndex){
          bigThree[2] = stock[i].toString();
          break;
        }
      }
    }
    return bigThree;


  }

  public void removeProductFromCart(String string,int index){

    for(int i =0;i<curProducts;i++){
        if(stock[i].toString().equals(string)){
          currentCart.remove(index);
          stock[i].returnToCart();
        }
    }
  }





  public void addProductToCart(String string){
    for(int i = 0;i< curProducts;i++){
      if(stock[i].toString().equals(string)){
        currentCart.add(stock[i].addToCart().toString());
      }
    }
  }








  public void reset(){
    revenue = 0.0;
    stock = new Product[MAX_PRODUCTS];
    curProducts = 0;
    numberOfSale = 0;
    currentCart = new ArrayList<String>();
    Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
    Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
    Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
    Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
    addProduct(d1);
    addProduct(d2);
    addProduct(l1);
    addProduct(l2);
    addProduct(f1);
    addProduct(f2);
    addProduct(t1);
    addProduct(t2);
  }


  public double getCurrentCartValue(){
    double allValue = 0;
    for(String product:currentCart) {
      for (int i = 0; i < curProducts; i++) {
        if (stock[i].toString().equals(product)){
          allValue += stock[i].getPrice();

        }
      }
    }
    return allValue;


  }

  public String[] getCurrentCart(){
    String[] result = new String[currentCart.size()];
    int i =0;
    for(String product:currentCart){
      result[i++] = product;
    }
    return result;
  }

  public double getRevenue(){
    return revenue;
  }
  
  //Prints the stock of the store
  public String[]  getStock(){
    List<String> result = new ArrayList<String>();

    for(Product product:stock){
      if (product != null){
        if(product.getStockQuantity()!=0){
          result.add(product.toString());
        }
      }
    }
    String[] stringArray = new String[result.size()];
    for(int i=0;i<result.size();i++){
      stringArray[i] = result.get(i);
    }
    return stringArray;
  }








  public void sellCurrentCart(){
    for(String product:currentCart) {
      for (int i = 0; i < curProducts; i++) {
        if (stock[i].toString().equals(product)){
          revenue += stock[i].getPrice();
          stock[i].sold();
        }
      }
    }
    currentCart = new ArrayList<String>();
    numberOfSale+=1;
  }




  public static ElectronicStore createStore(){
    ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
    Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
    Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
    Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
    Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    return store1;
  }
} 