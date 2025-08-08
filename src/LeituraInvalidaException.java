public class LeituraInvalidaException extends Exception {
    public LeituraInvalidaException(int posicao, double temperatura){
        super("Leitura invalida na posição " + posicao + ": " + temperatura + "°C");
    }
}
