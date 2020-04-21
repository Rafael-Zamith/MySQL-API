package br.mack.ps2.interfaces;

import java.util.List;
import java.util.Scanner;

import br.mack.ps2.persistencia.ComputadorDAO;
import br.mack.ps2.*;



public class UserInterfaceComputadores {
    ComputadorDAO dao;
    Scanner in;

    public UserInterfaceComputadores(ComputadorDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);

    }

    public void Start() {
        printMenu();
    }

    private void printMenu() {

        int op = 0;
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
            op = in.nextInt();
            in.nextLine();

            switch (op) {
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
        } while (op != 5);
    }
    
    private void create() {
        Computador computador = new Computador();

        System.out.println("informe o id do computador: ");
        computador.setId(in.nextInt());
        System.out.println("Informe a marca do computador: ");
        computador.setMarca(in.next());
        System.out.println("Informe o processador do computador: ");
        computador.setProcessador(in.nextInt());
        System.out.println("Informe o tamanho da RAM do computador: ");
        computador.setRAM(in.nextInt());
        System.out.println("Informe o tamanho do disco do computador: ");
        computador.setDiskSize(in.nextInt());

        if (dao.create(computador))
            System.out.println("Criado com sucesso");
        else
            System.out.println("Não foi possivel criar");
        

    }

    private void read() {
        List<Computador> computadores = dao.read();
        for (int i = 0; i < computadores.size(); i++) {
            System.out.println(computadores.get(i));
        }

    }

    private void update() {
        Computador computador = new Computador();

        System.out.println("informe o id da computador: ");
        computador.setId(in.nextInt());
        System.out.println("Informe a marca do computador: ");
        computador.setMarca(in.next());
        System.out.println("Informe o processador do computador: ");
        computador.setProcessador(in.nextInt());
        System.out.println("Informe o tamanho da RAM do computador: ");
        computador.setRAM(in.nextInt());
        System.out.println("Informe o tamanho do disco do computador: ");
        computador.setDiskSize(in.nextInt());
        
        if (dao.update(computador))
            System.out.println("Criado com sucesso");
        else
            System.out.println("Não foi possivel criar");

    }

    private void delete() {
        System.out.println("Digite o id do computador que deseja apagar: ");
        int id = in.nextInt();
        List<Computador> computadors = dao.read();
        int i;
        for (i = 0; i < computadors.size(); i++) {
            if (id == computadors.get(i).getId()) {
                System.out.println("Achamos esse computador: ");
                System.out.println(computadors.get(i));
            } else
                System.out.println("Não encontramos nenhum computador com o mesmo id! ");
        }
        System.out.println("Deseja realmente apagá-lo? ");
        System.out.println("1. sim");
        System.out.println("2. não");
        int op1 = in.nextInt();
        if (op1 == 1) {
            if (dao.delete(computadors.get(i)))
                System.out.println("Computador excluido com sucesso! ");
            else
                System.out.println("Não foi possivel excluir! ");
        }
        else
            System.out.println("O computador não será apagada! ");
    }
}