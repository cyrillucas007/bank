package cy20184235.foundation.bank.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InsufficientBallanceException extends RuntimeException{
	public InsufficientBallanceException(String account) {
        super("Insufficient Balance!! Balacnce in accnount "+account+" is less than Rs.500");
    }
}
