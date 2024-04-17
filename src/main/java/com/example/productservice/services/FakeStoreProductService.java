package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{


    @Override
    public Product getProductsById(Long id) {
//        int x = 1/0;
//        throw new RuntimeException();
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+ id, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null)
        {
            throw new ProductNotFoundException(id, "Please Pass a Valid Product ID!");
        }
        Product product = new Product();
        product = FakeStoreToProduct(fakeStoreProductDto);
        return product;
    }

    @Override
    public List<Product> getAllProducts()
    {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> Products = new ArrayList<Product>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos )
        {
            Product product = new Product();
            product = FakeStoreToProduct(fakeStoreProductDto);
            Products.add(product);

        }
        return Products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product FakeStoreToProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
