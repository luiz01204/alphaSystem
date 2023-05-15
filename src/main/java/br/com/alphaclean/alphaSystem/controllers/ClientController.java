package br.com.alphaclean.alphaSystem.controllers;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import br.com.alphaclean.alphaSystem.Repository.ClientRepository;
import br.com.alphaclean.alphaSystem.dto.DataClient;
import br.com.alphaclean.alphaSystem.model.Client;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity<Void> register(@Valid DataClient data, UriComponentsBuilder uriBuilder){
        var client = new Client(data);
        repository.save(client);
        var uri = uriBuilder.path("client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List> consultAll(){
        List<Client> clients = repository.findAll();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> consultForId(@PathVariable Long id){
        var client = repository.getReferenceById(id);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping("delete/{id}")
    @Transactional
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Client> editData(@RequestBody @Valid DataClient data, @PathVariable Long id ){
        var client = repository.getReferenceById(id);
        client.editData(data);
        return ResponseEntity.ok().build();
    }
}
