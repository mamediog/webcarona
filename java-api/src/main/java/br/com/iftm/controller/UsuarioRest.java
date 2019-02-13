package br.com.iftm.controller;

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
import br.com.iftm.business.UsuarioBusiness;
import br.com.iftm.entity.Carona;
import br.com.iftm.entity.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRest {

	@Autowired
	private UsuarioBusiness business;

	// create
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {

		try {
			usuario = business.create(usuario);

			return ResponseEntity.ok(usuario);
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
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Usuario usuario) {

		try {

			usuario = business.update(usuario);

			return ResponseEntity.ok(usuario);

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
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> readById(@PathVariable("id") Integer id) {

		try {
			Usuario readById = business.readById(id);

			if (readById == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(readById);
		} catch (BusinessException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e);
		}
	}
}
