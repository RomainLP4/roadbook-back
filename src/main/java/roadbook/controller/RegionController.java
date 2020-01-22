package roadbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import roadbook.repository.RegionRepository;

@RestController
public class RegionController {

	@Autowired
	private RegionRepository regionRepository;
}
