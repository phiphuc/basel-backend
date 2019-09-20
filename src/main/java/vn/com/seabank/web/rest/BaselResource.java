package vn.com.seabank.web.rest;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.seabank.service.BaselService;

import javax.inject.Inject;

@RestController
@RequestMapping("/api")
public class BaselResource {

    private final Logger log = LoggerFactory.getLogger(RawDataResource.class);

    @Inject
    private BaselService baselService;

    @GetMapping("/get-table-name/{id}")
    @Timed
    public ResponseEntity<?> getTableNameByTableGroup(@PathVariable("id") String id) {
        Object result = null;
        try {
            log.info("Request in getTableNameByTableGroup ");
            result = baselService.getNameTable(id);

        } catch (Exception e) {
            log.error("Error getTableNameByTableGroup");
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
