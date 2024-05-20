package JPABS03_LamLai.mapper;

import JPABS03_LamLai.dto.request.VatTu_Request;
import JPABS03_LamLai.dto.response.VatTu_Response;
import JPABS03_LamLai.entity.VatTu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VatTuMapper {
    VatTu toVatTu(VatTu_Request request);
    VatTu_Response toVatTuResponse(VatTu vatTu);
}
