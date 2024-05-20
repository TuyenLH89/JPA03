package JPABS03_LamLai.dto.request;

import jakarta.persistence.UniqueConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhieuNhap_Request {
    String maPhieu;
    String tieuDe;
    LocalDate ngayNhap = LocalDate.now();
    List<ChiTietPhieuNhap_Request> chiTietPhieuNhaps;
}
