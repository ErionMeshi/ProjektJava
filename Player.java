class Player{
    private static final String figura = "*_*";


    public static String getFigura() {
        return figura;
    }


    @Override 
    public String toString() {
        return getFigura();
    }
}