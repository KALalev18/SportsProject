package controller;

import model.Order;
import model.Product;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.OrderRepository;
import repository.ProductRepository;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String index(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders/index";
    }

    @GetMapping("/orders/{orderId}")
    public String get(@PathVariable int orderId, Model model) {

        orderRepository.findById(orderId).ifPresent(item -> model.addAttribute("item", item));
        return "orders/details";
    }

    @GetMapping("/orders/add")
    public String add(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "orders/add";
    }

    @GetMapping("/products/edit/{orderId}")
    public String edit(@PathVariable int orderId, Model model)
    {
        model.addAttribute("orderId", orderRepository.findById(orderId));
        return "orders/edit";
    }

    @RequestMapping(value = "/orders/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("order") Order order, Model model) {
        model.addAttribute("item", order);
        orderRepository.save(order);
        return new ModelAndView("redirect:/orders");
    }

    @GetMapping("/products/delete/{orderId}")
    public ModelAndView delete(@PathVariable int orderId, Model model) throws ChangeSetPersister.NotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        orderRepository.delete(order);
        return new ModelAndView("redirect:/products");
    }
}
