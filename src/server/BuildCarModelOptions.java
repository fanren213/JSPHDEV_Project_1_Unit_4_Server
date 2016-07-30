/**
 * @author      Bonan Cao <bonanc@andrew.cmu.edu>
 * @Andrew ID   bonanc
 * @Date 		Oct. 07. 2015
 * 
 */
package server;

import java.util.LinkedHashMap;

import adapter.BuildAuto;
import exception.AutoException;
import model.Automotive;

public class BuildCarModelOptions{
	BuildAuto buildAuto = new BuildAuto();
	/* After getting the object, add it to the linkedhashmap */
	public void addAutoFromClient(Object props) {
		buildAuto.addAutoFromClient(props);
	}
	/* Return the models list in string */
	public String modelsList(){
		StringBuffer modelsList = new StringBuffer();
		LinkedHashMap<String, Automotive> autos = buildAuto.getAutos();
		for(String key:autos.keySet()){
			modelsList.append(key + "/n");
		}
		if(modelsList.toString().equals("")){
			modelsList.append("No automobiles in the server.\n");
		}
		return modelsList.toString();
	}
	/* Send a object with given name to the client */
	public Object sendObjectToClient(String modelName){
		try{
			LinkedHashMap<String, Automotive> autos = buildAuto.getAutos();
			if(!autos.containsKey(modelName)){
				throw new AutoException(10);
			}
			else{
				return autos.get(modelName);
			}
		}
		catch(AutoException e){
			e.log();
			System.out.println("Error -- " + e.toString());
			return null;
		}
	}
}
