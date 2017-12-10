package com.fasteat.action;

import com.fasteat.dto.ITDto;
import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.Order;
import com.fasteat.service.FoodService;
import com.fasteat.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/order")
public class OrderAction {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FoodService foodService;

    @RequestMapping("/orderpage")
    public ModelAndView page(@RequestParam(defaultValue = "1") Integer pageIndex)
    {
        PageInfo<Order> pageInfo=orderService.selectByPage(pageIndex);
        return new ModelAndView("orders","list",pageInfo);
    }

    @RequestMapping("/info")
    private ModelAndView selectItem(@RequestParam Integer id)
    {
        ModelAndView modelAndView=new ModelAndView();
        Order order=orderService.selectItemfromOId(id);
        List<Food> foods=foodService.selectAll();
        modelAndView.addObject("order",order);
        modelAndView.addObject("foods",foods);
        modelAndView.setViewName("orderinfo");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(@RequestParam Integer id){

        orderService.updateByOstatus(id);
        return "redirect:/order/orderpage";
    }

    @RequestMapping("/datagrid_data1.json")
    @ResponseBody
    public ITDto itemList(Integer page, Integer rows){
        ITDto itDto=orderService.findOrderList(page, rows);
        return itDto;
    }




}
