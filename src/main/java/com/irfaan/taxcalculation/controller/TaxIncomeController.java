package com.irfaan.taxcalculation.controller;

import com.irfaan.taxcalculation.enums.StatusResultEnum;
import com.irfaan.taxcalculation.exceptions.TaxAppException;
import com.irfaan.taxcalculation.model.BaseResult;
import com.irfaan.taxcalculation.model.TaxIncomeRequest;
import com.irfaan.taxcalculation.model.TaxIncomeResult;
import com.irfaan.taxcalculation.service.CalculateTaxService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author irfaanhibatullah
 * @version $Id: TaxIncomeController.java, v 0.1 2023‐01‐05 23.03 irfaanhibatullah Exp $$
 */

@RestController
@AllArgsConstructor
public class TaxIncomeController {

    private CalculateTaxService calculateTaxService;


    @PostMapping(value = "/taxes")
    public ResponseEntity<BaseResult> calculateTaxFromIncome(@RequestBody @Valid TaxIncomeRequest request) {
        BaseResult result = new BaseResult();
        try {
            result = calculateTaxService.calculateTaxFromIncome(request);
            if (result != null) {
                return ResponseEntity.status(HttpStatus.OK).body(result);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } catch (TaxAppException e) {
            result.setMessage(e.getMessage());
            result.setStatus(StatusResultEnum.FAILED.getCode());
            result.setStatusCode(String.valueOf(e.getStatus().value()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setStatus(StatusResultEnum.FAILED.getCode());
            result.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }


    }
}