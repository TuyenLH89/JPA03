package JPABS03_LamLai.mapper;

import JPABS03_LamLai.dto.request.PhieuNhap_Request;
import JPABS03_LamLai.dto.request.PhieuXuat_Request;
import JPABS03_LamLai.dto.response.PhieuXuat_Response;
import JPABS03_LamLai.entity.PhieuXuat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuXuatMapper {
    PhieuXuat toPhieuXuat(PhieuXuat_Request request);
    PhieuXuat_Response toPhieuXuatResponse(PhieuXuat phieuXuat);
}
