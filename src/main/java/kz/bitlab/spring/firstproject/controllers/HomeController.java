package kz.bitlab.spring.firstproject.controllers;

import kz.bitlab.spring.firstproject.db.DBManager;
import kz.bitlab.spring.firstproject.models.ProductItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String getIndex(Model model) {
        List<ProductItem> itemList = DBManager.getAllProductItems();
        model.addAttribute("itemList", itemList);
        return "index";
    }

    @GetMapping(value = "/add-new-item")
    public String getItemForm(Model model) {
        model.addAttribute("newItem", new ProductItem());
        return "newItem";
    }

//    @PostMapping(value = "/add-new-item")
//    public String addNewItem(@RequestParam (name = "itemName") String itemName,
//                             @RequestParam (name = "itemDescription") String itemDescription,
//                             @RequestParam (name = "itemPrice") double itemPrice) {
//        DBManager.addItem(new ProductItem(null, itemName, itemDescription, itemPrice));
//        return "redirect:/";
//    }
@PostMapping(value = "/add-new-item")
public String addNewItem(@ModelAttribute (name = "newItem") ProductItem newItem) {
    DBManager.addItem(newItem);
    return "redirect:/";
}
}
