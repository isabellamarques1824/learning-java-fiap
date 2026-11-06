package br.com.fiap.main;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PokemonHashMap {

    public static void main(String[] args) {

        HashMap<String, String> pokemons = new HashMap<>();

        int continuar;

        do {
            try {
                String pokemon, tipo;

                // Cadastro de Pokémons
                do {
                    pokemon = JOptionPane.showInputDialog(
                            "Digite o nome do Pokémon ou FIM para encerrar:"
                    );

                    if (pokemon == null) {
                        return;
                    }

                    pokemon = pokemon.trim().toUpperCase();

                    if (!pokemon.equals("FIM")) {

                        if (pokemon.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Digite um nome válido!");
                            continue;
                        }

                        if (pokemons.containsKey(pokemon)) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Já existe esse Pokémon!"
                            );

                        } else {

                            tipo = JOptionPane.showInputDialog(
                                    "Digite o tipo do Pokémon:"
                            );

                            if (tipo == null) {
                                return;
                            }

                            tipo = tipo.trim().toLowerCase();

                            if (tipo.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Digite um tipo válido!");
                                continue;
                            }

                            pokemons.put(pokemon, tipo);
                        }
                    }

                } while (!pokemon.equals("FIM"));

                // Buscar por tipo
                String escolhaTipo = JOptionPane.showInputDialog(
                        "Digite o tipo de Pokémon que deseja buscar:"
                );

                if (escolhaTipo == null) {
                    break;
                }

                escolhaTipo = escolhaTipo.trim().toLowerCase();

                String message = "Tipo: " + escolhaTipo + "\n\n";

                boolean encontrou = false;

                for (Map.Entry<String, String> entry : pokemons.entrySet()) {

                    if (escolhaTipo.equals(entry.getValue())) {

                        message += entry.getKey() + "\n";
                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    message += "Nenhum Pokémon encontrado!";
                }

                JOptionPane.showMessageDialog(
                        null,
                        message,
                        "Resultado da busca",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Ocorreu um erro: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            continuar = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja continuar?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION
            );

        } while (continuar == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(
                null,
                "Programa encerrado! Até logo!",
                "Encerrando",
                JOptionPane.WARNING_MESSAGE
        );
    }
}