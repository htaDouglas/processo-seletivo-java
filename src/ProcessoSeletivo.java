import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};
        double salarioBase = 2000.0;

        // Case 1: Controle de fluxo para decidir se deve ligar para o candidato baseado no salário pretendido.
        for (String candidato : candidatos) {
            double salarioPretendido = valorPretendido();
            if (salarioBase > salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO: " + candidato);
            } else if (salarioBase == salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA: " + candidato);
            } else {
                System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS: " + candidato);
            }
        }

        // Case 2: Selecionar no máximo 5 candidatos cujo salário pretendido seja menor ou igual ao salário base.
        List<String> candidatosSelecionados = new ArrayList<>();
        for (String candidato : candidatos) {
            double salarioPretendido = valorPretendido();
            if (salarioPretendido <= salarioBase && candidatosSelecionados.size() < 5) {
                candidatosSelecionados.add(candidato);
            }
        }

        // Case 3: Imprimir a lista dos candidatos selecionados.
        System.out.println("\nCandidatos Selecionados:");
        for (String candidato : candidatosSelecionados) {
            System.out.println(candidato);
        }

        // Case 4: Realizar até 3 tentativas de ligação para cada candidato selecionado.
        for (String candidato : candidatosSelecionados) {
            boolean conseguiuContato = false;
            for (int tentativa = 1; tentativa <= 3; tentativa++) {
                if (realizarLigacao()) {
                    System.out.printf("CONSEGUIMOS CONTATO COM %s APÓS %d TENTATIVA(S)%n", candidato, tentativa);
                    conseguiuContato = true;
                    break;
                }
            }
            if (!conseguiuContato) {
                System.out.printf("NÃO CONSEGUIMOS CONTATO COM %s%n", candidato);
            }
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean realizarLigacao() {
        // Simulação de sucesso/fracasso da ligação
        return ThreadLocalRandom.current().nextBoolean();
    }
}
