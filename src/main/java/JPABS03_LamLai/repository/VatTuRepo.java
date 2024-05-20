package JPABS03_LamLai.repository;

import JPABS03_LamLai.entity.VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VatTuRepo extends JpaRepository<VatTu, Integer> {
    Optional<VatTu> findVatTuByTenVatTu(String tenVatTu);
}
