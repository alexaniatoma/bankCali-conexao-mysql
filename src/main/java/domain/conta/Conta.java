package domain.conta;

import java.math.BigDecimal;
import java.util.Objects;

import domain.cliente.Cliente;


public class Conta {

    private Integer numero;
    private BigDecimal saldo;
    private Cliente titular;
    private boolean estaAtiva;

    public Conta(Integer numero, BigDecimal saldo, Cliente titular, Boolean estaAtiva) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
        this.estaAtiva = estaAtiva;
    }

    public boolean possuiSaldo() {
        return this.saldo.compareTo(BigDecimal.ZERO) != 0;
    }

    public void sacar(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero.equals(conta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public String toString() {
        return "Conta{" +
                "numero ='" + numero + '\'' +
                " saldo ='" + saldo + '\'' +
                ", titular =" + titular +
                '}';
    }

    public Integer getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

   public Cliente getTitular() {
        return titular;
    }

    public Boolean getEstaAtiva() {
        return estaAtiva;
    }
}
