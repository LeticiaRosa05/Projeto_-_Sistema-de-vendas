package Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Realizacao_venda {

    /*- Realização de venda
     ^ Valor pago, valor total, troco e total de itens
     ^ Lista de produtos(adicionar, alterar(nome e preço), excluir) da venda >> a ser feito
     ^ Forma de pagamento default é dinheiro > caso não informado, será dinheiro
     ^ Opção de FP em cada venda
          ^ Caso seja cartão, cálculo automático de taxa > solicitado no registro de login
     ^ Opção de registrar/finalizar venda >> do-while com opção pra finalizar?*/

    Scanner ler = new Scanner(System.in);
    Produto p = new Produto();
    List<Produto> vendaAtual = new ArrayList<Produto>();
    String FP;
    Double valorTotal = 0.;

    public void infoDaVenda(){
        
        String enc;

        //do{
            System.out.printf("Nome do produto: ");
            //enc = ler.nextLine();
            p.nome = ler.nextLine();
            System.out.printf("Preço: ");
            p.prec = ler.nextDouble();
            
            vendaAtual.add(p);
            for (int i=0; i<vendaAtual.size(); i++){
                valorTotal += p.prec;
            }
        //} while(!enc.equals("encerrar"));

        System.out.printf("Quantidade total de tens: " +vendaAtual.size()+ ". O valor total ficou em RS" +valorTotal+ ".");
        System.out.println("\nForma de pagamento: ");
        FP = ler.nextLine();
        System.out.println("Nome do produto: "+p.getNome()+"\nPreco: "+p.getPrec());
        pagamento();

        ler.close();
    }

    public void pagamento(){

        Double pago = 0., troco, valorDeb, valorCred, taxaDeb = .9770, taxaCred = 0.9450; //taxas a serem inseridas no login de admin, valores exemplo
        char debCred;

        troco = pago - valorTotal;
        valorDeb = valorTotal/taxaDeb;
        valorCred = valorTotal/taxaCred;

        switch (FP) { //case para escolher forma de pagamento
            case "":
                FP = "Dinheiro";
            case "dinheiro":
                System.out.println("Pago: ");
                pago = ler.nextDouble();
                System.out.println("Valor total: " + valorTotal);
                System.out.println("Troco: " + troco);
                break;
            case "pix":
                System.out.println("Chave pix - @email");
                System.out.println("Valor total: " + valorTotal); //n é pedido valor a ser pago pois n tem troco e vai ser mostrado o comprovante
                pago = ler.nextDouble();
            case "cartao":
                System.out.println("Debito ou credito?\n"); //desenvolver
                debCred = ler.next().charAt(0);
                if (debCred == 'd'){
                    System.out.println("Valor total: "+valorDeb);
                } else if (debCred == 'c'){
                    System.out.println("Valor total: "+valorCred);
                } else {
                    System.out.println("Escolha entre debito e credito.");
                }
            default:
                System.out.println("Escolha uma forma de pagamento válida");
                break;
        }
    }
    
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        String venda;

        Realizacao_venda RV = new Realizacao_venda();

        System.out.print("Iniciar venda: ");
        venda = ler.nextLine();
        if (venda.equalsIgnoreCase("S")){
            RV.infoDaVenda();
        } else if (venda.equalsIgnoreCase("N")){
            System.out.println("Ok. Venda cancelada.");
        }
        
        ler.close();
    }
}
