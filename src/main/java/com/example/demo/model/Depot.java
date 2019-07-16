package com.example.demo.model;


import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Depot {

	private Long id;
	
	private String nom,ville,email,tel;
	
	private int codePostal;
	private Set<Produit> produits;

	public Depot(String nom, String ville, String email, String tel, int codePostal) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.email = email;
		this.tel = tel;
		this.codePostal = codePostal;
		
	}

	@Override
	public String toString() {
		return "Depot [id=" + id + ", nom=" + nom + ", ville=" + ville + ", email=" + email + ", tel=" + tel
				+ ", codePostal=" + codePostal + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Depot other = (Depot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	
}
