package com.yiyi.farm.jpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumServiceimplTest {

    @Autowired
    AlbumService albumService;
    @Test
    public void findById() {
        Album byId = albumService.findById(11L);
        System.out.println("--15--> "+byId);
    }





}