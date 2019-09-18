package com.tpparking;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tpparking.model.Parking;

public class Entry2 {

	public static void main(String[] args) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("tpparking.xml"));

			Element rootElement = doc.getDocumentElement();
			NodeList rootNodes = rootElement.getChildNodes();

			List<Parking> parkings = new ArrayList<Parking>();

			for (int i = 0; i < rootNodes.getLength(); i++) {

				if (rootNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {

					Node actualNode = rootNodes.item(i);
					Element actualElem = (Element) rootNodes.item(i);
					int parkingId = Integer.parseInt(actualElem.getAttribute("id"));
					NodeList elemNodes = actualElem.getChildNodes();

					String parkingName = "";
					for (int j = 0; j < elemNodes.getLength(); j++) {
						if (elemNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
							parkingName = elemNodes.item(j).getTextContent();
							break;
						}
					}

					System.out.println(parkingId);
					System.out.println(parkingName);

				}

//				parkings.add(new Parking)
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
