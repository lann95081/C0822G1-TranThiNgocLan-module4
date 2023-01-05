package com.example.case_study.controller;

import com.example.case_study.model.contract.Contract;
import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.service.contract.IAttachFacilityService;
import com.example.case_study.service.contract.IContractDetailService;
import com.example.case_study.service.contract.IContractService;
import com.example.case_study.service.customer.ICustomerService;
import com.example.case_study.service.employee.IEmployeeService;
import com.example.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showListContract(@PageableDefault(value = 5) Pageable pageable, Model model) {

        model.addAttribute("contractList", iContractService.findAllDto(pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("contractDetailList", iContractDetailService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());

        return "contract/list";
    }

    @PostMapping("/add")
    public String saveContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng thành công!");

        return "redirect:/contract";
    }

    @PostMapping("/add-contract-detail")
    public String saveDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công!");

        return "redirect:/contract";
    }

    @GetMapping("/{id}")
    public String showAttachFacility(@PathVariable Integer id, Model model) {
        model.addAttribute("contractDetails", iContractDetailService.showAll(id));

        return "contract/attachFacilityList";
    }
}
