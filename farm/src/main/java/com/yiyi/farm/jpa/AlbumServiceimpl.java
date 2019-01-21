package com.yiyi.farm.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceimpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;



    @Cacheable(cacheNames = {"common2"}, key = "'xxx'+ #p0")
    @Override
    public Album findById(Long id){
        System.out.println("---> 看到我证明是查了数据库！！！");
        return albumRepository.findById(id);
    }



}
