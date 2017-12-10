package com.fasteat.action;

import com.fasteat.dto.FoodDto;
import com.fasteat.menuservice.MenuService;
import com.fasteat.server.pojo.Food;
import com.fasteat.server.pojo.Restaurant;
import com.fasteat.server.pojo.Type;
import com.fasteat.server.util.FastDFSClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodAction {
    @Autowired private MenuService menuService;

    @RequestMapping("/addFood.html")
    public ModelAndView addFood(Food food){
        try {
            menuService.addFood(food);
            return new ModelAndView("/jsp/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/PhotoUpload.html")
    public ModelAndView uplodaPhoto(@RequestParam("photo")MultipartFile photo, @RequestParam(required = false)Integer fid,HttpSession session){
        String path = null;
        Map<String,Object> map = new HashMap<>();
        Restaurant restaurant = (Restaurant)session.getAttribute("USER");
        int rid = restaurant.getRid();
        try {
            List<Type> list = menuService.getAllType(rid);
            map.put("typeList",list);
            FastDFSClient fastDFSClient = new FastDFSClient();
            String[] phopath = fastDFSClient.uploadFile(photo.getBytes(),photo.getName());
            path="http://120.78.184.134:88/"+phopath[0]+"/"+phopath[1];
            if (fid!=null){
                FoodDto foodDto = new FoodDto();
                Food food = menuService.getFoodByID(fid);
                BeanUtils.copyProperties(food,foodDto);
                Type type = menuService.getTypeByID(food.getTid());
                foodDto.setType(type);
                foodDto.setFphoto(path);
                map.put("food",foodDto);
                return new ModelAndView("/jsp/updateFood.jsp","map",map);
            }
            map.put("photo",path);
           return new ModelAndView("/jsp/addFood.jsp","map",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/listFood.html")
    public ModelAndView getAllFood(HttpSession session){
        List<FoodDto> foodDtoList = new ArrayList<>();
        Restaurant restaurant = (Restaurant)session.getAttribute("USER");
        int rid = restaurant.getRid();
        try {
            List<Food> foodList = menuService.getAllFood(rid);
            for (Food food : foodList) {
                FoodDto foodDto = new FoodDto();
                BeanUtils.copyProperties(food,foodDto);
                Type type = menuService.getTypeByID(food.getTid());
                foodDto.setType(type);
                foodDto.setRid(rid);
                foodDtoList.add(foodDto);
            }
            return new ModelAndView("/jsp/listFood.jsp","foodDtoList",foodDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/go_updateFood.html")
    public ModelAndView go_updateFood(Integer fid,HttpSession session){
        Map<String,Object> map = new HashMap<>();
        Restaurant restaurant = (Restaurant)session.getAttribute("USER");
        int rid = restaurant.getRid();
        try {
            List<Type> list = menuService.getAllType(rid);
            map.put("typeList",list);
            FoodDto foodDto = new FoodDto();
            Food food = menuService.getFoodByID(fid);
            BeanUtils.copyProperties(food,foodDto);
            Type type = menuService.getTypeByID(food.getTid());
            foodDto.setType(type);
            map.put("food",foodDto);
            return new ModelAndView("/jsp/updateFood.jsp","map",map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/updateFood.html")
    public ModelAndView updateFood(Food food){
        try {
            menuService.updateFood(food);
            return new ModelAndView("/jsp/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/delFood.html")
    public ModelAndView delFood(Integer fid){
        try {
            menuService.delFood(fid);
            return new ModelAndView("/jsp/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/updateFnum.html")
    public ModelAndView updateFnum(Integer fid){
        try {
            Food food = menuService.getFoodByID(fid);
            int status = food.getFnum();
            if (status==1){
                food.setFnum(0);
                menuService.updateFood(food);
                return new ModelAndView("/jsp/success.jsp");
            }else {
                food.setFnum(1);
                menuService.updateFood(food);
                return new ModelAndView("/jsp/success.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }

    @RequestMapping("/Fooddetails.html")
    public ModelAndView getFoodDetails(Integer fid){
        try {
            FoodDto foodDto = new FoodDto();
            Food food = menuService.getFoodByID(fid);
            BeanUtils.copyProperties(food,foodDto);
            Type type = menuService.getTypeByID(food.getTid());
            foodDto.setType(type);
            return new ModelAndView("/jsp/FoodDetails.jsp","food",foodDto);
        } catch (BeansException e) {
            e.printStackTrace();
            return new ModelAndView("/jsp/fail.jsp");
        }
    }
}
