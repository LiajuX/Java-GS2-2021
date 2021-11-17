package br.com.fiap.producao.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.producao.dao.DAOFactory;
import br.com.fiap.producao.dao.MercadoriaDAO;
import br.com.fiap.producao.entity.Mercadoria;

public class MainClass {

	public static void main(String[] args) {
		MercadoriaDAO dao = DAOFactory.getMercadoriaDAO();
		
        Mercadoria mercadoria = new Mercadoria();
        
        boolean continuaLoop;
        int opcao, codigo;
        String nome, origem, destino, sitAtual, tempIdeal, tempAtual;

        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("\nEscolha conforme o menu:");
            System.out.println("1. INSERT");            
            System.out.println("2. UPDATE");           
            System.out.println("3. SELECT TODOS"); 
            System.out.println("4. SELECT POR CÓDIGO"); 
            System.out.println("5. DELETE"); 

            opcao = input.nextInt();
            input.nextLine();
            
            switch(opcao) {
                case 1:
                	System.out.println("\nInserindo nova mercadoria...");
                    System.out.println("Nome: ");
                    nome = input.nextLine();

                    System.out.println("Origem: ");
                    origem = input.nextLine();
                    
                    System.out.println("Destino: ");
                    destino = input.nextLine();
                    
                    System.out.println("Situação atual da mercadoria: ");
                    sitAtual = input.nextLine();
                    
                    System.out.println("Temperatura ideal de transporte: ");
                    tempIdeal = input.nextLine();
                    
                    System.out.println("Temperatura atual: ");
                    tempAtual = input.nextLine();
   
                    mercadoria.setNomeProduto(nome);
                    mercadoria.setOrigem(origem);
                    mercadoria.setDestino(destino);
                    mercadoria.setSituacaoAtual(sitAtual);
                    mercadoria.setTemperaturaIdeal(tempIdeal);
                    mercadoria.setTemperaturaAtual(tempAtual);
                                        
                    dao.inserir(mercadoria);
                    
                    System.out.println("\nMercadoria inserida com sucesso!");
                break;
                
                case 2:
                	 System.out.println("\nAtualizando dados da mercadoria...");
                	 System.out.println("Informe o código da mercadoria que deseja atualizar: ");
                     codigo = input.nextInt();
                     input.nextLine();
                	 
                     System.out.println("Nome: ");
                     nome = input.nextLine();

                     System.out.println("Origem: ");
                     origem = input.nextLine();
                     
                     System.out.println("Destino: ");
                     destino = input.nextLine();
                     
                     System.out.println("Situação atual da mercadoria: ");
                     sitAtual = input.nextLine();
                     
                     System.out.println("Temperatura ideal de transporte: ");
                     tempIdeal = input.nextLine();
                     
                     System.out.println("Temperatura atual: ");
                     tempAtual = input.nextLine();
    
                     mercadoria.setNomeProduto(nome);
                     mercadoria.setOrigem(origem);
                     mercadoria.setDestino(destino);
                     mercadoria.setSituacaoAtual(sitAtual);
                     mercadoria.setTemperaturaIdeal(tempIdeal);
                     mercadoria.setTemperaturaAtual(tempAtual);
                     mercadoria.setCodigo(codigo);
                     
                     dao.atualizar(mercadoria);
                     
                     System.out.println("\nMercadoria atualizada com sucesso!");
                     
                  
                break;
                
                case 3:
                    System.out.println("\nTabela de mercadorias:");
                    List<Mercadoria> mercadorias = dao.buscarTodos();
                    
                    for (Mercadoria merc: mercadorias) {
                        System.out.println(merc.toString());
                    }
                break;
                
                case 4:
                    System.out.println("\nBuscando mercadoria...");
                    System.out.println("Informe o código da mercadoria que deseja buscar: ");
                    codigo = input.nextInt();
                    input.nextLine();
                    
                    mercadoria = dao.buscarPorCodigo(codigo);
                    
                    System.out.println(mercadoria.toString());
                break;
                
                case 5:
                    System.out.println("\nRemovendo mercadoria...");
                    System.out.println("Informe o código do produto que deseja remover: ");
                    codigo = input.nextInt();
                    input.nextLine();
                    
                    dao.remover(codigo);
                    
                    System.out.println("\nMercadoria removida com sucesso!");
                break;
                
                default:
                    System.out.println("Escolha inválida!");
            }
            
            System.out.println("\nDeseja continuar? Digite true se SIM ou false se NÃO");
            continuaLoop = input.nextBoolean();
            input.nextLine();
            
        } while (continuaLoop == true);
        
        System.out.println("\nPrograma encerrado!");
        
        input.close();
	}

}
