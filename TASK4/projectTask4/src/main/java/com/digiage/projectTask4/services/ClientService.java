package com.digiage.projectTask4.services;

import com.digiage.projectTask4.domain.Client;
import com.digiage.projectTask4.dto.ClientDTO;
import com.digiage.projectTask4.dto.ResultDTO;
import com.digiage.projectTask4.repositories.ClientRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Value("${api.url}")
    private String url;

    private int noRepeat = 0;

    // Metodo responsavel por carregar os dados e salvar na lista clients
    public void carregarDados() {
        if (noRepeat == 0) {
            try {
                URL url = new URL(this.url);

                HttpURLConnection conec = (HttpURLConnection) url.openConnection();

                conec.setRequestMethod("GET");

                int statusResp = conec.getResponseCode();

                // Caso código da requisição seja 200, é feito a leitura, append no StringBuilder, conversão de string
                // para json e adicionado na lista.
                if (statusResp == HttpURLConnection.HTTP_OK) {
                    BufferedReader leitor = new BufferedReader(new InputStreamReader(conec.getInputStream()));
                    StringBuilder resp = new StringBuilder();
                    String linha;

                    while ((linha = leitor.readLine()) != null) {
                        resp.append(linha);
                    }

                    leitor.close();

                    Gson gson = new Gson();
                    Client[] resultClient = gson.fromJson(resp.toString(), Client[].class);

                    clientRepository.saveAll(Arrays.asList(resultClient));

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                noRepeat++;
            }
        }
    }

    // Retorna uma String mostrando o total de clientes, clientes masculinos e femininos
    public ResultDTO getQntClientMascAndFem() {
        int masc = 0;
        int fem = 0;

        int size = clientRepository.findAll().size();

        if (size != 0) {
            for (Client client : clientRepository.findAll()) {
                if (client.gender.equals("M")) {
                    masc++;
                } else {
                    fem++;
                }
            }

            ResultDTO resultDTO = new ResultDTO(size, masc, fem);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/digiage/projectTask4/files/result.json"));
                writer.write(resultDTO.toString());
                writer.close();
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

            return resultDTO;
        }
        return null;
    }

    // Retorna a lista com todos os clientes
    public List<ClientDTO> findAll() {
        carregarDados();
        return clientRepository.findAll().stream().map(ClientDTO::new).toList();
    }

}

