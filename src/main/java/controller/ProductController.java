package controller;

import jakarta.validation.Valid;
import model.Product;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.showProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create-product")
    public String showCreateProductForm(Product product) {
        return "create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-product";
        }

        productService.saveProduct(product);
        model.addAttribute("products", productService.showProducts());
        return "redirect:/products";
    }

    @GetMapping("/update-product/{productId}")
    public String showUpdateProductForm(@PathVariable("productId") int productId, Model model) {
        Product product = productService.showProductById(productId);
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/update-product/{productId}")
    public String updateProduct(@PathVariable("productId") int productId, @Valid Product product,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setProductId(productId);
            return "update-product";
        }

        productService.saveProduct(product);
        model.addAttribute("products", productService.showProducts());
        return "redirect:/products";
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@RequestParam("productId") Product productId, Model model) {
        productService.deleteProduct(productId);
        model.addAttribute("products", productService.showProducts());
        return "redirect:/products";
    }
}
