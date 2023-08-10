package newtest.infra;

import java.util.List;
import newtest.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "productionByMonths",
    path = "productionByMonths"
)
public interface ProductionByMonthRepository
    extends PagingAndSortingRepository<ProductionByMonth, Long> {}
