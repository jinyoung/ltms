package newtest.domain;

import java.util.Date;
import java.util.List;
import newtest.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository
    extends PagingAndSortingRepository<Product, Long> {
    @Query(
        value = "select product " +
        "from Product product " +
        "where(:name is null or product.name like %:name%) and (:industry is null or product.industry like %:industry%) and (:foundedDate is null or product.foundedDate like %:foundedDate%)"
    )
    List<Product> Query(
        String name,
        String industry,
        Date foundedDate,
        Pageable pageable
    );
}
