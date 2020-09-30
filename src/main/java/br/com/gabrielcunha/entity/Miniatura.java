package br.com.gabrielcunha.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "miniaturas")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Miniatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "min_id")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "min_caminho")
	private String caminho;

	@OneToMany(mappedBy = "miniatura")
	private List<Foto> fotos;
	
	
	
}
