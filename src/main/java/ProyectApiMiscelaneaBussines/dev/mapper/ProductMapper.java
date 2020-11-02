package ProyectApiMiscelaneaBussines.dev.mapper;

import ProyectApiMiscelaneaBussines.dev.dto.ProductDto;
import ProyectApiMiscelaneaBussines.dev.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productId", target = "idProduct"),
            @Mapping(source = "productPrice", target = "priceProduct"),
            @Mapping(source = "dateCreated", target = "createdDate"),
            @Mapping(source = "dateModified", target = "modifiedDate")
    })
    Product toProduct(ProductDto productDto);
    List<Product> toProducts(List<ProductDto> productos);

    @InheritInverseConfiguration
    ProductDto toProductDto(Product product);
    List<ProductDto> toProductDtos(List<Product> products);
}
