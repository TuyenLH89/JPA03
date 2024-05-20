package JPABS03_LamLai.controller;

import JPABS03_LamLai.dto.request.VatTu_Request;
import JPABS03_LamLai.dto.response.ApiResponse;
import JPABS03_LamLai.dto.response.VatTu_Response;
import JPABS03_LamLai.service.VatTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vattu")
public class VatTuController {
    @Autowired
    VatTuService vatTuService;

    @PostMapping("/addvattu")
    ApiResponse<VatTu_Response> addVatTu(@RequestBody VatTu_Request request){
        ApiResponse<VatTu_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(vatTuService.addVatTu(request));
        return apiResponse;
    }
    @GetMapping("/getallvattu")
    ApiResponse<List<String>> getAllVatTu(){
        ApiResponse<List<String>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(vatTuService.getAllVatTu());
        return apiResponse;
    }
    @GetMapping("/getallvattuhethang")
    ApiResponse<List<String>> getAllVatTuHetHang(){
        ApiResponse<List<String>> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("Danh Sách Vật Tư Cần Nhập");
        apiResponse.setResult(vatTuService.getAllVatTuHetHang());
        return apiResponse;
    }
}
