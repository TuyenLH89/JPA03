package JPABS03_LamLai.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VatTu_Request {
    String tenVatTu;
    int soLuongTon = 0;
}
