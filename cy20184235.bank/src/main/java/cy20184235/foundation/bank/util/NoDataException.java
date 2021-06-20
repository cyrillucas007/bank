package cy20184235.foundation.bank.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoDataException extends RuntimeException{
    public NoDataException(String message) {
        super("No Product records: "+message);
    }
}
