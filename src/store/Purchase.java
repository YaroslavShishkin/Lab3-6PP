package store;

import java.util.*;

import static constants.Constants.*;

public class Purchase {

    List<Product> productList;

    public Purchase() {

        productList = new ArrayList<>();
    }

    public Purchase(ArrayList<Product> productList) {

        this.productList = productList;
    }

    public List<Product> getProductList() {

        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {

        this.productList = productList;
    }

    public void addProduct(Product product) {

        productList.add(product);
    }

    public void deleteProduct(Product product) {

        productList.remove(product);
    }

    public void informationAboutElementsProductList() {

        productList.forEach(e -> System.out.println(e.getDescription()));
    }

    public ArrayList<Product> repeatedList() {

        HashSet<Product> hashSet = new HashSet<>();
        for (int i = 0; i < productList.size() - 1; i++) {

            for (int j = 1; j < productList.size(); j++) {

                if (productList.get(i).calculateCost().compareTo(productList.get(j).calculateCost()) == ZERO)  {

                   hashSet.add(productList.get(i));
               }
           }
       }
       return new ArrayList<>(hashSet);
    }

    public ArrayList<Clothes> selectClothes() {

        ArrayList<Clothes> list = new ArrayList<>();

        for (Product product : productList) {

            if (product instanceof Clothes) {

                list.add((Clothes) product);
            }
        }
        return list;
    }

    public ArrayList<Boots> selectBoots() {

        ArrayList<Boots> list = new ArrayList<>();

        for (Product product : productList) {

            if (product instanceof Boots) {

                list.add((Boots) product);
            }
        }
        return list;
    }
}
