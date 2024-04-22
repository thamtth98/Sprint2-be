package com.example.cosmetics.repository;

import com.example.cosmetics.dto.CosmeticsDto;
import com.example.cosmetics.dto.ProductDto;
import com.example.cosmetics.dto.RequestDto;
import com.example.cosmetics.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Integer> {

//    @Query(value = " select p.id as id, p.name as name, p.description as description," +
//            " p.expiry as expiry, p.quantity as quantity, p.price as price, p.producer as producer," +
//            " p.type as type, p.discount as discount, p.cosmeticsSizeList as cosmeticsSizeList," +
//            " p.isDelete as delete" +
//            " from Product p" +
//            " join Producer pc on p.producer.id = pc.id" +
//
//            " join CosmeticsSize cs on cs.product.id = p.id" +
//            " join Size s on s.id = cs.size.id" +
//            " where (pc.id = :#{#requestDto.idProducer} or :#{#requestDto.idProducer}=-1)" +
//            " and (p.type.id = :#{#requestDto.idSize} or :#{#requestDto.idSize} = -1)" +
//            " and (s.id = :#{#requestDto.idSize} or :#{#requestDto.idSize} = -1)" +
//            " and p.isDelete = false")
//    Page<ProductDto> findAllPage(@Param("requestDto") RequestDto requestDto, Pageable pageable);


    @Query(value = " select cs.id as id, cs as cosmeticsSize, s as size, p as product" +
            " from Product p" +
            " join Producer pc on p.producer.id = pc.id" +
            " join CosmeticsSize cs on cs.product.id = p.id" +
            " join Size s on s.id = cs.size.id" +
            " where (p.name like concat('%', :#{#requestDto.nameSearch} , '%') " +
            " or p.producer.name like concat('%', :#{#requestDto.nameSearch} , '%'))" +
            " and (cs.product.producer.id = :#{#requestDto.idProducer} or :#{#requestDto.idProducer}=-1)" +
            " and (cs.typeDetail.id = :#{#requestDto.idType} or :#{#requestDto.idType} = -1)" +
            " and (s.id = :#{#requestDto.idSize} or :#{#requestDto.idSize} = -1)" +
            " and p.isDelete = false")
    Page<CosmeticsDto> getAllPage(@Param("requestDto") RequestDto requestDto, Pageable pageable);

    @Query(value = " select cs.id as id, cs as cosmeticsSize, s as size, p as product" +
            " from Product p" +
            " join Producer pc on p.producer.id = pc.id" +
            " join CosmeticsSize cs on cs.product.id = p.id" +
            " join Size s on s.id = cs.size.id" +
            " where cs.id = :#{#idProduct}"+
            " and p.isDelete = false")
    CosmeticsDto findByIdProduct(@Param("idProduct") int idProduct);
}
