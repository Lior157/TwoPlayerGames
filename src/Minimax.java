import java.util.List;

public class Minimax implements ISolver {
    @Override
    public String getSolverName() {
        return "Minimax";
    }

    @Override
    public double solve(IBoard board) {
        Node root = new Node(board, Node.NodeType.MAX);
        return MinimaxAlgorithm(root);
    }


    private double MinimaxAlgorithm(Node node) {
        double value = 0;
        if(node.getNodeChildren().size()==0||node.isTerminalNode()) return node.getScore();
        if(node.getNodeType()== Node.NodeType.MAX){
            value = - Double.MAX_VALUE;
            for (Node child : node.getNodeChildren()){
                value = Math.max(value , MinimaxAlgorithm(child));
            }
            return value;
        }
        value = Double.MAX_VALUE;
        for (Node child : node.getNodeChildren()){
            value = Math.min(value , MinimaxAlgorithm(child ));
        }
        return value;

    }

}
