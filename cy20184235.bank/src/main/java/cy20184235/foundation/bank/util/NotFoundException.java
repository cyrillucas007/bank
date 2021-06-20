package cy20184235.foundation.bank.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends RuntimeException {


	public NotFoundException(String type, String message) {
		super("Customer with "+type+": "+message+" not found");
	}
}