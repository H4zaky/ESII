package es2_groupbf.segmentation.scores;

import es2_groupbf.entities.Client;

import java.util.Comparator;
import java.util.List;

public class MonetizationScore implements Score {
    private List<Client> sort(List<Client> clients) {
        clients.sort(Comparator.comparing(Client::getMonetization));
        return clients;
    }

    @Override
    public void calculateScore(List<Client> clients) {
        clients = sort(clients);

        int numberClients = clients.size();
        int q1 = numberClients / 4 - 1;
        int q2 = numberClients / 2 - 1;
        int q3 = q1 + q2 + 1;
        int q4 = numberClients - 1;

        for (int i = 0; i <= q1; i++) clients.get(i).setMonetizationScore(1);
        for (int i = 0; i <= q2; i++) clients.get(i).setMonetizationScore(2);
        for (int i = 0; i <= q3; i++) clients.get(i).setMonetizationScore(3);
        for (int i = 0; i <= q4; i++) clients.get(i).setMonetizationScore(4);
    }
}
