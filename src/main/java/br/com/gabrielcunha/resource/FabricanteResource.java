package br.com.gabrielcunha.resource;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabrielcunha.entity.Fabricante;
import br.com.gabrielcunha.repository.FabricantesRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteResource {
	
	@Autowired
	private FabricantesRepository fabricantesDao;
	
	@ApiOperation(value="Recurso responsável por receber alguma coisa.")
	@GetMapping
	public List<Fabricante> listar () throws Exception{
		return fabricantesDao.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Fabricante> create(@RequestBody Fabricante fabricante) {
		
		Fabricante fabricanteSalvo = fabricantesDao.save(fabricante);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
									.path("/{id}")
									.buildAndExpand(fabricanteSalvo.getId()).toUri();
		
		 return ResponseEntity.created(uri).body(fabricanteSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fabricante> buscarPorId(@PathVariable Long id) {
		
		Optional<Fabricante> fabricanteOptional = fabricantesDao.findById(id);
		
		Fabricante fabricante = new Fabricante();
		
		if (fabricanteOptional.isPresent()) {
			
			fabricante = fabricanteOptional.get();
			
			return ResponseEntity.ok(fabricante);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
 
}
