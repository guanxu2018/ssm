package cn.itcast.service;

import cn.itcast.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
}
