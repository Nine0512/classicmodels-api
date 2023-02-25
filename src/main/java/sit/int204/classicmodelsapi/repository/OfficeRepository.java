package sit.int204.classicmodelsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsapi.entity.Office;

public interface OfficeRepository extends JpaRepository<Office,String> {
}
