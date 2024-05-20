package JPABS03_LamLai.repository;

import JPABS03_LamLai.entity.ChiTietPhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuNhapRepo extends JpaRepository<ChiTietPhieuNhap, Integer> {
}
