package JPABS03_LamLai.dto.response;

import JPABS03_LamLai.entity.ChiTietPhieuNhap;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
public class PhieuNhap_Response {
    int phieuNhapId;
    String maPhieu;
    String tieuDe;
    LocalDate ngayNhap;
    List<ChiTietPhieuNhap_Response> chiTietPhieuNhaps;
}
