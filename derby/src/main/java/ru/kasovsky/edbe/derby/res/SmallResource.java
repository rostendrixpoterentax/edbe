package ru.kasovsky.edbe.derby.res;

import lombok.extern.slf4j.Slf4j;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiParam;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import org.jsondoc.core.annotation.*;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;
import ru.kasovsky.edbe.derby.doc.Consts;
import ru.kasovsky.edbe.derby.dto.SmallCreateDto;
import ru.kasovsky.edbe.derby.dto.SmallDto;
import ru.kasovsky.edbe.derby.dto.SmallUpdateDto;
import ru.kasovsky.edbe.derby.entity.SmallEntity;
import ru.kasovsky.edbe.derby.mapper.SmallMapper;
import ru.kasovsky.edbe.derby.mock.Big;
import ru.kasovsky.edbe.derby.repo.SmallRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Api(name = SmallResource.TAG,  group = Consts.GROUP_TEST, description = SmallResource.DESC, visibility = ApiVisibility.PUBLIC, stage = ApiStage.BETA)
@ApiVersion(since = "0.1", until = "0.1")
@ApiAuthNone
@RestController
@RequestMapping(SmallResource.PATH)
public class SmallResource {

    public static final String TAG = "small";
    public static final String PATH = "/small";
    public static final String DESC = "API small";

    public static final String METHOD_POST = "METHOD_POST";
    public static final String METHOD_PUT = "METHOD_PUT";
    public static final String METHOD_LIST = "METHOD_LIST";
    public static final String METHOD_GET = "METHOD_GET";
    public static final String METHOD_DELETE = "METHOD_DELETE";


    @Autowired
    private SmallRepo smallRepo;

    @PostMapping()
    @ApiMethod(id = SmallResource.METHOD_POST, description = "Create object")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ApiResponseObject @ResponseBody ResponseEntity<SmallDto> create(
            @ApiBodyObject @RequestBody SmallCreateDto dto,
            UriComponentsBuilder uriComponentsBuilder)
    {
        SmallEntity entity = SmallMapper.MAPPER.toEntity(dto);
        SmallEntity retry = smallRepo.save(entity);
        SmallDto result = SmallMapper.MAPPER.toDto(retry);

        return ResponseEntity
                .created(uriComponentsBuilder.path(PATH +"/{id}").buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @Autowired
    Big big;

    @PostMapping("/gen/{power}")
    @ApiMethod(id = SmallResource.METHOD_POST, description = "Create object")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ApiResponseObject @ResponseBody ResponseEntity<List<Long>> gen(
            @ApiPathParam(name = "power") @PathVariable Long power,
            UriComponentsBuilder uriComponentsBuilder)
    {
        List<Long> report = new ArrayList<>();
        List<SmallCreateDto> data = big.get(power);
        for (SmallCreateDto dto: data) {
            SmallEntity entity = SmallMapper.MAPPER.toEntity(dto);
            SmallEntity retry = smallRepo.save(entity);
            SmallDto result = SmallMapper.MAPPER.toDto(retry);
            report.add(result.getId());
        }

        return ResponseEntity
                .created(uriComponentsBuilder.path(PATH).buildAndExpand().toUri())
                .body(report);
    }

    @PutMapping()
    @ApiMethod(id = SmallResource.METHOD_PUT, description = "Update object")
    public @ApiResponseObject @ResponseBody ResponseEntity<SmallDto> update(
            @ApiBodyObject @RequestBody SmallUpdateDto dto)
    {
        SmallEntity entity = SmallMapper.MAPPER.toDto(dto);
        SmallEntity retry = smallRepo.save(entity);
        SmallDto result = SmallMapper.MAPPER.toDto(retry);

        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/id/all")
    @ApiMethod(id = SmallResource.METHOD_LIST, description = "Get list of id objects")
    public @ApiResponseObject @ResponseBody ResponseEntity<List<Long>> getIdAll()
    {
        Iterable<SmallEntity> iterable = smallRepo.findAll();
        List<Long> report = StreamSupport.stream(iterable.spliterator(), false)
                .map(entyty -> entyty.getId())
                .collect(Collectors.toList());

        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping("/id/from/{from}/to/{to}")
    @ApiMethod(id = SmallResource.METHOD_LIST, description = "Get list of id objects")
    public @ApiResponseObject @ResponseBody ResponseEntity<List<Long>> getIdRange(
            @ApiPathParam(name = "from") @PathVariable Long from,
            @ApiPathParam(name = "to") @PathVariable Long to)
    {
        Iterable<SmallEntity> iterable = smallRepo.findAll();
        List<Long> report = StreamSupport.stream(iterable.spliterator(), false)
                .filter(entity -> entity.getId() >= from && entity.getId() <= to)
                .map(entity -> entity.getId())
                .collect(Collectors.toList());

        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @GetMapping()
    @ApiMethod(id = SmallResource.METHOD_LIST, description = "Get list objects")
    public @ApiResponseObject @ResponseBody ResponseEntity<List<SmallDto>> get()
    {
        Iterable<SmallEntity> iterable = smallRepo.findAll();
        List<SmallEntity> list = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        List<SmallDto> result = SmallMapper.MAPPER.toDto(list);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiMethod(id = SmallResource.METHOD_GET, description = "Create object from id")
    public @ApiResponseObject @ResponseBody ResponseEntity<SmallDto> get(
            @ApiPathParam(name = "id") @PathVariable Long id)
    {
        Optional<SmallEntity> entity = smallRepo.findById(id);
        Optional<SmallDto> result = entity.isPresent() ? Optional.of(SmallMapper.MAPPER.toDto(entity.get())) : Optional.empty() ;

       return result
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ApiMethod(id = SmallResource.METHOD_DELETE, description = "Delete object from id")
    @ResponseStatus(value = HttpStatus.OK)
    public @ApiResponseObject @ResponseBody ResponseEntity<Void> delete(
            @ApiPathParam(name = "id") @PathVariable Long id)
    {
        smallRepo.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
