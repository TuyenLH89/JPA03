package JPABS03_LamLai.service;

import JPABS03_LamLai.dto.request.VatTu_Request;
import JPABS03_LamLai.dto.response.VatTu_Response;
import JPABS03_LamLai.entity.VatTu;
import JPABS03_LamLai.exception.AppException;
import JPABS03_LamLai.exception.ErrorCode;
import JPABS03_LamLai.mapper.VatTuMapper;
import JPABS03_LamLai.repository.VatTuRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class VatTuService {
    VatTuRepo vatTuRepo;
    VatTuMapper vatTuMapper;
    public VatTu_Response addVatTu(VatTu_Request request){
        if (vatTuRepo.findVatTuByTenVatTu(request.getTenVatTu()).isPresent())
            throw new AppException(ErrorCode.VATTU_EXISTED);
        VatTu vatTu = vatTuMapper.toVatTu(request);
        return vatTuMapper.toVatTuResponse(vatTuRepo.save(vatTu));
    }
    public List<String> getAllVatTu(){
        List<String> list = new ArrayList<>();
        for (VatTu vt : vatTuRepo.findAll()){
            if (vt.getSoLuongTon() > 0){
                String value = "["+vt.getTenVatTu()+"]"+" - SLTK: "+"["+vt.getSoLuongTon()+"]";
                list.add(value);
            }else{
                String value = "["+vt.getTenVatTu()+"]"+" - SLTK: "+"[Hết Hàng]";
                list.add(value);
            }
        }
        return list;
    }
    public List<String> getAllVatTuHetHang(){
        List<String> list = new ArrayList<>();
        for (VatTu vt : vatTuRepo.findAll()){
            if (vt.getSoLuongTon() <= 0){
                String value = vt.getTenVatTu();
                list.add(value);
            }
        }
        return list;
    }
}
