package br.mack.ps2.interfaces;

import br.mack.ps2.*;
import br.mack.ps2.persistencia.PaisDAO;

import java.util.Scanner;
import java.util.List;

public class UserInterfacePaises {
    PaisDAO dao;
    Scanner in;

    public UserInterfacePaises(PaisDAO dao){
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void Start(){
        printMenu();
    }

    private void printMenu(){
        int c = 0;
        do {
            System.out.println("============================");
            System.out.println("|           MENU           |");
            System.out.println("============================");
            System.out.println("| Options:                 |");
            System.out.println("|        1. Create         |");
            System.out.println("|        2. Read           |");
            System.out.println("|        3. Update         |");
            System.out.println("|        4. Delete         |");
            System.out.println("|        5. Exit           |");
            System.out.println("============================");
            c = in.nextInt();
            in.nextLine();

            switch (c) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("end!");
                default:
                    break;
            }
        } while (c != 5);
    }

    private void create (){
        Pais pais = new Pais();
        System.out.println("Dê o ID do país: ");
        pais.setId(in.nextInt());
        System.out.println("Dê o nome do país: ");
        pais.setNome(in.next());
        System.out.println("Dê o continente em que o país se encontra: ");
        pais.setContinente(in.next());
        System.out.println("Dê o número da população: ");
        pais.setPopulacao(in.nextDouble());

        if (dao.create(pais)) {
            System.out.println("Criado com Sucesso!");
        }
        else{
            System.out.println("Não foi possível criar");
        }
    }

    private void read(){
        List<Pais> paises = dao.read();
        for(int i = 0; i < paises.size(); i++){
            System.out.println(paises.get(i));
        }
    }

    private void update(){
        Pais pais = new Pais();
        System.out.println("Dê o ID do país: ");
        pais.setId(in.nextInt());
        System.out.println("Dê o nome do país: ");
        pais.setNome(in.next());
        System.out.println("Dê o continente em que o país se encontra: ");
        pais.setContinente(in.next());
        System.out.println("Dê o número da população: ");
        pais.setPopulacao(in.nextDouble());

        if (dao.update(pais)) {
            System.out.println("Atualizado com Sucesso!");
        }
        else{
            System.out.println("Não foi possível criar");
        }
    }

    private void delete(){
        System.out.println("Digite o id do país que deseja apagar: ");
        int id = in.nextInt();

        List<Pais> paises = dao.read();

        int i;
        for(i = 0; i< paises.size(); i++){
            if(id == paises.get(i).getId()){
                System.out.println("Achei o País: ");
                System.out.println(paises.get(i));
            }else{
                System.out.println("Não foi encontrado nenhum país com esse id");
            }
        }
        System.out.println("Deseja mesmo apagar este país?");
        System.out.println("1 - Sim!");
        System.out.println("2 - Não!");
        int op = in.nextInt();

        if(op == 1){
            if(dao.delete(paises.get(i))){
                System.out.println("País excluido com sucesso!");
            }else{
                System.out.println("Não foi possível excluir");
            }
        }else{
            System.out.println("O país não será apagado!");
        }
    }
}
