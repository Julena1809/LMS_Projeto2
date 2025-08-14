package ada.tech.lms.domain;
//bibliotecas necessárias para salvar em .txt

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class User {
    private String cpf;
    private String name;

    public User(String id, String name) {
        this.cpf = id;
        this.name = name;
    }

    public String getCpf() { return cpf; }
    public String getName() { return name; }

    //salvar em arquivo .txt

    public void salvarEmArquivo(){
        String nomeArquivo = "usuario_"+ cpf+".txt";
        File arquivo = new File(nomeArquivo);

    //verificar se já existe esse CPF no cadastro

        if(arquivo.exists()){
            System.out.println("Já existe uma conta com esse CPF: "+cpf);
            return;

        }
        try(FileWriter escritor = new FileWriter(arquivo)){
            escritor.write("nome: "+ name +"\n");
            escritor.write("CPF"+cpf+"\n");
            System.out.println("Arquivo"+ nomeArquivo + "criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o arquivo"+e.getMessage());
        }

    }
}