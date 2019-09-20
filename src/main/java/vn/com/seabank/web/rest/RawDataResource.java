package vn.com.seabank.web.rest;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.seabank.service.RawDataService;
import vn.com.seabank.service.dto.BS2ChangeConfigBodyRequest;
import vn.com.seabank.service.dto.BS2GetDataRequest;
import vn.com.seabank.service.dto.BS2InsertDataBodyRequest;

import javax.inject.Inject;

@RestController
@RequestMapping("/api")
public class RawDataResource {

    private final Logger log = LoggerFactory.getLogger(RawDataResource.class);

    @Inject
    private RawDataService rawDataService;

    @PostMapping("/get-data-table")
    @Timed
    public ResponseEntity<?> getTableRawData(@RequestBody BS2GetDataRequest request){
        log.info("Request in getTableRawData :"+request.toString());
        Object result = new Object();
        try {
           result = rawDataService.getTableRawData(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get-config-table/{tableName}")
    @Timed
    public ResponseEntity<?> getConfigTable(@PathVariable("tableName") String tableName) {
        Object result = null;
        try {
            log.info("Request in getConfigTable ");
            result = rawDataService.getConfigTable(tableName);

        } catch (Exception e) {
            log.error("Error getConfigTable");
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/change-config-table")
    @Timed
    public ResponseEntity<?> changeConfigTable(@RequestBody BS2ChangeConfigBodyRequest request){
        log.info("Request in changeConfigTable :"+request.toString());
        Object result = new Object();
        try {
            result = rawDataService.changeConfigTable(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/insert-data")
    @Timed
    public ResponseEntity<?> insertData(@RequestBody BS2InsertDataBodyRequest request){
        log.info("Request in changeConfigTable :"+request.toString());
        Object result = new Object();
        try {
            result = rawDataService.insertData(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
