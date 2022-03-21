package org.hotel.controller;

import org.hotel.domain.Order;
import org.hotel.domain.Room;
import org.hotel.service.HotelService;
import org.hotel.vo.Result;
import org.hotel.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/orderHotel")
    public Result orderHotel(@RequestBody UserInfo userInfo){
        hotelService.orderHotel(userInfo);
        return new Result.Builder<>().setResult().buildOk();
    }

    @PostMapping("/getHotel")
    public Result getMessage(@PathVariable String name){
        Map<Object, Object> user = hotelService.getMessage(name);
        return new Result.Builder<>().setResult(user).buildOk();
    }

    /**
     * 通过一定日期查可用的房间
     * @param date
     * @return
     */
    @PostMapping("/getRoom")
    public Result getRoom(@PathVariable String date){
        List<Room> roomList = hotelService.getRoom(date);
        return new Result.Builder<>().setResult(roomList).buildOk();
    }

    /**
     * 查找特定客人的所有预订的方法
     * @param name
     * @return
     */
    @PostMapping("/getOrder")
    public Result getOrder(@PathVariable String name){
        List<Order> roomOrderList = hotelService.getOrder(name);
        return new Result.Builder<>().setResult(roomOrderList).buildOk();
    }


}
