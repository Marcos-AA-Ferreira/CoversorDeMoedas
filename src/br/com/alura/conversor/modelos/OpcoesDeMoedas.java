package br.com.alura.conversor.modelos;

public class OpcoesDeMoedas {
    private double valorUSD;
    private double valorARS;
    private double valorBRL;
    private double valorEUR;
    private double valorCOP;

    //******************Construtor*******************
    public OpcoesDeMoedas(opcoesDeConversao opcoesdisponiveis) {
        this.valorARS = opcoesdisponiveis.ARS();
        this.valorBRL = opcoesdisponiveis.BRL();
        this.valorCOP = opcoesdisponiveis.COP();
        this.valorEUR = opcoesdisponiveis.EUR();
        this.valorUSD = opcoesdisponiveis.EUR();
    }

    //*********************Setter**********************

    public void setValorUSD(double valorUSD) {
        this.valorUSD = valorUSD;
    }

    public void setValorARS(double valorARS) {
        this.valorARS = valorARS;
    }

    public void setValorBRL(double valorBRL) {
        this.valorBRL = valorBRL;
    }

    public void setValorEUR(double valorEUR) {
        this.valorEUR = valorEUR;
    }

    public void setValorCOP(double valorCOP) {
        this.valorCOP = valorCOP;
    }


    //*********************Getter**********************


    public double getValorARS() {
        return valorARS;
    }

    public double getValorUSD() {
        return valorUSD;
    }

    public double getValorBRL() {
        return valorBRL;
    }

    public double getValorEUR() {
        return valorEUR;
    }

    public double getValorCOP() {
        return valorCOP;
    }

    //*********************funções**********************
    void tabelaDeValores(){
        System.out.println(this.valorARS);
        System.out.println(this.valorUSD);
        System.out.println(this.valorBRL);
        System.out.println(this.valorEUR);
        System.out.println(this.valorCOP);
    }

    public void conversao (double valorInicial, double valorDaTabela, String moedaParaConventer, String moedaConvetida) {
        double resultado = valorInicial * valorDaTabela;
        System.out.println("\n O valor de " + valorInicial + " " + moedaParaConventer + ", correspode ao valor de " + resultado + " " + moedaConvetida);
    }

    @Override
    public String toString() {
        return "Valor do ARS: " + valorARS + ", Valor do USD: " + valorUSD + ", Valor do BRL: " + valorBRL + ", Valor do EUR: " + valorEUR + ", Valor do COP: " + valorEUR;
    }
}
