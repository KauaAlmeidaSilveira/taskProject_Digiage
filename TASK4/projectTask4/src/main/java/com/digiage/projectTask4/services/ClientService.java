package com.digiage.projectTask4.services;

import com.digiage.projectTask4.domain.Client;
import com.digiage.projectTask4.dto.ClientDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    private final List<Client> clients = new ArrayList<>();

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

                    clients.addAll(Arrays.asList(resultClient));

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                noRepeat++;
            }
        }
    }

    // Retorna uma String mostrando o total de clientes, clientes masculinos e femininos
    public String getQntClientMascAndFem() {
        carregarDados();
        int masc = 0;
        int fem = 0;

        for (Client client : clients) {
            if (client.gender.equals("M")) {
                masc++;
            } else {
                fem++;
            }
        }

        return "Total gender: " + clients.size() + "\nMasculino: " + masc + "\nFeminino: " + fem;
    }

    // Retorna a lista com todos os clientes
    public List<ClientDTO> getAllClients() {
        carregarDados();
        return clients.stream().map(ClientDTO::new).toList();
    }

}

