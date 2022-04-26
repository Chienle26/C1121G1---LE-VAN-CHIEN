package com.chienle.controller;

import com.chienle.dto.ContractDetailDto;
import com.chienle.dto.ContractDto;
import com.chienle.model.contract.Contract;
import com.chienle.model.contract.ContractDetail;
import com.chienle.service.IContractService;
import com.chienle.service.ICustomerService;
import com.chienle.service.IEmployeeService;
import com.chienle.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    IContractService iContractService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IServiceService iServiceService;

    @GetMapping({"", "/list"})
    public String goList(Model model) {
        model.addAttribute("contracts", iContractService.findAllContract());
        return "contract/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("contract", new ContractDto());
        model.addAttribute("customers", iCustomerService.findAll());
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("services", iServiceService.findAllService());
        return "contract/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ContractDto contractDto,BindingResult bindingResult ,RedirectAttributes redirectAttributes, Model model) {
       if (bindingResult.hasErrors()){
           model.addAttribute("customers", iCustomerService.findAll());
           model.addAttribute("employees", iEmployeeService.findAll());
           model.addAttribute("services", iServiceService.findAllService());
           return "contract/create";
       }

        Contract contract = new Contract();

        BeanUtils.copyProperties(contractDto, contract);

        contract.setCustomer(contractDto.getCustomer());
        contract.setEmployee(contractDto.getEmployee());
        contract.setService(contractDto.getService());

        iContractService.save(contract);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");

        return "redirect:/contract/list";
    }

    @GetMapping("/create-contract-detail")
    public String goCreateContractDetail(Model model){
        model.addAttribute("contractDetail", new ContractDetailDto());
        model.addAttribute("attachServices", iContractService.findAllAttachService());
        model.addAttribute("contracts", iContractService.findAllContract());
        return "contract/create-contract-detail";
    }

    @PostMapping("/create-contract-detail")
    public String saveContractDetail(@ModelAttribute ContractDetailDto contractDetailDto,
                                     RedirectAttributes redirectAttributes, Model model){

        ContractDetail contractDetail = new ContractDetail();

        BeanUtils.copyProperties(contractDetailDto, contractDetail);

        contractDetail.setContract(contractDetailDto.getContract());
        contractDetail.setAttachService(contractDetailDto.getAttachService());

        iContractService.save(contractDetail);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");

        return "redirect:/contract/list";
    }
}
