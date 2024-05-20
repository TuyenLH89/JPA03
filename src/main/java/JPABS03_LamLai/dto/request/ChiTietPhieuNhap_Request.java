package JPABS03_LamLai.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietPhieuNhap_Request {
    int vatTuId;
    int soLuongNhap;
}
