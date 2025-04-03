package com.k21cnt.dxt.lesson11.service;
import com.k21cnt.dxt.lesson11.dto.Dxt_accountDTO;
import com.k21cnt.dxt.lesson11.entity.Dxt_account;
import com.k21cnt.dxt.lesson11.repository.Dxt_accountRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NamingEnumeration;
import java.util.List;
import java.util.Optional;
@Service
@NoArgsConstructor
public class Dxt_accountService {
    private Dxt_accountRepository dxt_accountRepository;
    @Autowired
    public Dxt_accountService(Dxt_accountRepository dxt_accountRepository){
        this.dxt_accountRepository = dxt_accountRepository;
    }
    public List<Dxt_account> fillAll(){
        return dxt_accountRepository.findAll();
    }
    public Optional<Dxt_accountDTO> findById(Long id){
        Dxt_account employee = dxt_accountRepository.findById(id).orElse(null);
        Dxt_accountDTO dxt_accountDTO = new Dxt_accountDTO();
        dxt_accountDTO.setId(id);
        dxt_accountDTO.setUser(employee.getUser());
        dxt_accountDTO.setPass(employee.getPass());
        dxt_accountDTO.setName(employee.getName());
        dxt_accountDTO.setEmail(employee.getEmail());
        dxt_accountDTO.setPhone(employee.getPhone());
        dxt_accountDTO.setAddress(employee.getAddress());
        dxt_accountDTO.setStatus(employee.isStatus());
        return Optional.of(dxt_accountDTO);
    }
    public Boolean save(Dxt_accountDTO dxt_accountDTO){
        Dxt_account dxt_account = new Dxt_account();
        dxt_account.setUser(dxt_accountDTO.getUser());
        dxt_account.setPass(dxt_accountDTO.getPass());
        dxt_account.setName(dxt_accountDTO.getName());
        dxt_account.setEmail(dxt_accountDTO.getEmail());
        dxt_account.setPhone(dxt_accountDTO.getPhone());
        dxt_account.setAddress(dxt_accountDTO.getAddress());
        dxt_account.setStatus(dxt_accountDTO.isStatus());
        try {
            dxt_accountRepository.save(dxt_account);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Dxt_account updatedDxt_accountById(Long id, Dxt_accountDTO updatedDxt_account){
        return dxt_accountRepository.findById(id).map(dxt_account -> {
            dxt_account.setUser(updatedDxt_account.getUser());
            dxt_account.setPass(updatedDxt_account.getPass());
            dxt_account.setName(updatedDxt_account.getName());
            dxt_account.setEmail(updatedDxt_account.getEmail());
            dxt_account.setPhone(updatedDxt_account.getPhone());
            dxt_account.setAddress(updatedDxt_account.getAddress());
            dxt_account.setStatus(updatedDxt_account.isStatus());
            return dxt_accountRepository.save(dxt_account);
        }).orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }
    public void deleteDxt_account(Long id){
        dxt_accountRepository.deleteById(id);
    }
}
