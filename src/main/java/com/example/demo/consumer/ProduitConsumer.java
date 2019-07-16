package com.example.demo.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Produit;

@Controller
public class ProduitConsumer {



	private RestTemplate restTemplate;

	public ProduitConsumer(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public List<Produit> getProduirs() {
		final String url ="http://localhost:9092/api/produits/";


		//ResponseEntity<Produit[]> responseEntity = restTemplate.getForEntity(url, Produit[].class);
		//Produit[] objects = responseEntity.getBody();
		//List<Produit> produits = new ArrayList<Produit>(Arrays.asList(objects));


		List<Produit> set  = restTemplate.getForObject(url, List.class);
		return set;
	}



	@RequestMapping(value = "/produits")
	public String getProduits(Model model) {

		model.addAttribute("produits",getProduirs());
		return "produits";

	}
	//View
	@RequestMapping(value = "/delete")
	public String getProduit(Model model) {
		return "delete";
	}


	@PostMapping(value = "/deleteProduit")
	public String deleteProduit(int id,Model model) {


		System.out.println(id);
		final String url ="http://localhost:9092/api/produits/deleteProduit/"+id;
		restTemplate.delete(url);
		model.addAttribute("id",id);

		return "index";

	}


	@RequestMapping(value = "/add")
	public String addProduit(Model model) {

		return "add";

	}


	@PostMapping(value = "/addProduit")
	public String addProduit(Produit p,Model model) {


		System.out.println(p);
		final String url ="http://localhost:9092/api/produits/addProduit";
		restTemplate.postForLocation(url, p);
		model.addAttribute("label",p.getLabel());

		return "addProduit";
	}



	@RequestMapping(value = "/edit")
	public String editProduit(Produit p, Model model) {
		System.out.println("produit ********:"+p);



		final String url ="http://localhost:9092/api/produits/editProduit/"+p.getId();



		//restTemplate.postForLocation(url, p);
		

		restTemplate.put(url, p);
		model.addAttribute("produit",p);

		return "edit";



	}
 
	@RequestMapping(value = "/editProduit/{id}")
	public String editProdui(@PathVariable Long id, Model model) {
		
		System.out.println("id ********:"+id);
		final String url ="http://localhost:9092/api/produits/"+id;
		model.addAttribute("produit",restTemplate.getForObject(url, Produit.class));

		return "editProduit";



	}

	@RequestMapping(value = "/deleteProduit/{id}")
	public String deleteProduitt(@PathVariable int id,Model model) {


		System.out.println(id);
		final String url ="http://localhost:9092/api/produits/deleteProduit/"+id;
		restTemplate.delete(url);
		model.addAttribute("id",id);

		return "deleteProduit";

	}

}
