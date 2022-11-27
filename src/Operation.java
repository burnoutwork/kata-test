class Operation {
    private final boolean isRoman;
    private final OperationKind operationKind;
    private final int firstNumber;
    private final int secondNumber;

    Operation(boolean isRoman, OperationKind operationKind, int firstNumber, int secondNumber) {
        this.isRoman = isRoman;
        this.operationKind = operationKind;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    protected int calculate() throws Exception {
        int result = 0;

        switch (this.operationKind) {
            case PLUS -> result = this.firstNumber + this.secondNumber;
            case MINUS -> result = this.firstNumber - this.secondNumber;
            case MULTIPLY -> result = this.firstNumber * this.secondNumber;
            case DIVIDE -> result = this.firstNumber / this.secondNumber;
        }

        if (this.isRoman && result < 1) {
            throw new Exception();
        }

        return result;
    }

    protected boolean isRoman() {
        return this.isRoman;
    }
}
