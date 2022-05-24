package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransaksiPaymentImple implements TransaksiService {
    @Autowired
    public TransaksiRepository transaksiRepository;

    @Override
    public Map save(Transaksi obj) {
        Map map = new HashMap();
        try{
            Transaksi save = transaksiRepository.save(obj);
            map.put("data", save);
            map.put("code", "200");
            map.put("status", "success");
            return map;
        }catch(Exception e){
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }
    }

    @Override
    public Map updateStatus(Transaksi obj) {
        Map map = new HashMap();
        try{
            Transaksi updateStatus = transaksiRepository.getByID(obj.getId());
            Transaksi doSave = transaksiRepository.save(updateStatus);
            map.put("data", doSave);
            map.put("code", "200");
            map.put("status", "success");
        }catch (Exception e){
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }
        return null;
    }
}
