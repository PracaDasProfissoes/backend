package br.edu.opi.praca.educational_agent.controller;


import br.edu.opi.praca.educational_agent.dto.EducationalAgentIO;
import br.edu.opi.praca.educational_agent.dto.EducationalAgentInput;
import br.edu.opi.praca.educational_agent.dto.EducationalAgentOutput;
import br.edu.opi.praca.educational_agent.models.EducationalAgent;
import br.edu.opi.praca.educational_agent.services.EducationalAgentService;
import br.edu.opi.praca.project_patterns.models.user.Privilege;
import br.edu.opi.praca.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;

@RestController
@RequestMapping(RestConstants.EDUCATIONAL_AGENTE_API)
@Api(tags = "Educational Agent")
@CrossOrigin

public class EducationalAgentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EducationalAgentController.class.getSimpleName());

    private EducationalAgentIO educationalAgentIO;

    private EducationalAgentService educationalAgentService;

    @Autowired
    public EducationalAgentController(EducationalAgentIO educationalAgentIO, EducationalAgentService educationalAgentService) {
        this.educationalAgentIO = educationalAgentIO;
        this.educationalAgentService = educationalAgentService;
    }

    @PreAuthorize("hasAuthority('" + Privilege.CREATE_EDUCATIONAL_AGENT + "')")
    @PostMapping({"/", ""})
    @ApiOperation(value = "Create a educational agent", notes = "Also returns a link to retrieve the saved educational agent in the location header")
    public ResponseEntity<?> create(@Valid @RequestBody EducationalAgentInput educationalAgentInput) {
        LOGGER.info("trying create new school ");
        EducationalAgent educationalAgent = educationalAgentIO.mapTo(educationalAgentInput);
        EducationalAgent savedSchool = educationalAgentService.create(educationalAgent);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSchool.getId())
                .toUri();
        LOGGER.info("school " + educationalAgent.getId() + " create at " + location);
        return ResponseEntity.created(location).build();
    }

    @PreAuthorize("hasAuthority('" + Privilege.INDEX_EDUCATIONAL_AGENT + "')")
    @ApiOperation(value = "Get All Educational Agent")
    @GetMapping({"/", ""})
    // @formatter:off
    public Page<EducationalAgentOutput> index(
            @RequestParam(required = false, name = "page") Integer page,
            @RequestParam(required = false, name = "size") Integer size) {
        LOGGER.info("index schools");
        return educationalAgentIO.toPage(educationalAgentService.index(page, size));
    }
    // @formatter:on

    @PreAuthorize("hasAuthority('" + Privilege.SHOW_EDUCATIONAL_AGENT + "')")
    @ApiOperation(value = "Get a Educational Agent")
    @GetMapping({"/{id}/", "/{id}"})
    // @formatter:off
    public EducationalAgentOutput show(
            @PathVariable("id") Long id) {
        LOGGER.info("show student " + id);
        return educationalAgentIO.mapTo(educationalAgentService.show(id));
    }

    @PreAuthorize("hasAuthority('" + Privilege.UPDATE_EDUCATIONAL_AGENT + "')")
    @PutMapping({"/{id}/", "/{id}"})
    @ApiOperation(value = "Updates a Educational Agent")
    public ResponseEntity<?> update(
            //@formatter:off
            @Min(value = 1) @PathVariable("id") Long id,
            @Valid @RequestBody EducationalAgentInput educationalAgentInput) {
        EducationalAgent educationalAgent = educationalAgentIO.mapTo(educationalAgentInput);
        educationalAgentService.update(id, educationalAgent);
        return ResponseEntity.noContent().build();
    }

    //@formatter:on

    @PreAuthorize("hasAuthority('" + Privilege.DELETE_EDUCATIONAL_AGENT + "')")
    @DeleteMapping({"/{id}/", "/{id}"})
    @ApiOperation(value = "Delete a Educational Agent")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        LOGGER.info("trying deleting student " + id);
        educationalAgentService.delete(id);
        LOGGER.info("student " + id + " deleted");
        return ResponseEntity.ok().build();
    }
    // @formatter:on
}
