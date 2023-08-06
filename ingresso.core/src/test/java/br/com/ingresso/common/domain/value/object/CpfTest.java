package br.com.ingresso.common.domain.value.object;


import br.com.ingresso.common.domain.exception.BussinessException;
import br.com.ingresso.common.domain.exception.InvalidCpfException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CpfTest {

    @Test
    public void deve_criar_um_cpf_valido() {
        String cpf = "69628313070";
        Cpf cpfCreated = Cpf.create("696.283.130-70");
        assertNotNull(cpfCreated);
        assertEquals(cpfCreated.getValue(), cpf);
    }

    @Test
    public void deve_lancar_um_erro_quando_cpf_for_nulo() {
        InvalidCpfException cpfIsRequried = assertThrows(InvalidCpfException.class, () -> Cpf.create(null));
        assertEquals("CPF is required", cpfIsRequried.getMessage());
    }

    @Test
    public void deve_lancar_um_erro_quando_o_tamanho_do_cpf_for_deferente_de_11_digitos() {
        InvalidCpfException cpfWith10Digits = assertThrows( InvalidCpfException.class, () -> Cpf.create("6962831307"));
        InvalidCpfException cpfWith12Digits = assertThrows( InvalidCpfException.class, () -> Cpf.create("696283130701"));
        assertEquals("CPF must have 11 digits, but has 10 digits", cpfWith10Digits.getMessage());
        assertEquals("CPF must have 11 digits, but has 12 digits", cpfWith12Digits.getMessage());
    }

    @Test
    public void deve_lancar_uma_erro_quando_cpf_nao_tiver_pelo_menos_dois_digitos_diferentes() {
        var cpfList = List.of(
                "00000000000",
                "11111111111",
                "22222222222",
                "33333333333",
                "44444444444",
                "55555555555",
                "66666666666",
                "77777777777",
                "88888888888",
                "99999999999"
        );
        cpfList.forEach(cpf -> {
            var ex = assertThrows(BussinessException.class, () -> Cpf.create(cpf));
            assertEquals("CPF must have at least two different digits", ex.getMessage());
        });
    }

    @Test
    public void deve_lancar_um_erro_quando_o_digito_do_cpf_for_invalido() {
        String cpfFirstDigitInvalid = "696.283.130-60";
        String cpfSecondDigitInvalid = "696.283.130-71";
        var invalidFirstDigit = assertThrows(InvalidCpfException.class, () -> Cpf.create(cpfFirstDigitInvalid));
        var invalidSecondDigit = assertThrows(InvalidCpfException.class, () -> Cpf.create(cpfSecondDigitInvalid));
        assertEquals("CPF is invalid", invalidFirstDigit.getMessage());
        assertEquals("CPF is invalid", invalidSecondDigit.getMessage());
    }

}
