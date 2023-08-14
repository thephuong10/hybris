package hcmue.edu.vn.facades.exception;

public class EntitySaveOrUpdateException extends RuntimeException{

    public EntitySaveOrUpdateException(final String message){
        super(message);
    }

    public EntitySaveOrUpdateException(){
        super("Entity saves or update failed");
    }

}
