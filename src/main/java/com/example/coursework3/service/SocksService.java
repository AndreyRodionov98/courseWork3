package com.example.coursework3.service;

import com.example.coursework3.dto.SockShippingDto;
import com.example.coursework3.dto.SocksMapper;
import com.example.coursework3.model.Sock;
import com.example.coursework3.model.SocksSize;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SocksService {
private static Map<Sock,Integer>socksMap=new HashMap<>();


private final SocksMapper socksMapper;
public void addSocks(SockShippingDto socksShippingDto){
    Sock sock=socksMapper.toSocks(socksShippingDto);
    if (socksMap.containsKey(sock)){
        socksMap.put(sock,socksMap.get(sock)+socksShippingDto.getQuantity());
    }else {
      socksMap.put(sock,socksShippingDto.getQuantity());
    }
}
public void sellSocks(SockShippingDto socksShippingDto){
    decreaseSockQuantity(socksShippingDto);
}
public void removeDefectiveSocks(SockShippingDto socksShippingDto){
    decreaseSockQuantity(socksShippingDto);

}
private void decreaseSockQuantity(SockShippingDto socksShippingDto) throws EmptyStackException {
    Sock sock = socksMapper.toSocks(socksShippingDto);
    int sockQuantity=socksMap.getOrDefault(sock,0);
    if (sockQuantity>=socksShippingDto.getQuantity()){
        socksMap.put(sock,sockQuantity-socksShippingDto.getQuantity());
    }else{
        throw new EmptyStackException();
    }
}
public Integer getSockQuantity(Color color, SocksSize size, Integer cottonMin, Integer cottonMax){
    return socksMap.entrySet().stream()
            .filter(color!=null?s->color.equals(s.getKey().getColor()):s->true)
            .filter(size!=null?s->size.equals(s.getKey().getSize()):s->true)
            .filter(cottonMin!=null?s->cottonMin<=s.getKey().getCottonContent():s->true)
            .filter(cottonMax!=null?s->cottonMax>=s.getKey().getCottonContent():s->true)
            .mapToInt(s->s.getValue()).sum();
}


}
