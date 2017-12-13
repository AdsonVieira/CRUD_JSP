package br.unifacs.ltp2.model;

public class Carro {

    private int id;
    private String fabricante;
    private String modelo;
    private String ano;
    private String quilometragem;
    private String preco;
    private int concessionariaId;
    private String concessionariaNome;
   

    public Carro() {
    }

    public Carro(int id, String fabricante, String modelo, String ano, String quilometragem, String preco, int concessionariaId) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.preco = preco;
        this.concessionariaId = concessionariaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getConcessionariaId() {
        return concessionariaId;
    }
    
    public String getConcessionariaString() {
        return concessionariaNome;
    }
    
    public void setConcessionariaString(String concessionariaNome) {
        this.concessionariaNome = concessionariaNome;
    }

    public void setConcessionariaId(int concessionariaId) {
        this.concessionariaId = concessionariaId;
    }

}
