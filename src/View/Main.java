package View;

import Controller.TabelaController;

public class Main {
    public static void main(String[] args) {
        TabelaController controller= new TabelaController();

        try {
            controller.lerTabela();
            controller.mostraTabela();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
