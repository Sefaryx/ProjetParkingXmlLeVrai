package com.tpparking;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpparking.model.Car;
import com.tpparking.model.Parking;

public class Entry {
	public static void main(String[] args) {

		Parking parking1 = new Parking(1, "Jean Jaures");
		Parking parking2 = new Parking(2, "Capitole");

		parking1.addCar(new Car(11, "VD334JK", "Peugeot", "Rouge"));
		parking1.addCar(new Car(23, "VFERSJK", "Renault", "Bleu"));
		parking1.addCar(new Car(465, "VH342JG", "Ford", "Rouge"));
		parking1.addCar(new Car(52, "DG4T2JK", "Ford", "Bleu"));
		parking1.addCar(new Car(85, "VD332JR", "Peugeot", "Rouge"));

		parking2.addCar(new Car(34, "VD334EK", "Peugeot", "Vert"));
		parking2.addCar(new Car(22, "VFERSAK", "Fiat", "Rouge"));
		parking2.addCar(new Car(624, "VH34HJG", "Ford", "Vert"));
		parking2.addCar(new Car(888, "VDADJR", "Renault", "Rouge"));

		List<Parking> parkings = new ArrayList();
		parkings.add(parking1);
		parkings.add(parking2);

		// Générer le fichier xml
		// les ids de Parking et Car ainsi que immat de Car doivent etre des attributs
		// de Car
		// (On utilisera des balises pour le reste)

		/*
		 * Exemple
		 * 
		 * 
		 * <parkings> <parking id="1"> <name>Capitole</name> <cars> <car id="1"
		 * immat="FJDJJF"> <model>Peugeot</model> <color>Red</color> </car> ... </cars>
		 * </parking> ... </parkings>
		 */

		
		//VERSION XML :
		
//		try {
//			
//			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//			Document doc = docBuilder.newDocument();
//			Element rootElement = doc.createElement("parkings");
//			doc.appendChild(rootElement);
//
//			for (Parking p : parkings) {
//
//				Element parkingElem = doc.createElement("parking");
//				parkingElem.setAttribute("id", Integer.toString(p.getId()));
//				rootElement.appendChild(parkingElem);
//
//				Element nameElem = doc.createElement("name");
//				nameElem.appendChild(doc.createTextNode(p.getName()));
//				parkingElem.appendChild(nameElem);
//
//				Element carsElem = doc.createElement("cars");
//				parkingElem.appendChild(carsElem);
//
//				for (Car c : p.getCars()) {
//
//					Element carElem = doc.createElement("car");
//					carElem.setAttribute("id", Integer.toString(c.getId()));
//					carElem.setAttribute("immat", c.getImmat());
//					carsElem.appendChild(carElem);
//
//					Element modelElem = doc.createElement("model");
//					modelElem.appendChild(doc.createTextNode(c.getModel()));
//					carElem.appendChild(modelElem);
//
//					Element colorElem = doc.createElement("color");
//					colorElem.appendChild(doc.createTextNode(c.getColor()));
//					carElem.appendChild(colorElem);
//					
//				}
//
//				rootElement.appendChild(parkingElem);
//
//			}
//
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer = transformerFactory.newTransformer();
//			DOMSource source = new DOMSource(doc);
//			StreamResult result = new StreamResult(new File("tpparking.xml"));
//			transformer.transform(source, result);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//VERSION JSON AUTO :
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File("tpParkingAuto.json"), parkings);
			TypeReference<ArrayList<Parking>> typeRef = new TypeReference<ArrayList<Parking>>() {};
			List<Parking> parkings2 = mapper.readValue(new File("tpParkingAuto.json"), typeRef);
			System.out.println(parkings2);
			System.out.println(parkings2.get(0).getCars());
//			System.out.println(parkings2.get(0).getCars().get(0).getId());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}