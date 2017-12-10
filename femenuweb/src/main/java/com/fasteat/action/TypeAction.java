package com.fasteat.action;

import com.fasteat.menuservice.MenuService;
import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.Restaurant;
import com.fasteat.server.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TypeAction {
    @Autowired private MenuService menuService;

    @RequestMapping("/addType.html")
    public ModelAndView addType(Type type){
        try {
            if (type.getTname()==null || type.getTname().trim().equals("")){
                throw new RuntimeException();
            }
            menuService.addType(type);
            return new ModelAndView("/jsp/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/listType.html")
    public ModelAndView ListType(HttpSession session){
        Restaurant restaurant = (Restaurant)session.getAttribute("USER");
        int rid = restaurant.getRid();
        try {
            List<Type> list = menuService.getAllType(rid);
            return new  ModelAndView("/jsp/listType.jsp","typeList",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/go_addFood.html")
    public ModelAndView goAddFood(HttpSession session){
        Restaurant restaurant = (Restaurant)session.getAttribute("USER");
        int rid = restaurant.getRid();
        try {
            List<Type> list = menuService.getAllType(rid);
            Map<String,Object> map = new HashMap<>();
            map.put("typeList",list);
            return new  ModelAndView("/jsp/addFood.jsp","map",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/delType.html")
    public String delType(Integer tid){
        try {
            List<Food> list = menuService.getAllFoodByType(tid);
            for (Food food : list) {
                menuService.delFood(food.getFid());
            }
            menuService.delType(tid);
            return "redirect:/listType.html";
        } catch (Exception e) {
            e.printStackTrace();
            return "/jsp/fail.jsp";
        }
    }

    @RequestMapping("/go_updateType.html")
    public ModelAndView goUpdate(Integer tid){
        try {
            Type type = menuService.getTypeByID(tid);
            return new ModelAndView("/jsp/updateType.jsp","type",type);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/updateType.html")
    public ModelAndView updateType(Type type){
        try {
            if (type.getTname()==null || type.getTname().trim().equals("")){
                throw new RuntimeException();
            }
            menuService.updateType(type);
            return new ModelAndView("/jsp/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
}
}
