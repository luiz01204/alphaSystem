package br.com.alphaclean.alphaSystem.controllers;

import br.com.alphaclean.alphaSystem.Repository.ClientRepository;
import br.com.alphaclean.alphaSystem.dto.DataClient;
import br.com.alphaclean.alphaSystem.model.Client;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientRepository repository;

    @GetMapping("register")
    public ModelAndView formRegister(DataClient dataClient){
        ModelAndView mv = new ModelAndView("client/register");
        return mv;
    }

    @PostMapping("newClient")
    public ModelAndView register(@Valid DataClient data, BindingResult result){
        if (result.hasErrors()){
            ModelAndView mv = new ModelAndView("redirect:/client/register");
            return mv;
        }

        ModelAndView mv = new ModelAndView("redirect:/client/consultAll");
        repository.save(new Client(data));
        return mv;
    }

    @GetMapping("consultAll")
    public ModelAndView consultAll(Model model){
        List<Client> clients = repository.findAll();
        model.addAttribute("client", clients);
        ModelAndView mv = new ModelAndView("client/consultAll");
        return mv;
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteClient(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("redirect:/client/consultAll");
        repository.deleteById(id);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id, Model model){
        var client = repository.getReferenceById(id);
        model.addAttribute("client", client);

        ModelAndView mv = new ModelAndView("client/edit");
        return mv;
    }

    @PostMapping("save/{id}")
    public ModelAndView saveEdit(@PathVariable Long id, @Valid DataClient data){
        var client = repository.getReferenceById(id);
        client.editData(data);
        repository.save(client);

        ModelAndView mv = new ModelAndView("redirect:/client/consultAll");
        return mv;

    }
}
