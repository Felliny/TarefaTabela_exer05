package Controller;

import Biblioteca.ListaObject.Lista;

import java.io.*;

public class TabelaController {

    Lista[] vetTabela;

    public TabelaController(){
        vetTabela= new Lista[5];
        for (int i=0; i<5; i++){
            vetTabela[i]= new Lista();
        }
    }

    private int hashcode(int valor){
        int posicao= valor % 5;
        return posicao;
    }

    public void adiciona(int valor) throws Exception{
        int hash= hashcode(valor);
        Lista l= vetTabela[hash];
        if (l.isEmpty()){
            l.addFirst(valor);
        }
        else {
            l.addLast(valor);
        }
    }

    public void lerTabela() throws Exception {
        File file= new File("D:\\TEMP", "TabelaTeste.csv");
        if (file.exists() && file.isFile()){
            FileInputStream abreFluxoArq = new FileInputStream(file);
            InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
            BufferedReader buffer = new BufferedReader(leitorFluxo);
            String linha = buffer.readLine();
            while (linha != null){
                String[] vet= linha.split(";");
                int tamanho= vet.length;
                for (int i=1; i<tamanho; i++){
                    adiciona(Integer.parseInt(vet[i]));
                }
                linha= buffer.readLine();
            }
        }
        else {
            throw new IOException("Arquivo inválido!");
        }
    }

    public void mostraTabela() throws Exception{
        String tabela= "";
        StringBuffer buffer= new StringBuffer(tabela);
        for (int i=0; i<5; i++){
            Lista l= vetTabela[i];
            int tamanho= l.size();
            tabela= String.valueOf(buffer.append(i));
            for (int j=0; j<tamanho; j++){
                tabela= String.valueOf(buffer.append("\t"+ l.get(j)));
            }
            tabela= String.valueOf(buffer.append("\n"));
        }
        System.out.println(tabela);

    }
}
