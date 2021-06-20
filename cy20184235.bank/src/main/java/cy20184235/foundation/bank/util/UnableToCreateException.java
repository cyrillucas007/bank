package cy20184235.foundation.bank.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnableToCreateException extends RuntimeException {
	public UnableToCreateException(String conflictData) {
		super("Unable to create. A Customer with conflictData (PAN): "+ conflictData + " already exist");
	}
}
