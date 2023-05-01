package controller;

import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String showAllOrders(Model model) {
        List<Order> orders = orderService.showOrders();
        model.addAttribute("orders", orders);
        return "orders/index";
    }

    @GetMapping("/{orderId}")
    public String showOrderDetails(@PathVariable int orderId, Model model) {
        Order order = orderService.showOrderById(orderId);
        model.addAttribute("order", order);
        return "orders/details";
    }

    @GetMapping("/new")
    public String showNewOrderForm(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "orders/new";
    }

    @PostMapping("")
    public String saveOrder(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/edit")
    public String showEditOrderForm(@PathVariable int orderId, Model model) {
        Order order = orderService.showOrderById(orderId);
        model.addAttribute("order", order);
        return "orders/edit";
    }

    @PostMapping("/{orderId}")
    public String updateOrder(@PathVariable int orderId, @ModelAttribute("order") Order order) {
        order.setOrderId(orderId);
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/delete")
    public String showDeleteOrderForm(@PathVariable int orderId, Model model) {
        Order order = orderService.showOrderById(orderId);
        model.addAttribute("order", order);
        return "orders/delete";
    }

    @PostMapping("/{orderId}/delete")
    public String deleteOrder(@PathVariable Order orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/orders";
    }
}
