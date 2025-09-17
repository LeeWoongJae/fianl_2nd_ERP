package com.yedam.erp.web.voucher;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.erp.service.VoucherService;
import com.yedam.erp.vo.VoucherVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class VoucherController {

    private final VoucherService service;

    // ----------- View (Thymeleaf) -----------
    @GetMapping("/vouchers")
    public String listPage(Model model) {
        // 초기 렌더만 하고, 데이터는 axios로 불러옴
        return "vouchers/list";
    }

    // ----------- API (JSON) -----------
    @ResponseBody
    @GetMapping("/api/v1/vouchers")
    public List<VoucherVO> list(@RequestParam(required = false) String type,
                                @RequestParam(required = false) String status,
                                @RequestParam(required = false) String keyword) {
        return service.list(type, status, keyword);
    }

    @ResponseBody
    @GetMapping("/api/v1/vouchers/{id}")
    public VoucherVO get(@PathVariable Long id) {
        return service.get(id);
    }

    @ResponseBody
    @PostMapping("/api/v1/vouchers")
    public Long create(@RequestBody VoucherVO vo) {
        return service.create(vo);
    }

    @ResponseBody
    @PutMapping("/api/v1/vouchers/{id}")
    public void update(@PathVariable Long id, @RequestBody VoucherVO vo) {
        service.update(id, vo);
    }

    @ResponseBody
    @DeleteMapping("/api/v1/vouchers/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}