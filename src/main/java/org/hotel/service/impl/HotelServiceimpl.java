package org.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.hotel.domain.Order;
import org.hotel.domain.Room;
import org.hotel.mapper.OrderMapper;
import org.hotel.mapper.RoomMapper;
import org.hotel.service.HotelService;
import org.hotel.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HotelServiceimpl implements HotelService {
    @Reference
    private RedisTemplate redisTemplate;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrderMapper orderMapper;

    public void orderHotel(UserInfo userInfo) {
        redisTemplate.opsForHash().put("user_"+userInfo.getName(),"name",userInfo.getName());
        redisTemplate.opsForHash().put("user_"+userInfo.getRoomNo(),"roomNo",userInfo.getRoomNo());
        redisTemplate.opsForHash().put("user_"+userInfo.getDate(),"date",userInfo.getDate());
    }

    public Map<Object, Object> getMessage(String name) {
        Map<Object, Object> map = redisTemplate.opsForHash().entries("hashValue");
        System.out.println(map);
        return map;
    }

    public List<Room> getRoom(String date) {
        QueryWrapper<Room> queryWrapper = new QueryWrapper<Room>();
        queryWrapper.eq("date",date).eq("enable",Boolean.TRUE);
        List<Room> roomList = roomMapper.selectList(queryWrapper);
        return roomList;
    }

    public List<Order> getOrder(String name) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<Order>();
        queryWrapper.eq("name",name).eq("order",Boolean.TRUE);
        List<Order> roomOrderList = orderMapper.selectList(queryWrapper);
        return roomOrderList;
    }
}
