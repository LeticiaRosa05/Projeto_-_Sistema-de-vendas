package Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Realizacao_venda {

    Scanner ler = new Scanner(System.in);
    float pago, total, troco;
    Produto p = new Produto();
    List<Realizacao_venda> vendaAtual = new ArrayList<Realizacao_venda>();

    void vender(){
        System.out.printf("ID do produto: "); //ID do produto vai ser seu índice na lista
        p.id = ler.nextInt();
        System.out.printf("Nome do produto: ");
        p.nome = ler.nextLine();
        System.out.printf("Preço: ");
        p.prec = ler.nextDouble();
        System.out.println("ID: "+p.getId()+"\nNome: "+p.getNome()+"\nDescricao: "+p.getPrec());

        produto.add(vendaAtual);


        ler.close();
    }
  
    public static void main(String[] args) {
        
    }

}
