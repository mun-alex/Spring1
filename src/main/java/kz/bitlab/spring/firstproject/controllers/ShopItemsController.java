package kz.bitlab.spring.firstproject.controllers;

import kz.bitlab.spring.firstproject.db.ShopItemsDBManager;
import kz.bitlab.spring.firstproject.models.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShopItemsController {

    @Autowired
    private ProductItem productItem;

    @GetMapping(value = "/shop")
    public String getIndex(Model model) {
        List<ProductItem> itemList = ShopItemsDBManager.getAllProductItems();
        model.addAttribute("itemList", itemList);
        return "shop";
    }

    @GetMapping(value = "/shop/add-new-item")
    public String getItemForm(Model model) {
        model.addAttribute("newItem", productItem);
        return "newItem";
    }

    //    @PostMapping(value = "/add-new-item")
//    public String addNewItem(@RequestParam (name = "itemName") String itemName,
//                             @RequestParam (name = "itemDescription") String itemDescription,
//                             @RequestParam (name = "itemPrice") double itemPrice) {
//        DBManager.addItem(new ProductItem(null, itemName, itemDescription, itemPrice));
//        return "redirect:/";
//    }
    @PostMapping(value = "/shop/add-new-item")
    public String addNewItem(@ModelAttribute(name = "newItem") ProductItem newItem) {
        ShopItemsDBManager.addItem(newItem);
        return "redirect:/";
    }
}
