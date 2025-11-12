package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.adapter.rest.mapper.UserRestMapper;
import app.adapter.rest.request.CreateUserRequest;
import app.adapter.rest.response.UserResponse;
import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.User;

@RestController
@RequestMapping("/api/hr")
public class HumanResourcesController {

	@Autowired
	private HumanResourcesUseCase humanResourcesUseCase;

	@Autowired
	private UserRestMapper userRestMapper;

	@PostMapping("/doctors")
	public ResponseEntity<UserResponse> createDoctor(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.createDoctor(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRestMapper.toResponse(user));
	}

	@PostMapping("/nurses")
	public ResponseEntity<UserResponse> createNurse(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.createNurse(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRestMapper.toResponse(user));
	}

	@PostMapping("/administrative-staff")
	public ResponseEntity<UserResponse> createAdministrativeStaff(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.createAdministrativeStaff(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRestMapper.toResponse(user));
	}

	@PostMapping("/information-support")
	public ResponseEntity<UserResponse> createInformationSupport(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.createInformationSupport(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRestMapper.toResponse(user));
	}

	@PostMapping("/human-resources")
	public ResponseEntity<UserResponse> createRrHh(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.createRrHh(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRestMapper.toResponse(user));
	}

	@PutMapping("/doctors")
	public ResponseEntity<UserResponse> updateDoctor(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.updateDoctor(user);
		return ResponseEntity.ok(userRestMapper.toResponse(user));
	}

	@PutMapping("/nurses")
	public ResponseEntity<UserResponse> updateNurse(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.updateNurse(user);
		return ResponseEntity.ok(userRestMapper.toResponse(user));
	}

	@PutMapping("/administrative-staff")
	public ResponseEntity<UserResponse> updateAdministrativeStaff(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.updateAdministrativeStaff(user);
		return ResponseEntity.ok(userRestMapper.toResponse(user));
	}

	@PutMapping("/information-support")
	public ResponseEntity<UserResponse> updateInformationSupport(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.updateInformationSupport(user);
		return ResponseEntity.ok(userRestMapper.toResponse(user));
	}

	@PutMapping("/human-resources")
	public ResponseEntity<UserResponse> updateRrHh(@RequestBody CreateUserRequest request) throws Exception {
		User user = userRestMapper.toDomain(request);
		humanResourcesUseCase.updateRrHh(user);
		return ResponseEntity.ok(userRestMapper.toResponse(user));
	}
}



