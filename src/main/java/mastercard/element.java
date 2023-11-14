package mastercard;

enum Element {
    HELIUM("He", "Gas"),
    MAGNESIUM("Mg", "Solid");

    private String chemicalSymbol;
    private String naturalState;

    private Element(String newChemicalSymbol, String naturalState) {
        chemicalSymbol = newChemicalSymbol;
        this.naturalState = naturalState;
    }

    public String chemicalSymbol() {
        return chemicalSymbol;
    }

    public String naturalState() {
        return naturalState;
    }
}