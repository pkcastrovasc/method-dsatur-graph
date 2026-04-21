public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException(
                    "informe o arquivo de entrada. Ex.: java Main ../dados/brasil.txt"
            );
        }

        In in = new In(args[0]);
        Graph graph = new Graph(in);
        GraphColoringDSatur dsatur = new GraphColoringDSatur(graph);

        StdOut.println("Grafo carregado:");
        StdOut.println(graph);

        dsatur.color();
        int[] order = dsatur.getColoringOrder();
        int totalColors = dsatur.getColorCount();
        boolean valid = dsatur.isValidColoring();

        System.out.println("\nOrdem de coloracao:");
        for (int i = 0; i < order.length; i++) {
            System.out.println(dsatur.getLabel(i) + ": Cor " + order[i]);
        }
        System.out.println("\nTotal de cores utilizadas: " + totalColors);
        System.out.println("\nColoracao valida: " + valid);
    }
}
