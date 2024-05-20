package JPABS03_LamLai.controller;

import JPABS03_LamLai.dto.request.PhieuXuat_Request;
import JPABS03_LamLai.dto.response.ApiResponse;
import JPABS03_LamLai.dto.response.PhieuXuat_Response;
import JPABS03_LamLai.service.PhieuXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phieuxuat")
public class PhieuXuatController {
    @Autowired
    PhieuXuatService phieuXuatService;
    @PostMapping("/addphieuxuat")
    ApiResponse<PhieuXuat_Response> addPhieuXuat(@RequestBody PhieuXuat_Request request) {
        ApiResponse<PhieuXuat_Response> apiResponse = new ApiResponse<>();
        apiResponse.setResult(phieuXuatService.addPhieuXuat(request));
        return apiResponse;
    }
}
