package JPABS03_LamLai.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhieuXuat_Request {
    String maPhieu;
    String tieuDe;
    LocalDate ngayNhap = LocalDate.now();
    List<ChiTietPhieuXuat_Request> chiTietPhieuXuats;
}
