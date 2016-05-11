/*
 * Copyright (C) Christian Katzorke <ckatzorke@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.ckatzorke.spring.security.password.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 * A {@link PasswordEncoder} for Argon2. It uses the Argon2 binding for jvm from
 * <a href="https://github.com/phxql/argon2-jvm">https://github.com/phxql/argon2
 * -jvm</a>
 * 
 * @author Christian Katzorke ckatzorke@gmail.com
 *
 */
public class Argon2PasswordEncoder implements PasswordEncoder {

	private static final Argon2 ARGON2 = Argon2Factory.create();
	
	private static final int ITERATIONS = 2;
	private static final int MEMORY= 65536;
	private static final int PARALLELISM = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.crypto.password.PasswordEncoder#encode(java.
	 * lang.CharSequence)
	 */
	public String encode(final CharSequence rawPassword) {
		//hash returns already the encoded String
		final String hash = ARGON2.hash(ITERATIONS, MEMORY, PARALLELISM, rawPassword.toString());
		return hash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.crypto.password.PasswordEncoder#matches(java
	 * .lang.CharSequence, java.lang.String)
	 */
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return ARGON2.verify(rawPassword.toString(), encodedPassword);
	}

}
