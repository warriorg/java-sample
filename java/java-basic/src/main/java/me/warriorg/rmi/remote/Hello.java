package me.warriorg.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author warrior
 */
public interface Hello extends Remote {
    /***
     *
     * @return
     */
    String sayHello() throws RemoteException;
}
