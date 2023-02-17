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


import com.nttdata.movimients.model.Movement;
import com.nttdata.movimients.service.MovementsService;


@RestController
@RequestMapping(value="movements")
public class MovementsController {

	@Autowired
	MovementsService movementsService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movement>> getMoviminets() {
		return new ResponseEntity<>(movementsService.getMovements(), HttpStatus.OK);
	}

	@GetMapping(value = "productMoviments/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movement>> getMoviminetsByProduct(@PathVariable long productId) {
		return new ResponseEntity<>(movementsService.getMovementsByProductId(productId), HttpStatus.OK);
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveMovimient(@RequestBody Movement movements) {

		movementsService.saveMovements(movements);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Movement updateMovients(@PathVariable long id, @RequestBody Movement movements) {
		if (movementsService.getMovementsById(id) == null) {
			return null;
		}
		return movementsService.updateMovements(movements);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movement> deleteMovements(@PathVariable long id) {
		if (movementsService.getMovementsById(id) == null) {
			return null;

		}
		movementsService.deleteMovements(id);
		return movementsService.getMovements();

	}

	/*
	 * // @GetMapping("/{id}")
	 * 
	 * @GetMapping(value = "Movements/{id}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<?>
	 * read(@PathVariable(value = "id") Long MovimientId) { // value es cuando id no
	 * es igual al // Userid Optional<Movements> oMovimient =
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
	 * @PutMapping(value = "Movements/{id}", consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<?>
	 * update(@RequestBody Movements movimientsDails,
	 * 
	 * @PathVariable(value = "id") Long Momivimientid) { Optional<Movements>
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
	 * saveMovements(movimient.get())); }
	 * 
	 * 
	 * @DeleteMapping(value = "Movements/{id}", consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<?>
	 * delete(@PathVariable(value = "id") Long userId) { if
	 * (!movimientsService.findById(userId).isPresent()) { return
	 * ResponseEntity.notFound().build(); } movimientsService.deleteById(userId);
	 * return ResponseEntity.ok().build(); }
	 */

}
