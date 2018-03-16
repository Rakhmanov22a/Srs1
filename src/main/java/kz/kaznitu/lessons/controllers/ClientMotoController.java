package kz.kaznitu.lessons.controllers;


import kz.kaznitu.lessons.models.ClientMoto;
import kz.kaznitu.lessons.reposotories.ClientMotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/clientMoto")
public class ClientMotoController {
    @Autowired
    private ClientMotoRepository clientMotoRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("clientMoto",new ClientMoto());
        return "clientMoto_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model) {
        model.addAttribute("clientmotoo", new ClientMoto());
        return "clientMoto_update";
    }
    @PostMapping("/add")
    public String addClientMoto(@ModelAttribute ClientMoto clientMoto){
        clientMotoRepository.save(clientMoto) ;
        return "redirect:/clientMoto/all" ;
    }

    @GetMapping("/all2")
    public @ResponseBody Iterable<ClientMoto> allClientMoto(){
        return clientMotoRepository.findAll() ;
    }


    @GetMapping("/all")
    public String allClientMotos(Model model){
        List<ClientMoto> clientMotos= (List<ClientMoto>) clientMotoRepository.findAll();
        model.addAttribute("clientMotos", clientMotos) ;
        return "clientMotos" ;
    }

    @PostMapping("/adds")
    public String addsClientmoto(@ModelAttribute ClientMoto clientMoto){
        ClientMoto clientMoto1 = new ClientMoto();
        clientMoto1.setId(a);
        clientMoto1.setNameMoto(clientMoto.getNameMoto());
        clientMoto1.setGod(clientMoto.getGod());
        clientMoto1.setCena(clientMoto.getCena());
        clientMotoRepository.save(clientMoto1) ;
        return "redirect:/clientMoto/all" ;
    }
    @RequestMapping(value = "/clientMoto_update",method = RequestMethod.GET)
    public ModelAndView updatePublishers(Model model,@RequestParam("id") long id){
        a=id;
        Optional<ClientMoto> clientMoto = (Optional <ClientMoto> ) clientMotoRepository.findById(id);
        model.addAttribute("clientMotoo",clientMoto);
        return new ModelAndView("clientMoto_update");
    }



    @RequestMapping(value = "/deleteClientMoto", method = RequestMethod.GET)
    public ModelAndView deleteContact (@RequestParam("id")long idd){
        clientMotoRepository.deleteById(idd);
        return new ModelAndView("redirect:/clientMoto/all");
    }
}
