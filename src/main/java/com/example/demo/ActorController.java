package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ActorController {
	  @GetMapping("/actor")
	  public String ActorForm(Model model) {
	    model.addAttribute("actor", new Actor());
	    DataBase DB = new DataBase();
	    DB.setDataBase();
	    model.addAttribute("dataBase",DB);
	    return "index";
	  }

	  @PostMapping("/actor")
	  public String ActorEdit(@ModelAttribute Actor actor, Model model) {
	    actor.EditDataBase();
	    DataBase DB = new DataBase();
	    DB.setDataBase();
	    model.addAttribute("dataBase",DB);
	    return "index";
	  }

	  @GetMapping("/actor/{page}")
	  public String nextIndex(@PathVariable(name = "page") Integer page, Model model) {

		//System.out.println(page);
	    model.addAttribute("actor", new Actor());
	    DataBase DB = new DataBase();
	    DB.setDataBase();
        DB.pageIndex = page;

	    model.addAttribute("dataBase",DB);
	    return "index";
	  }

	  @GetMapping("/edit/{name}")
	  public String ActorEdit(@PathVariable(name = "name") String name,@ModelAttribute Actor actor, Model model) {
	      System.out.println(name);
	      var actor_data = name.split(",");
	      actor = new Actor();
	      actor.id = Long.parseLong(actor_data[0]);
	      actor.last_name = actor_data[1];
	      actor.first_name = actor_data[2];
		  model.addAttribute("actor", actor);

		  return "edit";
	  }

	  @GetMapping("/submit")
	  public String ActorSubmitPage(Model model) {
		model.addAttribute("actor", new Actor());

	    return "submit";
	  }
	  @PostMapping("/submit")
	  public String ActorSubmit(@ModelAttribute Actor actor, Model model) {
	    actor.SubmitDataBase();
	    DataBase DB = new DataBase();
	    DB.setDataBase();
	    model.addAttribute("dataBase",DB);
		//model.addAttribute("actor", actor);
	    return "index";
	  }

	  @GetMapping("/delete/{name}")
	  public String ActordeletePage(@PathVariable(name = "name") String name,@ModelAttribute Actor actor, Model model) {
	      var actor_data = name.split(",");
	      actor = new Actor();
	      actor.id = Long.parseLong(actor_data[0]);
	      actor.last_name = actor_data[1];
	      actor.first_name = actor_data[2];
		  model.addAttribute("actor", actor);

	    return "delete";
	  }

	  @PostMapping("/delete")
	  public String Actordelete(@ModelAttribute Actor actor, Model model) {
	    actor.DeleteDataBase();
	    DataBase DB = new DataBase();
	    DB.setDataBase();
	    model.addAttribute("dataBase",DB);
		//model.addAttribute("actor", actor);
	    return "index";
	  }

}
