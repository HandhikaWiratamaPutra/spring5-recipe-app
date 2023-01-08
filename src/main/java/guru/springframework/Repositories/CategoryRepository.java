package guru.springframework.Repositories;

import guru.springframework.domain.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);

    @Query(value = "select * from Category where description like :description ", nativeQuery = true)
    Set<Category> findByDescriptionStartedWithA(@Param("description") String description);
}
