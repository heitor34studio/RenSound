package br.com.alura.RenSound.model;

public enum Tipo {
    SOLO("solo"), DUPLA("dupla"),
    BANDA("banda");
    private final String tipos;
    Tipo (String tipos) {
        this.tipos = tipos;
    }
    public static Tipo fromString(String text) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.tipos.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
