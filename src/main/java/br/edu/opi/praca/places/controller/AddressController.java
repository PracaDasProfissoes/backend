package br.edu.opi.praca.places.controller;


import br.edu.opi.praca.places.dto.AddressIO;
import br.edu.opi.praca.places.dto.AddressInput;
import br.edu.opi.praca.places.dto.AddressOutput;
import br.edu.opi.praca.places.model.Address;
import br.edu.opi.praca.places.service.AddressService;
import br.edu.opi.praca.project_patterns.dto.AppControllerBase;
import br.edu.opi.praca.utils.RestConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(RestConstants.ADRESS_URI)
@Api(tags = "Places")
public class AddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class.getSimpleName());

    private AppControllerBase appControllerBase;

    private AddressService addressService;

    private AddressIO addressIO;

    @Autowired
    public AddressController(
            AppControllerBase appControllerBase,
            AddressService addressService) {
        this.appControllerBase = appControllerBase;
        this.addressService = addressService;
    }

    @PostMapping({"/", ""})
    @ApiOperation(value = "Create a Delegate", notes = "Also returns a link to retrieve the saved Delegate in the location header")
    public ResponseEntity<Object> create(@Valid @RequestBody AddressInput addressInput) {
        Address address = addressIO.mapTo(addressInput);
        Address savedAddress = addressService.create(address);
        //@formatter:off
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAddress.getId())
                .toUri();
        LOGGER.info("delegate " + address.getId() + " create at " + location);
        return ResponseEntity.created(location).build();
        //@formatter:on
    }

    @ApiOperation(value = "Get All Addresses")
    @GetMapping({"/", ""})
    public List<AddressOutput> index() {
        //@formatter:off
        LOGGER.info("index addresses");
        Type type = new TypeToken<List<AddressOutput>>() {}.getType();
        return appControllerBase.toList(addressService.index(), type);
        //@formatter:on
    }

    @ApiOperation(value = "Get a Address")
    @GetMapping({"/{id}/", "/{id}"})
    public AddressOutput show(@PathVariable("id") Long id) {
        LOGGER.info("show state " + id);
        return appControllerBase.mapTo(addressService.show(id), AddressOutput.class);
    }
}
