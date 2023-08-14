package newtest.domain;

import java.util.Date;
import java.util.List;
import newtest.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository
    extends PagingAndSortingRepository<Product, Long> {
    @Query(
        value = "select product " +
        "from Product product " +
        "where(:name is null or product.name like %:name%)"
    )
    List<Product> findByProductQuery(String name, Pageable pageable);
}
