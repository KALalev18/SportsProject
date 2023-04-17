package controller;

import dto.AdminDto;
import dto.UserDto;
import jakarta.validation.Valid;
import model.Product;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.ProductRepository;
import repository.UserRepository;
import service.UserService;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products/index";
    }

    @GetMapping("/products/{productId}")
    public String get(@PathVariable int productId, Model model) {

        productRepository.findById(productId).ifPresent(item -> model.addAttribute("item", item));
        return "products/details";
    }

    @GetMapping("/products/add")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "products/add";
    }

    @GetMapping("/products/edit/{productId}")
    public String edit(@PathVariable int productId, Model model)
    {
        model.addAttribute("productId", productRepository.findById(productId));
        return "products/edit";
    }

    @RequestMapping(value = "/products/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("item", product);
        productRepository.save(product);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/products/delete/{productId}")
    public ModelAndView delete(@PathVariable int productId, Model model) throws ChangeSetPersister.NotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        productRepository.delete(product);
        return new ModelAndView("redirect:/products");
    }
}
