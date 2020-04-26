package br.mack.ps2.interfaces;

import java.util.List;
import java.util.Scanner;

import br.mack.ps2.persistencia.ContaDAO;
import br.mack.ps2.*;



public class UserInterfaceContas {
    ContaDAO dao;
    Scanner in;

    public UserInterfaceContas(ContaDAO dao) {
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
        Conta conta = new Conta();

        List<Conta> contas = dao.read();
        if(contas.size()>0)
            conta.setId(1+(contas.get(contas.size()-1).getId()));
        else
            conta.setId(0);
        System.out.println("Informe o nome do dono da conta: ");
        conta.setNome(in.next());
        System.out.println("Informe a agencia da conta: ");
        conta.setAgencia(in.nextInt());
        System.out.println("Informe o saldo da conta: ");
        conta.setSaldo(in.nextBigDecimal());

        if (dao.create(conta))
            System.out.println("Criado com sucesso");
        else
            System.out.println("Não foi possivel criar");
    }

    private void read() {
        List<Conta> contas = dao.read();
        for (int i = 0; i < contas.size(); i++) {
            System.out.println("======================");
            System.out.println(contas.get(i));
        }

    }

    private void update() {
        Conta conta = new Conta();

        System.out.println("informe o id da conta: ");
        conta.setId(in.nextInt());
        System.out.println("Informe o nome do dono da conta: ");
        conta.setNome(in.next());
        System.out.println("Informe a agencia da conta: ");
        conta.setAgencia(in.nextInt());
        System.out.println("Informe o saldo da conta: ");
        conta.setSaldo(in.nextBigDecimal());

        if (dao.update(conta))
            System.out.println("Criado com sucesso");
        else
            System.out.println("Não foi possivel criar");

    }

    private void delete() {
        System.out.println("digite o id da conta que deseja apagar: ");
        int id = in.nextInt();

        List<Conta> contas = dao.read();

        int i;
        boolean found = false;
        for (i = 0; i < contas.size(); i++) {
            if (id == contas.get(i).getId()) {
                System.out.println("Achamos essa conta: ");
                System.out.println(contas.get(i));
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("não encontramos nenhuma conta com o mesmo id! ");

        System.out.println("DEseja realmente apaga-la? ");
        System.out.println("1. sim");
        System.out.println("2. não");
        int op1 = in.nextInt();
        if (op1 == 1) {
            if (dao.delete(contas.get(i)))
                System.out.println("Conta excluida com sucesso! ");
            else
                System.out.println("Não foi possivel excluir! ");
        }
        else
            System.out.println("A conta não será apagada! ");
    }
}