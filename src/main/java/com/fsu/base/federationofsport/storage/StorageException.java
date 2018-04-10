package com.fsu.base.federationofsport.storage;

/**
 * Created by yana on 10.04.18.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
