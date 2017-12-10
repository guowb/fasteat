package com.fasteat.action;

import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.Item;
import com.fasteat.server.pojo.Order;
import com.fasteat.service.FoodService;
import com.fasteat.service.ItemService;
import com.fasteat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodAction {
    @Autowired
    private FoodService foodService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;

    @RequestMapping("/food")
    @ResponseBody
    public Map<String , Object> getFoods(Integer tid){
        Map<String, Object> map = new HashMap<>();
        List<Food> foods = foodService.selectFoodByTid(tid);
        map.put("foods", foods);
        return map;
    }
    @RequestMapping("/item")
    @ResponseBody
    public Map<String,Object> addItem(Integer fid,Long phone,Integer fnum ){
        Map<String,Object> map=new HashMap<>();
        //通过 unique查找到订单,创建订单项,并把订单项放入订单中
        Food food = foodService.selectFoodByFid(fid);
        Item item=new Item();
        item.setFid(fid);
        item.setFnum(fnum);
        item.setPrice(food.getFprice()*item.getFnum());
        Order order = orderService.selectOrderByPhone(phone);
        item.setOid(order.getId());
        //将food添加到订单项中
        item.setFood(food);
        itemService.addNewItem(item);
        return map;
    }
    @RequestMapping("/order")
    public ModelAndView findOrder(Long phone){
        ModelAndView view =new ModelAndView();
        //把订单查询出来 并把相关的订单项放入进去
        Order order = orderService.selectOrderByPhone(phone);
        //订单的价格放到Order中
        Double price=0d;
        List<Item> items = itemService.selectItemfromOId(order.getId());
        for (Item item : items) {
            price+=item.getPrice();
           Food food = foodService.selectFoodByFid(item.getFid());
           item.setFood(food);
        }
        order.setPrice(price);
        order.setItems(items);
        view.addObject("order",order);
        view.setViewName("order");
        return view;

    }


}
