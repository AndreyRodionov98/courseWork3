package com.example.coursework3.dto;

import com.example.coursework3.model.Sock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface SocksMapper {
Sock toSocks(SockShippingDto sockShippingDto);
@Mapping(target ="quantity",ignore=true)
SockShippingDto toSocksDto(Sock sock);

    default List<SockShippingDto> fromMapOfSocks(Map<Sock, Integer> socks) {
        List<SockShippingDto>sockList=new ArrayList<>();
        socks.forEach((k,v)->{
            SockShippingDto sockShippingDto=toSocksDto(k);
            sockShippingDto.setQuantity(v);
            sockList.add(sockShippingDto);
        });
    return sockList;
    }
    default Map<Sock,Integer>fromListOfSocksDto(List<SockShippingDto>socksDtos){
        Map<Sock,Integer>socksMap=new HashMap<>();
        socksDtos.forEach(s->{
            Sock sock=toSocks(s);
            socksMap.put(sock,s.getQuantity());
        });
        return socksMap;

    }

}
