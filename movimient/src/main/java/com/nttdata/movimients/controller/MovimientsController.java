package com.nttdata.movimients.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nttdata.movimients.model.Movimients;
import com.nttdata.movimients.service.MovimientsService;

@RestController
@RequestMapping(value="moviments")
public class MovimientsController {

	@Autowired
	MovimientsService movimientsService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movimients>> getMoviminets() {
		return new ResponseEntity<>(movimientsService.getMovimients(), HttpStatus.OK);
	}

	@GetMapping(value = "productMoviments/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movimients>> getMoviminetsByProduct(@PathVariable long productId) {
		return new ResponseEntity<>(movimientsService.getMovimientsByProductId(productId), HttpStatus.OK);
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveMovimient(@RequestBody Movimients movimients) {

		movimientsService.saveMovimients(movimients);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movimients updateMovients(@PathVariable long id, @RequestBody Movimients movimients) {
		if (movimientsService.getMovimientsById(id) == null) {
			return null;
		}
		return movimientsService.updateMovimients(movimients);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movimients> deleteMovimients(@PathVariable long id) {
		if (movimientsService.getMovimientsById(id) == null) {
			return null;

		}
		movimientsService.deleteMovimients(id);
		return movimientsService.getMovimients();

	}

	/*
	 * // @GetMapping("/{id}")
	 * 
	 * @GetMapping(value = "Movimients/{id}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<?>
	 * read(@PathVariable(value = "id") Long MovimientId) { // value es cuando id no
	 * es igual al // Userid Optional<Movimients> oMovimient =
	 * movimientsService.findById(MovimientId);
	 * 
	 * if (!oMovimient.isPresent()) { return ResponseEntity.notFound().build(); }
	 * 
	 * return ResponseEntity.ok(oMovimient);
	 * 
	 * }
	 */
	/*
	 * { "productId": 1, "customerId":1, "amount":10, "creationDate":"2023-02-10",
	 * "movientType": 1 }
	 */

	/*
	 * @PutMapping(value = "Movimients/{id}", consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<?>
	 * update(@RequestBody Movimients movimientsDails,
	 * 
	 * @PathVariable(value = "id") Long Momivimientid) { Optional<Movimients>
	 * movimient = movimientsService.findById(Momivimientid);
	 * 
	 * if (!movimient.isPresent()) { return ResponseEntity.notFound().build(); //
	 * error 404 no econtrado } // copiar objeto
	 * 
	 * // BeanUtils.copyProperties(userDails, user.get());
	 * 
	 * movimient.get().setProductId(movimientsDails.getProductId());
	 * movimient.get().setCustomerId(movimientsDails.getCustomerId());
	 * movimient.get().setAmount(movimientsDails.getAmount());
	 * movimient.get().setCreationDate(movimientsDails.getCreationDate());
	 * movimient.get().setMovientType(movimientsDails.getMovientType());
	 * 
	 * return ResponseEntity.status(HttpStatus.CREATED).body(movimientsService.
	 * saveMovimients(movimient.get())); }
	 * 
	 * 
	 * @DeleteMapping(value = "Movimients/{id}", consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<?>
	 * delete(@PathVariable(value = "id") Long userId) { if
	 * (!movimientsService.findById(userId).isPresent()) { return
	 * ResponseEntity.notFound().build(); } movimientsService.deleteById(userId);
	 * return ResponseEntity.ok().build(); }
	 */

}
