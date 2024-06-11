package sg.edu.nus.goldlake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sg.edu.nus.goldlake.interfacemethods.ProductInterface;
import sg.edu.nus.goldlake.model.Product;
import sg.edu.nus.goldlake.service.ProductImplementation;
import jakarta.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private ProductInterface pservice;

    @Autowired
    public void setPservice(ProductImplementation pserviceImpl) {
        this.pservice = pserviceImpl;
    }

    @GetMapping("/")
    public String getSearchPage(Model model) {
        return "searchProduct";
    }

    @PostMapping(value = "/all/product/searching")
    public String search(@RequestParam("keyword") String k, @RequestParam("searchType") String t, Model model) {
        String name = "name";
        String category = "category";
        if(t.equals(name)){
            model.addAttribute("products", pservice.findProductByName(k));
        }else if(t.equals(category)){
            model.addAttribute("products", pservice.findProductByCategory(k));
        }
        else{
            return "error";
        }
        return "searchResults";
    }

    @RequestMapping(value = "/product/details/{id}")
    public String displayProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", pservice.findProductById(id));
        return "displayProduct";
    }

    @PostMapping(value = "/product/delete")
    public String deleteProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model) {
        pservice.deleteProduct(product);
        return "redirect:/";
    }

    @RequestMapping(value = "/product/edit/{id}")
    public String editProductForm(@PathVariable int id, Model model) {
        model.addAttribute("product", pservice.findProductById(id));
        return "editProduct";
    }

    @RequestMapping(value = "/product/save")
    public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "editProduct";
        }
        pservice.saveProduct(product);
        return "redirect:/";
    }
}
