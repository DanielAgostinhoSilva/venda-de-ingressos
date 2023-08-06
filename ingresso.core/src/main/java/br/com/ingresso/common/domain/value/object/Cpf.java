package br.com.ingresso.common.domain.value.object;

import br.com.ingresso.common.domain.exception.InvalidCpfException;

public class Cpf extends ValueObject<String> {
    private static final String CFP_IS_REQUIRED = "CPF is required";
    private static final String INVALID_CFP_LENGTH = "CPF must have 11 digits, but has %d digits";
    private static final String INVALID_CPF_DIGITS = "CPF must have at least two different digits";
    private static final String INVALID_CPF_NUMBER = "CPF is invalid";


    private Cpf(String cpf) {
        super(cpf);
    }

    public static Cpf create(String cpf) {
        if(cpf == null) {
            throw new InvalidCpfException(CFP_IS_REQUIRED);
        }
        String cleanCPF = cpf.replaceAll("[^0-9]", "");

        if(cleanCPF.length() != 11) {
            throw new InvalidCpfException(String.format(INVALID_CFP_LENGTH, cleanCPF.length()));
        }

        boolean allDigitsEquals = cleanCPF.matches("^\\d{1}(\\d)\\1{9}$");
        if(allDigitsEquals) {
            throw new InvalidCpfException(INVALID_CPF_DIGITS);
        }

//        var sum = 0;
//        for (int i = 0; i < 9; i++) {
//            sum += Integer.valueOf(cleanCPF.charAt(i)) * (10 - i);
//        }
//
//        var firstDigit = 11 - (sum % 11);
//        if (firstDigit > 9) {
//            firstDigit = 0;
//        }
//
//        sum = 0;
//        for (int i = 0; i < 10; i++) {
//            sum += Integer.valueOf(cleanCPF.charAt(i)) * (11 - i);
//        }
//        var secondDigit = 11 - (sum % 11);
//        if (secondDigit > 9) {
//            secondDigit = 0;
//        }
//
//        if (firstDigit != Integer.valueOf(cleanCPF.charAt(9)) || secondDigit != Integer.valueOf(cleanCPF.charAt(10))) {
//            throw new InvalidCpfException(INVALID_CPF_NUMBER);
//        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cleanCPF.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9) {
            digit1 = 0;
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cleanCPF.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9) {
            digit2 = 0;
        }

        // Verifica se os dígitos verificadores são iguais aos do CPF
        if(!((digit1 == (cleanCPF.charAt(9) - '0')) && (digit2 == (cleanCPF.charAt(10) - '0')))) {
            throw new InvalidCpfException(INVALID_CPF_NUMBER);
        }

        return new Cpf(cleanCPF);
    }

}
