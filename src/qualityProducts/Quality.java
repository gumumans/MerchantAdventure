package qualityProducts;

import entity.Product;
import exceptions.SellerException;

public interface Quality {
    void decreaseQuality(Product product);
}
