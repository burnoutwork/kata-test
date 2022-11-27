enum OperationKind {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    static OperationKind fromString(String input) throws Exception {
        return switch (input) {
            case "+" -> OperationKind.PLUS;
            case "-" -> OperationKind.MINUS;
            case "*" -> OperationKind.MULTIPLY;
            case "/" -> OperationKind.DIVIDE;
            default -> throw new Exception();
        };
    }
}
