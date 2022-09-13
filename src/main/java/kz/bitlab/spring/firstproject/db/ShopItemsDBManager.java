package kz.bitlab.spring.firstproject.db;

import kz.bitlab.spring.firstproject.models.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class ShopItemsDBManager {
    private static List<ProductItem> productItemList = new ArrayList<>();
    private static Long id = 7L;

    static {
        productItemList.add(new ProductItem(0L, "Lenovo V14 Athlon Gold 3150U", "Диагональ дисплея, дюйм14 Серия процессора: Athlon Gold Объем оперативной памяти, ГБ8", 500));
        productItemList.add(new ProductItem(1L, "Ноутбук NEO 15U i5 5257U", "Диагональ дисплея, дюйм15.6 Серия процессора Intel Core i5 Объем оперативной памяти, ГБ8", 800));
        productItemList.add(new ProductItem(2L, "Смартфон Samsung Galaxy A52 256GB Black", "Процессор:  Операционная система: Android 11 Объем встроенной памяти, 256Gb", 1050));
        productItemList.add(new ProductItem(3L, "APPLE IPHONE 13 PRO MAX 128GB SIERRA", "Процессор: AMD Ryzen 5 Операционная система: iOS Объем памяти: 128Gb", 2150));
        productItemList.add(new ProductItem(4L, "APPLE IPHONE 13 MINI 256GB (PRODUCT)RED", "Snapdragon 720G5 Операционная система: iOS Объем памяти: 128Gb", 1730));
        productItemList.add(new ProductItem(5L, "XIAOMI REDMI NOTE 10 PRO GLACIER BLUE", "Процессор: Snapdragon 720G Операционная система: iOS Объем памяти: 128Gb", 500));
        productItemList.add(new ProductItem(6L, "Смартфон Samsung Galaxy A52 256GB Black", "Процессор:  Операционная система: Android 11 Объем встроенной памяти, 256Gb", 1050));
        productItemList.add(new ProductItem(7L, "APPLE IPHONE 13 PRO MAX 128GB SIERRA", "Процессор: AMD Ryzen 5 Операционная система: iOS Объем памяти: 128Gb", 2150));
    }

    public static List<ProductItem> getAllProductItems() {
        List<ProductItem> allProductItems = new ArrayList<>();
        for (ProductItem productItem : productItemList) {
            allProductItems.add(productItem);
        }
        return allProductItems;
    }

    public static void addItem(ProductItem item) {
        item.setId(id++);
        productItemList.add(item);
    }
}
