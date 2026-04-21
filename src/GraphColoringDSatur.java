import org.w3c.dom.Node;

import java.util.*;

public class GraphColoringDSatur {
    private final Graph graph;
    ArrayList<Integer> defColors = new ArrayList<>();


    public GraphColoringDSatur(Graph graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph não pode ser nulo.");
        }
        this.graph = graph;
    }

    class NodeInfo {
        int saturation;
        int degree;
        int vertex;
        int color;
        NodeInfo(int saturation, int degree, int vertex, int color) {
            this.saturation = saturation;
            this.degree = degree;
            this.vertex = vertex;
            this.color = color;
        }
    }

    class MaxSaturation implements Comparator<NodeInfo> {
       @Override public int compare(NodeInfo lhs, NodeInfo rhs) {
           if  (lhs.saturation != rhs.saturation) {
               return Integer.compare(lhs.saturation, rhs.saturation);
           }

           else if (lhs.degree != rhs.degree) {
               return Integer.compare(lhs.degree, rhs.degree);
           }
           else {
               return Integer.compare(lhs.vertex, rhs.vertex);
           }
       }
    }

    public Graph getGraph() {
        return graph;
    }

    public void color() {
        int u;
        int v;

        boolean[] used = new boolean[graph.V()];
        int[] colors = new int[graph.V()];
        int[] degrees = new int[graph.V()];
        HashSet<Integer>[] visited = new HashSet[graph.V()];
        PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>(new MaxSaturation());

        for (u = 0; u < graph.V(); u++) {
            colors[u] = -1;
            degrees[u] = graph.degree(u);
            visited[u] = new HashSet<>();
            pq.add(new NodeInfo(0, degrees[u], u, colors[u]));

        }

        while  (!pq.isEmpty()) {
            NodeInfo maxPtr = pq.poll();
            u = maxPtr.vertex;

            for (int i : graph.adj(u)) {
                if (colors[i] != -1) {
                    used[colors[i]] = true;
                }
            }

            for (v = 0; v < used.length; v++) {
                if (!used[v]) {
                    break;
                }
            }

            for (int i : graph.adj(u)) {
                if (colors[i] != -1) {
                    used[colors[i]] = false;
                }
            }
            colors[u] = v;
            for (int i : graph.adj(u)) {
                if (colors[i] == -1) {
                    pq.remove(new NodeInfo(visited[i].size(), degrees[i], i, colors[i]));
                    visited[i].add(i);
                    degrees[i]--;

                    pq.add(new NodeInfo(visited[i].size(), degrees[i], i, colors[i]));
                }
            }

            for (u = 0; u < graph.V(); u++) {
                System.out.println(getLabel(u) + " Cor: " + colors[u]);
                defColors.add(colors[u]);
            }

            while (defColors.size() > graph.V()) {
                defColors.remove(0);
            }

        }
    }

    public int getColor(int vertex) {
        return  defColors.get(vertex);
    }

    public int getColorCount() {
        int nColors = 0;
        for (int i = 0; i  < graph.V(); i++) {
            if (nColors < defColors.get(i)) {
                nColors = defColors.get(i);
            }
        }

        return nColors;
    }

    public int[] getColoringOrder() {
        int[] order = new int[graph.V()];
        for (int i = 0; i  < graph.V(); i++) {
            order[i] = defColors.get(i);
        }

        return order;
    }

    public boolean isValidColoring() {

        for (int i = 0; i  < graph.V(); i++) {
            List<Integer> adjList = new ArrayList<>();
            for (Integer adj : graph.adj(i)) {
               adjList.add(adj);
            }

            for (int j = 0; j  < adjList.size(); j++) {
                if (defColors.get(i) == defColors.get(adjList.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getLabel(int vertex) {
        return "Vertice " + vertex;
    }
}
