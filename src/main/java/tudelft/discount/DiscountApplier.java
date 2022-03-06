package tudelft.discount;

public class DiscountApplier {

    private ProductDao dao;

    public DiscountApplier (ProductDao dao) {
        this.dao = dao;
    }

    public void setNewPrices() {

        for(Product product : dao.all()) {
            if(product.getCategory().equals("BUSINESS")) {
                /*Bug was founded - it was * 0.9*/
                product.setPrice(product.getPrice() * 1.1);
            }
            if(product.getCategory().equals("HOME")) {
                /*Bug was founded - it was * 1.1*/
                product.setPrice(product.getPrice() * 0.9);
            }
        }

    }
}
