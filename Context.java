
//Reference https://zh.wikipedia.org/wiki/Strategy Pattern.
class Context {

    Strategy strategy;

    // Constructor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        this.strategy.execute();
    }

}
