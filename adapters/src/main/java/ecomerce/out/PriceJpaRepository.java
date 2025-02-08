package ecomerce.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.Optional;


public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {


    @Query(value = "SELECT * FROM PRICES p " +
            "WHERE p.BRAND_ID = :brandId " +
            "AND p.START_DATE  <= :startDate " +
            "AND p.END_DATE >= :startDate " +
            "AND p.PRODUCT_ID = :productId " +
            "ORDER BY p.PRIORITY DESC" +
            " LIMIT 1", nativeQuery = true)
    Optional<PriceEntity> findByFilter(@Param("brandId") Long brandId,
                                       @Param("startDate") OffsetDateTime startDate,
                                       @Param("productId") Long productId);
}
