package com.fasteat.action;

import com.fasteat.menuservice.MenuService;
import com.fasteat.menuservice.OrderDto2;
import com.fasteat.server.dao.RestaurantMapper;
import com.fasteat.server.pojo.Order;
import com.fasteat.server.pojo.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderAction {

    @Autowired private MenuService menuService;
    @Autowired private RestaurantMapper restaurantMapper;


    @RequestMapping("/listOrder.html")
    public ModelAndView getOrder(Integer ostatus, HttpSession session){
        Restaurant restaurant = (Restaurant)session.getAttribute("USER");
        int rid = restaurant.getRid();
        try {
            List<Order> orderList = menuService.getOrderByOstatus(ostatus,rid);
            return new ModelAndView("/jsp/listOrder.jsp","order",orderList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/orderDetails.html")
    public ModelAndView getOrderDetail(Integer oid){
        try {
            OrderDto2 orderDto2 = menuService.getOrderDetails(oid);
            return new ModelAndView("/jsp/orderDetails.jsp","order",orderDto2);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    //user操作
    @RequestMapping("/rest_index.html")
    public String goIndex(HttpSession session,Restaurant USER){
        session.setAttribute("USER",USER);
        return "/index.jsp";
    }

    //tomcat端口修改

    @RequestMapping("/rest_out.html")
    public String Userout(HttpSession session){
        session.removeAttribute("USER");
        return "redirect:rest_gologin.html";
    }

    @RequestMapping("/UserDetails.html")
    public ModelAndView getUserDetails(HttpSession session){
        try {
            Restaurant restaurant = (Restaurant)session.getAttribute("USER");
            return new ModelAndView("/jsp/UserDetail.jsp","User",restaurant);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }
}
