package br.com.iftm.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.CaronaBusiness;
import br.com.iftm.entity.Carona;
import br.com.iftm.entity.Cidade;

@RestController // Habilita Classe como um serviço rest.
@RequestMapping(value = "/modelo-carona") // Nome do prestador servico.
public class CaronaRest {

	@Autowired
	private CaronaBusiness business;

	// create
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Carona carona) {

		try {

			carona = business.create(carona);

			return ResponseEntity.ok(carona);

		} catch (BusinessException e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// read
	@GetMapping
	public ResponseEntity<?> read() {

		try {

			return ResponseEntity.ok(business.read());

		} catch (BusinessException e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);

		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// update
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Carona carona) {

		try {

			carona = business.update(id, carona);

			return ResponseEntity.ok(carona);

		} catch (BusinessException e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		try {

			business.delete(id);

			return ResponseEntity.ok().build();

		} catch (BusinessException e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}

	// read cidade
	@GetMapping("/filtro")
	public ResponseEntity<?> readByCidade(@PathParam("nome") Cidade cidade) {

		try {

			List<Carona> readByCidade = business.readByCidade(cidade.getNome());

			if (readByCidade == null || readByCidade.isEmpty()) {

				return ResponseEntity.notFound().build();

			}

			return ResponseEntity.ok(readByCidade);

		} catch (BusinessException e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);

		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.badRequest().body(e);
		}

	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> readById(@PathVariable("id") Integer id) {

		try {
			Carona readByName = business.readById(id);

			if (readByName == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(readByName);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}
}
