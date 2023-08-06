package br.com.ingresso.common.domain.value.object;

import br.com.ingresso.common.domain.exception.InvalidCpfException;

public class Cpf extends ValueObject<String> {
    private static final String CFP_IS_REQUIRED = "CPF is required";
    private static final String INVALID_CFP_LENGTH = "CPF must have 11 digits, but has %d digits";
    private static final String INVALID_CPF_DIGITS = "CPF must have at least two different digits";
    private static final String INVALID_CPF_NUMBER = "CPF is invalid";

    private String cpf;

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

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cleanCPF.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9) {
            digit1 = 0;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cleanCPF.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9) {
            digit2 = 0;
        }

        if(!((digit1 == (cleanCPF.charAt(9) - '0')) && (digit2 == (cleanCPF.charAt(10) - '0')))) {
            throw new InvalidCpfException(INVALID_CPF_NUMBER);
        }

        return new Cpf(cleanCPF);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
