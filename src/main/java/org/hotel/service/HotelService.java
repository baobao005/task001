package org.hotel.service;

import org.hotel.domain.Order;
import org.hotel.domain.Room;
import org.hotel.vo.UserInfo;

import java.util.List;
import java.util.Map;

public interface HotelService {
    void orderHotel(UserInfo userInfo);

    Map<Object, Object> getMessage(String name);

    List<Room> getRoom(String date);

    List<Order> getOrder(String name);
}
