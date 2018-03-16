package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.AdminMoto;
import kz.kaznitu.lessons.reposotories.AdminMotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/adminMoto")
public class AdminMotoController {
    @Autowired
    private AdminMotoRepository adminMotoRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("adminMoto",new AdminMoto());
        return "adminMoto_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("adminMotoo",new AdminMoto());
        return "adminMoto_update";
    }
    @PostMapping("/add")
    public String addAdminMoto(@ModelAttribute AdminMoto adminMoto){
        adminMotoRepository.save(adminMoto) ;

        return "redirect:/adminMoto/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<AdminMoto> allAdminMotos(){
        return adminMotoRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAdminMotos2(Model model){
        List<AdminMoto> adminMotos = (List<AdminMoto>) adminMotoRepository.findAll();
        model.addAttribute("adminMotos", adminMotos) ;
        return "adminMotos" ;
    }

    @PostMapping("/adds")
    public String addsAdminMoto(@ModelAttribute AdminMoto adminMoto){
        AdminMoto adminMoto1 = new AdminMoto();
        adminMoto1.setId(a);
        adminMoto1.setMotoName(adminMoto.getMotoName());
        adminMoto1.setYear(adminMoto.getYear());
        adminMoto1.setColor(adminMoto.getColor());
        adminMoto1.setSum(adminMoto.getSum());
        adminMoto1.setPrice(adminMoto.getPrice());
        adminMotoRepository.save(adminMoto1) ;

        return "redirect:/adminMoto/all" ;
    }

    @RequestMapping(value = "/adminMoto_update",method = RequestMethod.GET)
    public ModelAndView updateAdminMotos(Model model,@RequestParam("id") long id){
        a=id;
        Optional<AdminMoto> adminMoto= (Optional <AdminMoto> ) adminMotoRepository.findById(id);
        model.addAttribute("adminMotoo",adminMoto);
        return new ModelAndView("adminMoto_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        adminMotoRepository.deleteById(idd);
        return new ModelAndView("redirect:/adminMoto/all");
    }
}
