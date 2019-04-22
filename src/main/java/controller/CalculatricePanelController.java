package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class CalculatricePanelController implements Initializable {
	@FXML
	private TextField textFieldCalcul;
	@FXML
	private TextField textFieldResult;
	@FXML
	private MenuButton menu;

	@FXML
	private Button deleteBtn;
	@FXML
	private Button cBtn;
	@FXML
	private Button ceBtn;

	@FXML
	private Button divideBtn;
	@FXML
	private Button multiplyBtn;
	@FXML
	private Button malusBtn;
	@FXML
	private Button plusBtn;
	@FXML
	private Button equalBtn;

	@FXML
	private Button dotBtn;

	@FXML
	private Button zeroBtn;
	@FXML
	private Button oneBtn;
	@FXML
	private Button twoBtn;
	@FXML
	private Button threeBtn;
	@FXML
	private Button fourBtn;
	@FXML
	private Button fiveBtn;
	@FXML
	private Button sixBtn;
	@FXML
	private Button sevenBtn;
	@FXML
	private Button eightBtn;
	@FXML
	private Button nineBtn;

	private String calculStr = "";
	private String resultStr = "";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Button[][] buttons = { { deleteBtn, cBtn, ceBtn }, { plusBtn, malusBtn, multiplyBtn, divideBtn, equalBtn },
				{ zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, dotBtn } };

		for (Button button : buttons[0]) {
			button.setOnAction(e -> {
				String buttonId = ((Button) e.getSource()).getId();
				switch (buttonId) {
				case "deleteBtn":
					String oldNumberStr = textFieldResult.getText();
					String newNumberStr = "";
					for (int i = 0; i < oldNumberStr.length() - 1; i++) {
						newNumberStr = newNumberStr.concat(String.valueOf(oldNumberStr.charAt(i)));
					}
					textFieldResult.setText(newNumberStr);
					break;
				case "cBtn":
					resultStr = "0";
					calculStr = "";
					textFieldCalcul.setText("");
				case "ceBtn":
					textFieldResult.setText("0");
					break;
				default:
					break;
				}
			});
		}
		for (Button button : buttons[1]) {
			button.setOnAction(e -> {
				operation(((Button) e.getSource()).getId());
			});
		}
		for (Button button : buttons[2]) {
			button.setOnAction(e -> {
				String value = ((Button) e.getSource()).getText();
				if (resultStr.equals(textFieldResult.getText())) {
					textFieldResult.setText("");
				}
				if (value.matches(",")) {
					if (textFieldResult.getText().isEmpty()) {
						textFieldResult.setText(textFieldResult.getText().concat("0."));
					} else {
						textFieldResult.setText(textFieldResult.getText().concat("."));
					}
				} else {
					if (textFieldResult.getText().equals("0")) {
						textFieldResult.setText(value);
					} else {
						textFieldResult.setText(textFieldResult.getText().concat(value));
					}
				}
			});
		}
	}

	private void operation(String signe) {
		String numberStr = null;
		if (0 == Integer.parseInt(textFieldResult.getText())) {
			numberStr = "0";
		} else {
			numberStr = textFieldResult.getText();
		}
		if (signe.equals("plusBtn")) {
			plus(numberStr);
		} else if (signe.equals("malusBtn")) {
			malus(numberStr);
		} else if (signe.equals("multiplyBtn")) {
			multiply(numberStr);
		} else if (signe.equals("divideBtn")) {
			divide(numberStr);
		} else if (signe.equals("equalBtn")) {
			equal(numberStr);
		}
	}

	private void plus(String numberStr) {
		if (!resultStr.isEmpty()) {
			calcul(numberStr);
		} else {
			resultStr = numberStr;
		}
		
		calculStr = calculStr.concat(numberStr.concat(" + "));
		textFieldCalcul.setText(calculStr);
	}

	private void malus(String numberStr) {
		if (!resultStr.isEmpty()) {
			calcul(numberStr);
		} else {
			resultStr = numberStr;
		}
		
		calculStr = calculStr.concat(numberStr.concat(" - "));
		textFieldCalcul.setText(calculStr);
	}

	private void multiply(String numberStr) {
		if (!resultStr.isEmpty()) {
			calcul(numberStr);
		} else {
			resultStr = numberStr;
		}
		
		calculStr = calculStr.concat(numberStr.concat(" x "));
		textFieldCalcul.setText(calculStr);
	}

	private void divide(String numberStr) {
		if (!resultStr.isEmpty()) {
			calcul(numberStr);
		} else {
			resultStr = numberStr;
		}
		
		calculStr = calculStr.concat(numberStr.concat(" ÷ "));
		textFieldCalcul.setText(calculStr);
	}
	
	private void calcul(String numberStr) {
		char operator = calculStr.charAt(calculStr.length() - 2);
		if (Integer.parseInt(numberStr) == Double.parseDouble(numberStr)
				&& Integer.parseInt(resultStr) == Double.parseDouble(resultStr)) {
			switch (operator) {
				case '+':
					resultStr = Integer.toString(Integer.parseInt(resultStr) + Integer.parseInt(numberStr));
					break;
				case '-':
					resultStr = Integer.toString(Integer.parseInt(resultStr) - Integer.parseInt(numberStr));
					break;
				case 'x':
					resultStr = Integer.toString(Integer.parseInt(resultStr) * Integer.parseInt(numberStr));
					break;
				case '÷':
					resultStr = Integer.toString(Integer.parseInt(resultStr) / Integer.parseInt(numberStr));
					break;
				default:
					break;
				}
		} else {
			switch (operator) {
			case '+':
				resultStr = Double.toString(Double.parseDouble(resultStr) + Double.parseDouble(numberStr));
				break;
			case '-':
				resultStr = Double.toString(Double.parseDouble(resultStr) - Double.parseDouble(numberStr));
				break;
			case 'x':
				resultStr = Double.toString(Double.parseDouble(resultStr) * Double.parseDouble(numberStr));
				break;
			case '÷':
				resultStr = Double.toString(Double.parseDouble(resultStr) / Double.parseDouble(numberStr));
				break;
			default:
				break;
			}
		}
		textFieldResult.setText(resultStr);
	}

	private void equal(String numberStr) {
		calcul(numberStr);
		resultStr = "0";
		calculStr = "";
		textFieldCalcul.setText("");
	}
}
