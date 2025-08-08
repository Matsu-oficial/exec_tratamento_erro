import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<Sensor> sensoresValidos;
    private List<ErroSensor> sensoresComErro;

    public SistemaMonitoramento() {
        this.sensoresValidos = new ArrayList<>();
        this.sensoresComErro = new ArrayList<>();
    }

    public void exibirRelatorio(){
        System.out.println("====== Sensores Válidos ======");
        for (Sensor sensor : sensoresValidos){
            System.out.println("Sensor: " + sensor.getId());
        }

        System.out.println("====== Sensores Inválidos ======");
        for (ErroSensor sensor : sensoresComErro){
            System.out.println("Sensor: " + sensor.getIdSensor());
            System.out.println("Erro ocasionado: " + sensor.getMensagemErro());
        }
    }

    public void processarSensores(List<Sensor> listaSensor, List<List<Double>> listaLeitura){
        for (int i = 0; i < listaSensor.size(); i++) {
            Sensor sensor = listaSensor.get(i);
            List<Double> lista = listaLeitura.get(i);
            try {
                sensor.registrarLeituras(lista);
                sensoresValidos.add(sensor);
            }
            catch (LeituraInvalidaException | IllegalArgumentException e) {
                sensoresComErro.add(new ErroSensor(sensor.getId(), e.getMessage()));
            }
        }
    }
}


