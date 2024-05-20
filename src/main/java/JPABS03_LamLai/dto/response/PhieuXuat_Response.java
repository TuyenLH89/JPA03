package JPABS03_LamLai.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhieuXuat_Response {
    int phieuXuatId;
    String maPhieu;
    String tieuDe;
    LocalDate ngayXuat;
    List<ChiTietPhieuXuat_Response> chiTietPhieuXuats;
}
