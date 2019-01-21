package com.yiyi.farm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlbumRepository extends JpaRepository<Album,Long>, JpaSpecificationExecutor<Album> {
    Album findById(Long id);
}
