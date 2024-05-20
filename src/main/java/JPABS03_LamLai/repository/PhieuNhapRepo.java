package JPABS03_LamLai.repository;

import JPABS03_LamLai.entity.PhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuNhapRepo extends JpaRepository<PhieuNhap, Integer> {
}
