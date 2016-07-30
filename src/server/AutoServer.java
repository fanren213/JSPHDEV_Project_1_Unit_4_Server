/**
 * @author      Bonan Cao <bonanc@andrew.cmu.edu>
 * @Andrew ID   bonanc
 * @Date 		Oct. 07. 2015
 * Interface for servers.
 */
package server;

import model.Automotive;

public interface AutoServer {
	public void addAutoFromClient(Object props);
	public String modelsList();
	public Object sendObjectToClient(String modelName);
}
