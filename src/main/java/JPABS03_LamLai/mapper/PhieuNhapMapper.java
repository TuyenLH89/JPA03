package JPABS03_LamLai.mapper;

import JPABS03_LamLai.dto.request.PhieuNhap_Request;
import JPABS03_LamLai.dto.response.PhieuNhap_Response;
import JPABS03_LamLai.entity.PhieuNhap;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuNhapMapper {
    PhieuNhap toPhieuNhap(PhieuNhap_Request request);
    PhieuNhap_Response toPhieuNhapResponse(PhieuNhap phieuNhap);
}
