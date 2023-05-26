package com.cebem.rickandmorty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {

  

  @RequestMapping("/")
  public String client(Model modelo) {
    //CharactersModel charactersModel = rickAndMortyService2.getAllCharacters();
    
    //modelo.addAttribute("creator", "Creado por Angel");
    //modelo.addAttribute("characters", charactersModel.results);
    return "index";
  }

}