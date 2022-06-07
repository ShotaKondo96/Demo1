package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.ActorRepository ;
import com.example.demo.Actor ;
@RestController
public class ActorController {
	private ActorRepository repository;

    public ActorController(ActorRepository repository) {
        this.repository = repository;
    }

	  @GetMapping("/search")
	  public @ResponseBody String ActorSearch() {

		  //return ActorRepository.myFindByfirst_name(7).toString();
		  return this.repository .myFindById(60).toString();
	  }

	  @GetMapping("/searchName")
	  public List<Actor> ActorSearchName() {

		  //return ActorRepository.myFindByfirst_name(7).toString();
		  return this.repository .myFindByFirstName("昇太");
	  }

	  @GetMapping("/add")
	  public @ResponseBody String ActorAdd() {
			//Actor n = new Actor();
			//n.setfirst_name("明");
			//n.setlast_name("黒沢");
			//n.setId(this.repository.count()+1);
			this.repository.mySave(this.repository.count()+1,"明","黒沢");
		  return this.repository .myFindByFirstName("昇太").toString();
	  }

	  @GetMapping("/Update")
	  public @ResponseBody String ActorUpdate() {

			this.repository.myUpdate(211,"昇太","近藤");
		  return this.repository .myFindByFirstName("昇太").toString();
	  }
}
