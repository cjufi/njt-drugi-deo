/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njt_05_06_2026.validator.impl;

import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;
import rs.ac.bg.fon.njt_05_06_2026.validator.Validator;

/**
 *
 * @author Filip
 */
public class TrosakValidator implements Validator<TrosakDto> {

    @Override
    public void validate(TrosakDto trosak) {

        if (trosak.getIznos() <= 0) {
            throw new RuntimeException("Iznos mora biti pozitivan.");
        }

        if (trosak.getNaziv() == null
                || trosak.getNaziv().length() < 5
                || trosak.getNaziv().length() > 10) {
            throw new RuntimeException("Naziv mora imati između 5 i 10 karaktera.");
        }
    }
}
