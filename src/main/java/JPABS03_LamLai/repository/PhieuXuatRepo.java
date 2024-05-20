package JPABS03_LamLai.repository;

import JPABS03_LamLai.entity.PhieuXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuXuatRepo extends JpaRepository<PhieuXuat, Integer> {
}
