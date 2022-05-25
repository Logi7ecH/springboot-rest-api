package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi/")
public class TransaksiController {
    @Autowired
    public TransaksiService serviceTransaksi;

    @Autowired
    public TransaksiRepository repoTransaksi;

    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Transaksi objmodel){
        Map save = serviceTransaksi.save(objmodel);
        return new ResponseEntity<Map>(save, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objmodel){
        Map updateStatus = serviceTransaksi.updateStatus(objmodel);
        return new ResponseEntity<Map>(updateStatus, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map> list(@RequestParam @PageableDefault(size = 10) Integer page,
                                    @RequestParam @PageableDefault(size = 10) Integer size,
                                    @RequestParam() String status){
        Pageable show_data = PageRequest.of(page,size);
        Page<Transaksi> list = null;
        if(status != null){
            list = repoTransaksi.getByStatus(status, show_data);
        }else{
            list = repoTransaksi.getList(show_data);
        }
        System.out.println(list);
        Map map = new HashMap();
        map.put("data", list);
        map.put("code", "200");
        map.put("status", "success");
        return new ResponseEntity<Map>(map, new HttpHeaders(),HttpStatus.OK);
    }

}
