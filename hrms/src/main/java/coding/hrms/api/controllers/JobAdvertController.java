package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.JobAdvertService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobAdvert;
import coding.hrms.entities.dtos.JobAdvertForListDto;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertController {
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(final JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody final JobAdvert jobAdvert) {
		final Result result = jobAdvertService.add(jobAdvert);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update/disablebyid")
	public ResponseEntity<Result> disableById(final int id) {
		final Result result = jobAdvertService.disableById(id);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobAdvert>>> getAll() {
		final DataResult<List<JobAdvert>> result = jobAdvertService.getAll();

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvert>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/forlist/byisactiveandemployercompanyname")
	public ResponseEntity<DataResult<List<JobAdvertForListDto>>> getAllByIsActiveAndEmployer_CompanyNameForList(
			@RequestParam final boolean isActive, @RequestParam final String companyName) {
		final DataResult<List<JobAdvertForListDto>> result = jobAdvertService
				.getAllByIsActiveAndEmployer_CompanyNameForList(isActive, companyName);

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertForListDto>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/forlist/byisactive")
	public ResponseEntity<DataResult<List<JobAdvertForListDto>>> getAllByIsActiveForList(
			@RequestParam final boolean isActive) {
		final DataResult<List<JobAdvertForListDto>> result = jobAdvertService.getAllByIsActiveForList(isActive);

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertForListDto>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/forlist/byisactiveorderbycreatedatby")
	public ResponseEntity<DataResult<List<JobAdvertForListDto>>> getAllByIsActiveOrderByCreatedAtByForList(
			@RequestParam final boolean isActive, @RequestParam final String direction) {
		final DataResult<List<JobAdvertForListDto>> result = jobAdvertService
				.getAllByIsActiveOrderByCreatedAtByForList(isActive, direction);

		if (!result.isSuccess())
			return new ResponseEntity<DataResult<List<JobAdvertForListDto>>>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody final JobAdvert jobAdvert) {
		final Result result = jobAdvertService.update(jobAdvert);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
