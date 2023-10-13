package com.thaleskevin.developer_test.repository;


import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

interface BaseRepository <T, ID extends Serializable>  {
    T findOne(ID id);
    T[] findAll();
}
