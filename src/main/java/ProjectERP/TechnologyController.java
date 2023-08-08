//package ProjectERP;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import ProjectERP.models.Technology;
//import ProjectERP.repository.Technology_Repository;
//@RestController
//@RequestMapping("/api/technology")
//public class TechnologyController {
//	 private final Technology_Repository technologyrepository;
//	    
//
//	    @Autowired
//	    public TechnologyController( Technology_Repository technologyrepository) {
//	       
//	        this.technologyrepository = technologyrepository;
// 
//	    }
//
//	    @PostMapping
//	    public ResponseEntity<Technology> create(@Valid @RequestBody Technology t) {
//	        Technology technology = technologyrepository.save(t);
//	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//	            .buildAndExpand(technology.getTechnology_id()).toUri();
//
//	        return ResponseEntity.created(location).body(technology);
//	    }
//
////	    @PutMapping("/{id}")
////	    public ResponseEntity<Library> update(@PathVariable Integer id, @Valid @RequestBody Library library) {
////	        Optional<Library> optionalLibrary = libraryRepository.findById(id);
////	        if (!optionalLibrary.isPresent()) {
////	            return ResponseEntity.unprocessableEntity().build();
////	        }
////
////	        library.setId(optionalLibrary.get().getId());
////	        libraryRepository.save(library);
////
////	        return ResponseEntity.noContent().build();
////	    }
////
////	    @DeleteMapping("/{id}")
////	    public ResponseEntity<Library> delete(@PathVariable Integer id) {
////	        Optional<Library> optionalLibrary = libraryRepository.findById(id);
////	        if (!optionalLibrary.isPresent()) {
////	            return ResponseEntity.unprocessableEntity().build();
////	        }
////
////	        libraryRepository.delete(optionalLibrary.get());
////
////	        return ResponseEntity.noContent().build();
////	    }
//
//	    @GetMapping("/{id}")
//	    public ResponseEntity<Technology> getById(@PathVariable Integer id) {
//	        Optional<Technology> technology = technologyrepository.findById(id);
//	        if (!technology.isPresent()) {
//	            return ResponseEntity.unprocessableEntity().build();
//	        }
//
//	        return ResponseEntity.ok(technology.get());
//	    }
//
//	    @GetMapping
//	    public List<Technology> getAll() {
//	        return technologyrepository.findAll();
//	    }
//}
