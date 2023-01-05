package com.example.case_study.controller;

import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.employee.Employee;
import com.example.case_study.service.employee.IDivisionService;
import com.example.case_study.service.employee.IEducationDegreeService;
import com.example.case_study.service.employee.IEmployeeService;
import com.example.case_study.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                           Model model) {

        model.addAttribute("employeeList", iEmployeeService.searchEmployee(nameSearch, addressSearch,
                phoneSearch, pageable));
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("employeeDto", new EmployeeDto());

        return "employee/list";
    }

    @GetMapping("/create")
    public String createEmp(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());

        return "employee/create";
    }

    @PostMapping("/add")
    public String saveEmp(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
            model.addAttribute("positionList", iPositionService.findAll());


            return "employee/create";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Thêm mới nhân viên thành công!");

        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editEmp(@PathVariable Integer id, Model model) {
        Employee employee = iEmployeeService.findById(id).get();

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());

        return "employee/edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
            model.addAttribute("positionList", iPositionService.findAll());

            return "employee/edit";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa nhân viên thành công!");

        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String deleteEmp(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iEmployeeService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("message", "Xóa nhân viên  [" +
                iEmployeeService.findById(id).get().getEmployeeName() + "]  thành công.");

        return "redirect:/employee";
    }
}
