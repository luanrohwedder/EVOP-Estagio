import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalculadoraController {
    @FXML
    private Button btnCalcular;
    @FXML
    private TextField insumoArgamassa;
    @FXML
    private TextField insumoPedreiro;
    @FXML
    private TextField insumoServente;
    @FXML
    private TextField isnumoTijolo;
    @FXML
    private TextField muroAltura;
    @FXML
    private TextField muroComprimento;
    @FXML
    private Text relatorioArgamassa;
    @FXML
    private Text relatorioPedreiro;
    @FXML
    private Text relatorioServente;
    @FXML
    private Text relatorioTijolo;
    @FXML
    private Text valorTotal;
    @FXML
    private Text errorText;    

    private Double argamassa;
    private Double pedreiro;
    private Double servente;
    private Double tijolo;
    private Double altura;
    private Double comprimento;
    private Double total;
    /*
     * Métodos dos eventos do layout
    */

    @FXML
    void CalcularMuro(ActionEvent event) {                                
        if(valid()) {
            errorText.setText("");
            
            //Insumos        
            argamassa = Double.parseDouble(insumoArgamassa.getText()); 
            pedreiro = Double.parseDouble(insumoPedreiro.getText());  
            servente = Double.parseDouble(insumoServente.getText());  
            tijolo = Double.parseDouble(isnumoTijolo.getText());          

            //Muro
            altura = Double.parseDouble(muroAltura.getText()); 
            comprimento = Double.parseDouble(muroComprimento.getText()); 
            
            Double tamanhoMuro = altura * comprimento;
            
            //Resultado dos calculos            
            total = calcularAlvenaria(tamanhoMuro, argamassa, pedreiro, servente, tijolo) + calcularEmboco(tamanhoMuro, argamassa, pedreiro, servente);

            //Exibindo os resultados
            relatorioArgamassa.setText(String.format("%.0f ", 10 * tamanhoMuro + 40 * (tamanhoMuro * 2)));
            relatorioPedreiro.setText(String.format("%.0f horas", 0.8 * tamanhoMuro + 0.5 * (tamanhoMuro * 2)));
            relatorioServente.setText(String.format("%.0f horas", 0.8 * tamanhoMuro + 0.5 * (tamanhoMuro * 2)));
            relatorioTijolo.setText(String.format("%.0f", 21 * tamanhoMuro));
            valorTotal.setText(String.format("R$ %.2f", total));                  
        } else {            
            errorText.setText("Preencha os campos correntamente!");
        }
    }

    Double calcularAlvenaria(Double tamanho, Double argamassa, Double pedreiro, Double servente, Double tijolo) {        
        Double precoTijolo = tijolo * (21 * tamanho);
        Double precoArgamassa = argamassa * (10 * tamanho);
        Double precoPedreiro = pedreiro * (0.8 * tamanho);
        Double precoServente = servente * (0.8 * tamanho);        

        return precoArgamassa + precoPedreiro + precoServente + precoTijolo;
    }

    Double calcularEmboco(Double tamanho, Double argamassa, Double pedreiro, Double servente) {
        Double tamanhoEmboco = tamanho * 2;
        
        Double precoArgamassa = argamassa * (40 * tamanhoEmboco);
        Double precoPedreiro = pedreiro * (0.5 * tamanhoEmboco);
        Double precoServente = servente * (0.5 * tamanhoEmboco);

        return precoArgamassa + precoPedreiro + precoServente;
    }
    
    boolean validInput2(TextField field) {
        String regex = "(\\d+)(\\.\\d{0,2})?";
        if(!field.getText().matches(regex)){            
            return false;
        }

        return true;
    }
    
    boolean valid() {
        if(validInput2(insumoArgamassa) && validInput2(insumoPedreiro) && validInput2(insumoServente) && validInput2(isnumoTijolo) && validInput2(muroAltura) && validInput2(muroComprimento)) {
            return true;
        }

        return false;
    }
}
