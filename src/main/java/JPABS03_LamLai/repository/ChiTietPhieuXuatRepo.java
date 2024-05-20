package JPABS03_LamLai.repository;

import JPABS03_LamLai.entity.ChiTietPhieuXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuXuatRepo extends JpaRepository<ChiTietPhieuXuat, Integer> {
}
